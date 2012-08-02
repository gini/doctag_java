package org.doctag.exception;

/**
 * The class {@code ConnectorException} is being used when an error occurred inside a {@link org.doctag.connector.Connector}
 * which doesn't directly related to the docTag meta data document or its format.
 *
 * @author Jochen Schalanda
 */
public class ConnectorException extends Exception {

    public ConnectorException(String message) {
        super(message);
    }

    public ConnectorException(String message, Throwable cause) {
        super(message, cause);
    }
}
