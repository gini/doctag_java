package org.doctag.connector;

import org.doctag.Generator;
import org.doctag.Parser;
import org.doctag.domain.Document;
import org.doctag.exception.ConnectorException;
import org.doctag.exception.DataNotFoundException;
import org.doctag.exception.InvalidDataException;
import org.doctag.helper.FailingOutputStream;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit tests for {@link PdfConnector}.
 *
 * @author Jochen Schalanda
 */
public class PdfConnectorTest {

    private Parser parser;
    private Generator generator;

    @Before
    public void setUp() {
        parser = new Parser();
        generator = new Generator();
    }

    @Test(expected = DataNotFoundException.class)
    public void readShouldThrowAnExceptionIfMetadataIsMissing() throws ConnectorException, InvalidDataException, DataNotFoundException {

        InputStream docWithoutMetadata = getClass().getResourceAsStream("/doc_without_metadata.pdf");

        PdfConnector connector = new PdfConnector(docWithoutMetadata, parser, generator);
        connector.read();
    }

    @Test(expected = InvalidDataException.class)
    public void readShouldThrowAnExceptionIfMetadataIsInvalid() throws ConnectorException, InvalidDataException, DataNotFoundException {

        InputStream docWithCorruptMetadata = getClass().getResourceAsStream("/doc_with_corrupt_metadata.pdf");

        PdfConnector connector = new PdfConnector(docWithCorruptMetadata, parser, generator);
        connector.read();
    }

    @Test(expected = ConnectorException.class)
    public void readShouldThrowAnExceptionIfDocumentIsNoPdf() throws ConnectorException, InvalidDataException, DataNotFoundException {

        InputStream invalidInputStream = getClass().getResourceAsStream("/doctag_from_spec.json");

        new PdfConnector(invalidInputStream, parser, generator);
    }

    @Test(expected = ConnectorException.class)
    public void readShouldThrowAnExceptionIfOutputStreamFails() throws ConnectorException, InvalidDataException, DataNotFoundException {

        InputStream docWithMetadata = getClass().getResourceAsStream("/doc_with_metadata.pdf");

        PdfConnector connector = new PdfConnector(docWithMetadata, parser, generator);

        Document document = connector.read();
        connector.write(new FailingOutputStream(), document);
    }

    @Test
    public void readShouldReturnValidDocument() throws ConnectorException, InvalidDataException, DataNotFoundException {

        InputStream docWithMetadata = getClass().getResourceAsStream("/doc_with_metadata.pdf");

        PdfConnector connector = new PdfConnector(docWithMetadata, parser, generator);

        Document document = connector.read();

        assertNotNull(document);
        assertEquals("invoice", document.getType());
        assertEquals("0.9", document.getVersion());
    }
}
