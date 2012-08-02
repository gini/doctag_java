package org.doctag.exception;

/**
 * The class {@code InvalidDataException} is being used when the docTag meta data document contains invalid data and
 * thus cannot be further processed.
 *
 * @author Jochen Schalanda
 */
public class InvalidDataException extends Exception {

    public InvalidDataException(String message) {
        super(message);
    }

    public InvalidDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
