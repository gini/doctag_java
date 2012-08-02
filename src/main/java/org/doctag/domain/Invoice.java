package org.doctag.domain;

import org.joda.time.DateMidnight;

import javax.validation.constraints.NotNull;
import java.util.Currency;
import java.util.List;

/**
 * Representation of a docTag document with type {@literal invoice}.
 *
 * @author Jochen Schalanda
 * @see "docTag specification 0.5, section 2.1"
 */
public class Invoice extends Document {

    @NotNull
    private String id;
    private String number;

    @NotNull
    private DateMidnight date;

    @NotNull
    private Amount total;

    @NotNull
    private Currency currency;

    private String customerNumber;
    private DateMidnight dueDate;
    private String deliveryDate;
    private String intro;
    private String note;
    private Address sender;
    private Address recipient;
    private List<Item> items;
    private List<Tax> taxes;
    private List<Discount> discounts;

    public Invoice() {

        super("invoice");
    }

    /**
     * Construct a new invoice instance.
     *
     * @param version  The docTag version
     * @param id       The ID of the document
     * @param date     The date of the document
     * @param total    The invoice total of the document
     * @param currency The currency of the document
     */
    public Invoice(String version, String id, DateMidnight date, Amount total, Currency currency) {

        super("invoice", version);

        this.id = id;
        this.date = date;
        this.total = total;
        this.currency = currency;
    }

    /**
     * Construct a new invoice instance.
     *
     * @param id       The ID of the document
     * @param date     The date of the document
     * @param total    The invoice total of the document
     * @param currency The currency of the document
     */
    public Invoice(String id, DateMidnight date, Amount total, Currency currency) {

        this();

        this.id = id;
        this.date = date;
        this.total = total;
        this.currency = currency;
    }

    /**
     * Get the ID of the document.
     *
     * @return The ID of the document
     */
    public String getId() {
        return id;
    }

    /**
     * Set the ID of the document.
     *
     * @param id The ID of the document
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the invoice number of the document.
     *
     * @return The invoice number of the document
     */
    public String getNumber() {
        return number;
    }

    /**
     * Set the invoice number of the document.
     *
     * @param number The invoice number of the document
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Get the date of the document
     *
     * @return The date of the document
     */
    public DateMidnight getDate() {
        return date;
    }

    /**
     * Set the date of the document.
     *
     * @param date The date of the document
     */
    public void setDate(DateMidnight date) {
        this.date = date;
    }

    /**
     * Get the total amount of the document
     *
     * @return The total amount of the document
     */
    public Amount getTotal() {
        return total;
    }

    /**
     * Set the total amount of the document
     *
     * @param total The total amount of the document
     */
    public void setTotal(Amount total) {
        this.total = total;
    }

    /**
     * Get the currency of the document.
     *
     * @return The currency of the document
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * Set the currency of the document.
     *
     * @param currency The currency of the document
     */
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    /**
     * Get the customer number of the document.
     *
     * @return The customer number of the document
     */
    public String getCustomerNumber() {
        return customerNumber;
    }

    /**
     * Set the customer number of the document.
     *
     * @param customerNumber The customer number of the document
     */
    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    /**
     * Get the due date of the document.
     *
     * @return The due date of the document
     */
    public DateMidnight getDueDate() {
        return dueDate;
    }

    /**
     * Set the due date of the document.
     *
     * @param dueDate The due date of the document
     */
    public void setDueDate(DateMidnight dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Get the delivery date of the document.
     *
     * @return The delivery date of the document
     */
    public String getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * Set the delivery date of the document.
     *
     * @param deliveryDate The delivery date of the document
     */
    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * Get the introduction text of the document.
     *
     * @return The introduction text of the document
     */
    public String getIntro() {
        return intro;
    }

    /**
     * Set the introduction text of the document.
     *
     * @param intro The introduction text of the document
     */
    public void setIntro(String intro) {
        this.intro = intro;
    }

    /**
     * Get the note of the document.
     *
     * @return The note of the document
     */
    public String getNote() {
        return note;
    }

    /**
     * Set the note of the document.
     *
     * @param note The note of the document
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * Get the sender of the document
     *
     * @return The sender of the document
     */
    public Address getSender() {
        return sender;
    }

    /**
     * Set the sender of the document
     *
     * @param sender The sender of the document
     */
    public void setSender(Address sender) {
        this.sender = sender;
    }

    /**
     * Get the recipient of the document.
     *
     * @return The recipient of the document
     */
    public Address getRecipient() {
        return recipient;
    }

    /**
     * Set the recipient of the document.
     *
     * @param recipient The recipient of the document
     */
    public void setRecipient(Address recipient) {
        this.recipient = recipient;
    }

    /**
     * Get the items of the document.
     *
     * @return The items of the document
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Set the items of the document.
     *
     * @param items The items of the document
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * Get the taxes of the document.
     *
     * @return The taxes of the document
     */
    public List<Tax> getTaxes() {
        return taxes;
    }

    /**
     * Set the taxes of the document.
     *
     * @param taxes The taxes of the document
     */
    public void setTaxes(List<Tax> taxes) {
        this.taxes = taxes;
    }

    /**
     * Get the discounts of the document.
     *
     * @return The discounts of the document
     */
    public List<Discount> getDiscounts() {
        return discounts;
    }

    /**
     * Set the discounts of the document.
     *
     * @param discounts The discounts of the document
     */
    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }
}
