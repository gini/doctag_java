package org.doctag.domain;

import com.google.common.base.Objects;

import javax.validation.constraints.NotNull;

/**
 * Representation of a monetary amount in a docTag document.
 *
 * @author Jochen Schalanda
 * @see "docTag specification 0.5, section 2.2.4"
 */
public class Amount {

    @NotNull
    private double gross;

    @NotNull
    private double net;

    public Amount() {
    }

    /**
     * Construct a new amount instance
     *
     * @param gross The gross price
     * @param net   The net price
     */
    public Amount(double net, double gross) {
        this.gross = gross;
        this.net = net;
    }

    /**
     * Get the gross price (price with taxes).
     *
     * @return The gross price
     */
    public double getGross() {
        return gross;
    }

    /**
     * Set the gross price (price with taxes).
     *
     * @param gross The gross price
     */
    public void setGross(double gross) {
        this.gross = gross;
    }

    /**
     * Get the net price (price without taxes).
     *
     * @return The net price
     */
    public double getNet() {
        return net;
    }

    /**
     * Set the net price (price without taxes).
     *
     * @param net The net price
     */
    public void setNet(double net) {
        this.net = net;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(gross, net);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Amount other = (Amount) obj;
        return Objects.equal(this.gross, other.gross) && Objects.equal(this.net, other.net);
    }
}
