package org.doctag.helper;

import java.io.IOException;
import java.io.OutputStream;

/**
 * The class {@link FailingOutputStream} is an implementation of {@link OutputStream} which deliberately fails by
 * throwing an {@link IOException} when {@link #write(int)} is being called.
 *
 * @author Jochen Schalanda
 */
public class FailingOutputStream extends OutputStream {

    @Override
    public void write(int b) throws IOException {
        throw new IOException("I'm in ur codez, throwing exceptions!");
    }
}
