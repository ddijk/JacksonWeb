package nl.ortecfinance.opal.jacksonweb.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdArraySerializers.DoubleArraySerializer;
import java.io.IOException;
import java.util.List;

public class ListOfDoubleArraySerializer extends JsonSerializer<List<double[]>> {

    @Override
    public void serialize(List<double[]> values, JsonGenerator generator, SerializerProvider provider) throws IOException, JsonProcessingException {
        DoubleArraySerializer serializer = new DoubleArraySerializer();
        generator.writeStartArray();
        for (double[] value : values) {
            serializer.serialize(value, generator, provider);
        }
        generator.writeEndArray();
    }

}
