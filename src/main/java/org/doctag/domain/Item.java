package org.doctag.domain;

import com.google.common.base.Objects;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Representation of a single item inside a docTag document.
 *
 * @author Jochen Schalanda
 * @see "docTag specification 0.5, section 2.2.2"
 */
public class Item {

    @NotNull
    private String title;
    private String description;
    private String unit;

    @NotNull
    private double quantity;

    @NotNull
    private Amount unitPrice;

    @NotNull
    private Amount total;

    @NotNull
    private List<Tax> taxes;

    public Item() {
    }

    /**
     * Construct a new item instance.
     *
     * @param title     The title of the item
     * @param quantity
     * @param unitPrice
     * @param taxes
     * @param total
     */
    public Item(String title, double quantity, Amount unitPrice, List<Tax> taxes, Amount total) {
        this.title = title;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.taxes = taxes;
        this.total = total;
    }

    /**
     * Get the title of the item.
     *
     * @return The title of the item
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title of the item.
     *
     * @param title The title of the item
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the description of the item.
     *
     * @return The description of the item
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the item.
     *
     * @param description The description of the item
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the unit of the item.
     *
     * @return The unit of the item
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Set the unit of the item.
     *
     * @param unit The unit of the item
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * Get the quantity of the item.
     *
     * @return The quantity of the item
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity
     *
     * @param quantity The quantity of the item
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    /**
     * Get the unit price of the item.
     *
     * @return The unit price of the item
     */
    public Amount getUnitPrice() {
        return unitPrice;
    }

    /**
     * Set the unit price of the item.
     *
     * @param unitPrice The unit price of the item
     */
    public void setUnitPrice(Amount unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Get the total amount of the item.
     *
     * @return The total amount of the item
     */
    public Amount getTotal() {
        return total;
    }

    /**
     * Set the total amount of the item.
     *
     * @param total The total amount of the item
     */
    public void setTotal(Amount total) {
        this.total = total;
    }

    /**
     * Set the taxes of the item.
     *
     * @return The taxes of the item
     */
    public List<Tax> getTaxes() {
        return taxes;
    }

    /**
     * Set the taxes of the item.
     *
     * @param taxes The taxes of the item
     */
    public void setTaxes(List<Tax> taxes) {
        this.taxes = taxes;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title, description, unit, quantity, unitPrice, total, taxes);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        return Objects.equal(this.title, other.title)
                && Objects.equal(this.description, other.description)
                && Objects.equal(this.unit, other.unit)
                && Objects.equal(this.quantity, other.quantity)
                && Objects.equal(this.unitPrice, other.unitPrice)
                && Objects.equal(this.total, other.total)
                && Objects.equal(this.taxes, other.taxes);
    }
}
