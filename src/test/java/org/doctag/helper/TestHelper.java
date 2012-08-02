package org.doctag.helper;

import com.google.common.collect.Lists;
import org.doctag.domain.Amount;
import org.doctag.domain.Discount;
import org.doctag.domain.Invoice;
import org.doctag.domain.Item;
import org.doctag.domain.Tax;
import org.joda.time.DateMidnight;

import java.util.Currency;

/**
 * Helper class with methods used by several tests in the test suite.
 *
 * @author Jochen Schalanda
 */
public class TestHelper {

    /**
     * Get an {@link Invoice} which is identical to the JSON example in the docTag specification
     *
     * @return The {@link Invoice} document from the docTag specification
     */
    public static Invoice getReferenceInvoice() {

        Invoice invoice = new Invoice(
                "0.9", "org.doctag.documentation.1234", new DateMidnight(2012, 5, 22),
                new Amount(586.0, 696.62), Currency.getInstance("EUR"));

        invoice.setDeliveryDate("2012-04-11");
        invoice.setNumber("RE1234");
        invoice.setDueDate(new DateMidnight(2012, 4, 25));

        Item item1 = new Item(
                "Malerarbeiten",
                8.0,
                new Amount(60.0, 71.4),
                Lists.newArrayList(new Tax("MwSt", 19.0, 91.2)),
                new Amount(480.0, 571.2)
        );
        item1.setDescription("Büroräume grün gestrichen.");
        item1.setUnit("Stunde");


        Item item2 = new Item(
                "Farbe",
                5.0,
                new Amount(20, 23.8),
                Lists.newArrayList(new Tax("MwSt", 19.0, 19.0)),
                new Amount(100.0, 119.0)
        );
        item2.setDescription("Grün, superdeckend");
        item2.setUnit("Eimer");

        Item item3 = new Item(
                "Pausenverpflegung",
                1.0,
                new Amount(6.0, 6.42),
                Lists.newArrayList(new Tax("MwSt", 7.0, 0.42)),
                new Amount(6.0, 6.42)
        );
        item3.setDescription("Pizza!!!");
        item3.setUnit("Stück");

        invoice.setItems(Lists.newArrayList(item1, item2, item3));
        invoice.setTaxes(Lists.newArrayList(new Tax("MwSt", 19.0, 110.2), new Tax("MwSt", 7.0, 0.42)));
        invoice.setDiscounts(Lists.newArrayList(new Discount(new DateMidnight(2012, 5, 29), 2.0, 13.93)));

        return invoice;
    }

}
