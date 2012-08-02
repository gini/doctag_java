package org.doctag;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.doctag.domain.Amount;
import org.doctag.domain.Invoice;
import org.doctag.helper.TestHelper;
import org.joda.time.DateMidnight;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Currency;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Unit tests for {@link Generator}.
 *
 * @author Jochen Schalanda
 */
public class GeneratorTest {

    private Generator generator;

    @Before
    public void setUp() {

        generator = new Generator();
    }

    @Test
    public void generateShouldReturnValidJson() throws IOException {

        Invoice invoice = new Invoice(
                getClass().getCanonicalName(),
                DateMidnight.now(),
                new Amount(0.0, 0.0),
                Currency.getInstance("EUR")
        );


        String result = generator.generate(invoice);

        assertNotNull(result);
        assertTrue(result.contains("invoice"));
        assertTrue(result.contains(getClass().getCanonicalName()));
        assertTrue(result.contains("EUR"));
    }

    @Test
    public void generateShouldCreateIdenticalReferenceDocument() throws IOException {

        Invoice invoice = TestHelper.getReferenceInvoice();

        String generatedJson = generator.generate(invoice);
        InputStream referenceJson = getClass().getResourceAsStream("/doctag_from_spec.json");

        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> generatedMap = mapper.readValue(generatedJson, new TypeReference<Map<String, Object>>() {});
        Map<String, Object> referenceMap = mapper.readValue(referenceJson, new TypeReference<Map<String, Object>>() {});

        assertEquals(referenceMap, generatedMap);
    }
}
