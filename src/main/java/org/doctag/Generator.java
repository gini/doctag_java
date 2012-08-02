package org.doctag;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.doctag.domain.Document;

import java.io.IOException;

/**
 * The {@link Generator} class handles converting docTag meta data documents into JSON format using the
 * <a href="http://jackson.codehaus.org/">Jackson</a> library.
 *
 * @author Jochen Schalanda
 */
public class Generator {

    private final ObjectMapper mapper;

    /**
     * Create a new generator instance.
     */
    public Generator() {

        this(new ObjectMapper());
    }

    /**
     * Create a new generator instance.
     *
     * @param mapper The {@link ObjectMapper} instance to be used to create a JSON string from the docTag meta data
     *               document
     */
    public Generator(final ObjectMapper mapper) {

        this.mapper = mapper;

        mapper.setDateFormat(Constants.DATE_FORMAT);
        mapper.setPropertyNamingStrategy(new LowerCaseWithUnderscoresStrategy());
        mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
    }

    /**
     * Create valid JSON from the provided docTag meta data {@link Document}
     *
     * @param document The document from which the JSON string is being created
     * @return A valid JSON string representing the {@link Document}
     * @throws IOException If an error occurred during writing the JSON string
     */
    public String generate(final Document document) throws IOException {

        return mapper.writeValueAsString(document);
    }
}
