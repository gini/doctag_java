package org.doctag.domain;

import com.google.common.base.Objects;
import org.joda.time.DateMidnight;

import javax.validation.constraints.NotNull;

/**
 * Representation of a discount inside a docTag document.
 *
 * @author Jochen Schalanda
 * @see "docTag specification 0.5, section 2.2.5"
 */
public class Discount {

    @NotNull
    private DateMidnight date;

    @NotNull
    private double rate;

    @NotNull
    private double amount;

    public Discount() {
    }

    /**
     * @param date   The date until which the discount applies to
     * @param rate   The discount rate
     * @param amount The discount amount
     */
    public Discount(DateMidnight date, double rate, double amount) {
        this.date = date;
        this.rate = rate;
        this.amount = amount;
    }

    /**
     * Get the date until which the discount applies to.
     *
     * @return The date until which the discount applies to
     */
    public DateMidnight getDate() {
        return date;
    }

    /**
     * Set the date until which the discount applies to.
     *
     * @param date The date until which the discount applies to
     */
    public void setDate(DateMidnight date) {
        this.date = date;
    }

    /**
     * Get the discount rate.
     *
     * @return The discount rate
     */
    public double getRate() {
        return rate;
    }

    /**
     * Set the discount rate.
     *
     * @param rate The discount rate
     */
    public void setRate(double rate) {
        this.rate = rate;
    }

    /**
     * Get the discount amount.
     *
     * @return The discount amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Set the discount amount.
     *
     * @param amount The discount amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(date, rate, amount);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Discount other = (Discount) obj;
        return Objects.equal(this.date, other.date)
                && Objects.equal(this.rate, other.rate)
                && Objects.equal(this.amount, other.amount);
    }
}
