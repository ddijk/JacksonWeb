package nl.ortecfinance.opal.jacksonweb;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class MyDoubleSerializer extends JsonSerializer<Double> {

    @Override
    public void serialize(Double t, JsonGenerator jsonGenerator, SerializerProvider sp) throws IOException, JsonProcessingException {
        System.out.println("MyDoubleSerializer called for " + t);
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumber(t + 1000);
        jsonGenerator.writeEndObject();
    }

}
