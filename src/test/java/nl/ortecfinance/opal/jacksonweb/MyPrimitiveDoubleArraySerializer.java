package nl.ortecfinance.opal.jacksonweb;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class MyPrimitiveDoubleArraySerializer extends JsonSerializer<double[]> {

    @Override
    public void serialize(double[] t, JsonGenerator jsonGenerator, SerializerProvider sp) throws IOException, JsonProcessingException {
        System.out.println("MyPrimitiveDoubleArraySerializer called for " + t);
        jsonGenerator.writeStartArray();
        for (Double d : t) {
            jsonGenerator.writeNumber(d + 100);
        }

        jsonGenerator.writeEndArray();
    }

}
