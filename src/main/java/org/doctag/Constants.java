package org.doctag;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * The {@link Constants} class contains constants used throughout the docTag library.
 *
 * @author Jochen Schalanda
 */
public class Constants {

    /**
     * The {@link DateFormat} (<a href="http://en.wikipedia.org/wiki/ISO_8601">ISO 8601</a>) being used in the docTag
     * JSON format.
     */
    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Constant for version 0.5 of docTag.
     */
    public static final String VERSION_0_5 = "0.5";

    /**
     * Constant for version 1.0 of docTag.
     */
    public static final String VERSION_1_0 = "1.0";


    /**
     * Prevent instantiation of {@link Constants}.
     */
    private Constants() {
    }
}
