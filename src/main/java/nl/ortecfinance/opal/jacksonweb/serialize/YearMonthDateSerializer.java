package nl.ortecfinance.opal.jacksonweb.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.util.Date;

public class YearMonthDateSerializer extends JsonSerializer<Date> {

    @Override
    public void serialize(Date t, JsonGenerator jsonGenerator, SerializerProvider sp) throws IOException, JsonProcessingException {
        System.out.println("***** serialize, " + t);
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectField("my field", t);
        jsonGenerator.writeEndObject();
        System.out.println("***** serialize done");
    }

}
