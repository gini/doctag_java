package org.doctag.domain;

import com.google.common.base.Objects;

import javax.validation.constraints.NotNull;

/**
 * Representation of an address inside a docTag document.
 *
 * @author Jochen Schalanda
 * @see "docTag specification 0.5, section 2.2.3"
 */
public class Address {

    @NotNull
    private String name;

    private String contact;
    private String street;
    private String zipCode;
    private String city;
    private String state;
    private Country country;
    private String taxNumber;

    public Address() {
    }

    /**
     * Construct a new address instance.
     *
     * @param name The name of the address
     */
    public Address(String name) {
        this.name = name;
    }

    /**
     * Get the name part of the address
     *
     * @return The name of the address
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name part of the address
     *
     * @param name The name of the address
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the contact name of the address
     *
     * @return The contact name of the address
     */
    public String getContact() {
        return contact;
    }

    /**
     * Set the contact name of the address
     *
     * @param contact The contact name of the address
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * Get the street (including house number) of the address
     *
     * @return The street (including house number) of the address
     */
    public String getStreet() {
        return street;
    }

    /**
     * Set the street (including house number) of the address.
     *
     * @param street The street (including house number) of the address
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Get the zip code of the address
     *
     * @return The zip code of the address
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Set the zip code of the address
     *
     * @param zipCode The zip code of the address
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Get the city of the address.
     *
     * @return The city of the address
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the city of the address.
     *
     * @param city The city of the address
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get the state of the address.
     *
     * @return The state of the address
     */
    public String getState() {
        return state;
    }

    /**
     * Set the state of the address.
     *
     * @param state The state of the address
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Set the country code (ISO 3166-1) of the address.
     *
     * @return The country code (ISO 3166-1) of the address
     */
    public Country getCountry() {
        return country;
    }

    /**
     * Get the country code (ISO 3166-1) of the address.
     *
     * @param country The country code of the address as ISO 3166-1
     */
    public void setCountry(Country country) {
        this.country = country;
    }

    /**
     * Get the tax number of the address.
     *
     * @return The tax number of the address
     */
    public String getTaxNumber() {
        return taxNumber;
    }

    /**
     * Set the tax number of the address.
     *
     * @param taxNumber The tax number of the address
     */
    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, contact, street, zipCode, city, state, country, taxNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;
        return Objects.equal(this.name, other.name) && Objects.equal(this.contact, other.contact)
                && Objects.equal(this.street, other.street) && Objects.equal(this.zipCode, other.zipCode)
                && Objects.equal(this.city, other.city) && Objects.equal(this.state, other.state)
                && Objects.equal(this.country, other.country) && Objects.equal(this.taxNumber, other.taxNumber);
    }
}
