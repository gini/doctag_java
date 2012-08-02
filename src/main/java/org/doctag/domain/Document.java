package org.doctag.domain;

import com.google.common.base.Objects;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.doctag.Constants;

import javax.validation.constraints.NotNull;

/**
 * Representation of a docTag document.
 *
 * @author Jochen Schalanda
 * @see "docTag specification 0.5, section 2.1"
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "doctype"
)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "invoice", value = Invoice.class)
})
public abstract class Document {

    @NotNull
    @JsonProperty("doctype")
    private String type;

    @NotNull
    @JsonProperty("doctag_version")
    private String version = Constants.VERSION_0_5;

    public Document() {
    }

    /**
     * Construct a new document instance.
     *
     * @param type    The type of the document
     * @param version The docTag version
     */
    public Document(String type, String version) {
        this.type = type;
        this.version = version;
    }

    /**
     * Construct a new document instance with the default docTag version
     *
     * @param type The type of the document
     */
    public Document(String type) {
        this.type = type;
    }

    /**
     * Get the type of the document.
     *
     * @return The type of the document
     */
    public String getType() {
        return type;
    }

    /**
     * Set the type of the document
     *
     * @param type The type of the document
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get the docTag version.
     *
     * @return The docTag version
     */
    public String getVersion() {
        return version;
    }

    /**
     * Set the docTag version.
     *
     * @param version The docTag version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(type, version);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Document other = (Document) obj;
        return Objects.equal(this.type, other.type) && Objects.equal(this.version, other.version);
    }
}
