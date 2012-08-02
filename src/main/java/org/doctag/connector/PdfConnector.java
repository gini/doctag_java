package org.doctag.connector;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.doctag.Generator;
import org.doctag.Parser;
import org.doctag.domain.Document;
import org.doctag.exception.ConnectorException;
import org.doctag.exception.DataNotFoundException;
import org.doctag.exception.InvalidDataException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * A docTag connector which handles reading and writing docTag meta data in PDF documents using the
 * <a href="http://pdfbox.apache.org/">Apache PDFBox</a> library.
 *
 * @author Jochen Schalanda
 */
public class PdfConnector extends Connector {

    /**
     * The name of the property field inside the PDF document which contains the docTag meta data.
     */
    private static final String DOCTAG_FIELD_NAME = "doctag";

    private PDDocument pdfDocument;
    private final Parser parser;
    private final Generator generator;

    /**
     * Create a new instance of PdfConnector.
     *
     * @param inputStream The input stream containing the PDF data which will be processed
     * @throws ConnectorException If the input stream couldn't be read or doesn't contain a PDF document
     */
    public PdfConnector(final InputStream inputStream) throws ConnectorException {
        this(inputStream, new Parser(), new Generator());
    }

    /**
     * Create a new instance of PdfConnector.
     *
     * @param inputStream The input stream containing the PDF data which will be processed
     * @param parser      The parser which is being used to parse the docTag meta data from the JSON format
     * @param generator   The generator which is being used to generate the docTag meta data JSON format
     * @throws ConnectorException If the input stream couldn't be read or doesn't contain a PDF document
     */
    public PdfConnector(final InputStream inputStream, final Parser parser, final Generator generator)
            throws ConnectorException {

        super(inputStream);

        assert parser != null;
        assert generator != null;

        this.parser = parser;
        this.generator = generator;

        try {
            this.pdfDocument = PDDocument.load(this.inputStream);
        } catch (IOException e) {
            throw new ConnectorException("Couldn't load PDF document from input stream", e);
        }
    }

    @Override
    /**
     * Read data from the input stream, parse it, and return a new docTag meta data document.
     *
     * @return The parsed docTag meta data
     * @throws DataNotFoundException If the input stream doesn't contain any docTag meta data
     * @throws InvalidDataException  If the input stream doesn't contain any valid docTag meta data
     */
    public Document read() throws DataNotFoundException, InvalidDataException {

        Document result;

        PDDocumentInformation documentInformation = pdfDocument.getDocumentInformation();
        String embeddedDocTag = documentInformation.getCustomMetadataValue(DOCTAG_FIELD_NAME);

        if (null == embeddedDocTag) {

            throw new DataNotFoundException("Couldn't find meta data field " + DOCTAG_FIELD_NAME);
        }

        InputStream embeddedDocTagStream = new ByteArrayInputStream(embeddedDocTag.getBytes());

        try {
            result = parser.parse(embeddedDocTagStream);
        } catch (IOException e) {
            throw new InvalidDataException("Couldn't parse embedded docTag data", e);
        }

        return result;
    }

    @Override
    /**
     * Write the data read from the input stream back into an output stream while updating the docTag meta data inside.
     *
     * @param outputStream The {@link OutputStream} in which the modified original data is being written
     * @param document     The docTag meta data document which should be written into the originally read data
     * @throws ConnectorException   If an error occurred while writing to the output stream
     * @throws InvalidDataException if the docTag meta data document contains invalid data
     */
    public void write(final OutputStream outputStream, final Document document)
            throws ConnectorException, InvalidDataException {

        String docTagJson;

        try {
            docTagJson = generator.generate(document);

        } catch (IOException e) {
            throw new InvalidDataException("Couldn't generate docTag data", e);
        }

        PDDocumentInformation documentInformation = pdfDocument.getDocumentInformation();
        documentInformation.setCustomMetadataValue(DOCTAG_FIELD_NAME, docTagJson);

        try {
            pdfDocument.save(outputStream);
        } catch (IOException e) {
            throw new ConnectorException("Couldn't write PDF document to output stream", e);
        } catch (COSVisitorException e) {
            throw new ConnectorException("Corrupt PDF data", e);
        }
    }

    @Override
    protected void finalize() throws Throwable {

        pdfDocument.close();

        super.finalize();
    }
}
