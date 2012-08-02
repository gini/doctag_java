package org.doctag.exception;

/**
 * The class {@code DataNotFoundException} is being used when no docTag meta data could be found inside another document
 * or a stream.
 *
 * @author Jochen Schalanda
 */
public class DataNotFoundException extends Exception {

    public DataNotFoundException(String message) {
        super(message);
    }

    public DataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
