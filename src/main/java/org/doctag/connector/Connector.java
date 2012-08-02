package org.doctag.connector;

import org.doctag.domain.Document;
import org.doctag.exception.ConnectorException;
import org.doctag.exception.DataNotFoundException;
import org.doctag.exception.InvalidDataException;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Common base class for all docTag connectors.
 * <p/>
 * A connector processes data in a specific format from streams (e. g. file streams or network streams) and handles
 * reading and writing docTag meta data from and to the streams.
 * <p/>
 * Typically there's one connector for each kind of file format supported.
 *
 * @author Jochen Schalanda
 */
public abstract class Connector {

    protected final InputStream inputStream;

    /**
     * Create a new connector instance processing data from the provided {@link InputStream}.
     *
     * @param inputStream The input stream which will be processed
     * @throws ConnectorException If the input stream couldn't be read or the format is not supported by this connector
     */
    public Connector(final InputStream inputStream) throws ConnectorException {

        this.inputStream = inputStream;
    }

    /**
     * Read data from the input stream, parse it, and return a new docTag meta data document.
     *
     * @return The parsed docTag meta data
     * @throws DataNotFoundException If the input stream doesn't contain any docTag meta data
     * @throws InvalidDataException  If the input stream doesn't contain any valid docTag meta data
     */
    public Document read() throws DataNotFoundException, InvalidDataException {

        throw new UnsupportedOperationException("The read method has not been implemented");
    }

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

        throw new UnsupportedOperationException("The write method has not been implemented");
    }
}
