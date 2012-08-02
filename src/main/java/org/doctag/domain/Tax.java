package org.doctag.domain;

import com.google.common.base.Objects;

import javax.validation.constraints.NotNull;

/**
 * Representation of a tax inside a docTag document.
 *
 * @author Jochen Schalanda
 * @see "docTag specification 0.5, section 2.2.1"
 */
public class Tax {

    @NotNull
    private String name;

    @NotNull
    private double rate;

    @NotNull
    private double amount;

    public Tax() {
    }

    /**
     * Construct a new tax instance.
     *
     * @param name   The name of the tax
     * @param rate   The rate of the tax
     * @param amount The amount of the tax
     */
    public Tax(String name, double rate, double amount) {
        this.name = name;
        this.rate = rate;
        this.amount = amount;
    }

    /**
     * Get the name of the tax
     *
     * @return The name of the tax
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the tax.
     *
     * @param name The name of the tax
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the rate of the tax.
     *
     * @return The rate of the tax
     */
    public double getRate() {
        return rate;
    }

    /**
     * Set the rate of the tax.
     *
     * @param rate The rate of the tax
     */
    public void setRate(double rate) {
        this.rate = rate;
    }

    /**
     * Get the amount of the tax.
     *
     * @return The amount of the tax
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Set the amount of the tax.
     *
     * @param amount The amount of the tax
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, rate, amount);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tax other = (Tax) obj;
        return Objects.equal(this.name, other.name)
                && Objects.equal(this.rate, other.rate)
                && Objects.equal(this.amount, other.amount);
    }
}
