package org.doctag;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy;
import org.doctag.domain.Document;

import java.io.IOException;
import java.io.InputStream;

/**
 * The {@link Parser} class handles converting a JSON input stream into a valid docTag meta data document using the
 * <a href="http://jackson.codehaus.org/">Jackson</a> library.
 *
 * @author Jochen Schalanda
 */
public class Parser {

    private final ObjectMapper mapper;

    /**
     * Create a new parser instance.
     */
    public Parser() {

        this(new ObjectMapper());
    }

    /**
     * Create a new parser instance.
     *
     * @param mapper The {@link ObjectMapper} instance to be used to map the input data to a docTag meta data document
     */
    public Parser(final ObjectMapper mapper) {

        this.mapper = mapper;

        mapper.setDateFormat(Constants.DATE_FORMAT);
        mapper.setPropertyNamingStrategy(new LowerCaseWithUnderscoresStrategy());
    }

    /**
     * Parse the provided (JSON) {@link InputStream} and create a docTag meta data {@link Document} from its contents.
     *
     * @param inputStream The {@link InputStream to process}
     * @return The docTag meta data {@link Document} created from the JSON input
     * @throws IOException If an error occurred during reading the input stream or creating the {@link Document} instance
     */
    public Document parse(final InputStream inputStream) throws IOException {

        return mapper.readValue(inputStream, Document.class);
    }
}
