package org.doctag;

import org.doctag.domain.Amount;
import org.doctag.domain.Document;
import org.doctag.domain.Invoice;
import org.doctag.helper.TestHelper;
import org.joda.time.DateMidnight;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Currency;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for {@link ParserTest}.
 *
 * @author Jochen Schalanda
 */
public class ParserTest {

    private Parser parser;

    @Before
    public void setUp() {

        parser = new Parser();
    }

    @Test
    public void parseShouldReturnValidObject() throws IOException {

        Invoice invoice = new Invoice(
                "org.doctag.GeneratorTest.generateShouldReturnValidJson",
                DateMidnight.now(),
                new Amount(0.0, 0.0),
                Currency.getInstance("EUR")
        );


        String json = "{\"id\":\"org.doctag.GeneratorTest.generateShouldReturnValidJson\",\"date\":\"2012-08-02\"," +
                "\"total\":{\"gross\":0.0,\"net\":0.0},\"currency\":\"EUR\",\"doctype\":\"invoice\"," +
                "\"doctag_version\":\"0.5\"}";

        InputStream jsonInputStream = new ByteArrayInputStream(json.getBytes());

        Document parsedDocument = parser.parse(jsonInputStream);

        assertEquals(invoice, parsedDocument);
    }

    @Test
    public void parseShouldReturnValidReferenceDocument() throws IOException {

        Invoice referenceInvoice = TestHelper.getReferenceInvoice();
        InputStream referenceJson = getClass().getResourceAsStream("/doctag_from_spec.json");

        Document parsedDocument = parser.parse(referenceJson);

        assertEquals(referenceInvoice, parsedDocument);
    }
}
