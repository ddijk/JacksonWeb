package nl.ortecfinance.opal.jacksonweb;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class MyDoubleArraySerializer extends JsonSerializer<Double[]> {

    @Override
    public void serialize(Double[] t, JsonGenerator jsonGenerator, SerializerProvider sp) throws IOException, JsonProcessingException {
        System.out.println("MyDoubleSerializer called for " + t);
        jsonGenerator.writeStartObject();
        for (Double d : t) {
            jsonGenerator.writeNumber(d + 100);
        }

        jsonGenerator.writeEndObject();
    }

//    @Override
//    public void serialize(Double t, JsonGenerator jsonGenerator, SerializerProvider sp) throws IOException, JsonProcessingException {
//        System.out.println("MyDoubleArraySerializer called for " + t);
//        jsonGenerator.writeStartObject();
//        jsonGenerator.writeNumber(t + 100);
//        jsonGenerator.writeEndObject();
//
//    }
}
