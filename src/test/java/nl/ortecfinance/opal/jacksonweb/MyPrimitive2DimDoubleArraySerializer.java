package nl.ortecfinance.opal.jacksonweb;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.math.BigDecimal;

public class MyPrimitive2DimDoubleArraySerializer extends JsonSerializer<double[][]> {

    @Override
    public void serialize(double[][] t, JsonGenerator jg, SerializerProvider sp) throws IOException, JsonProcessingException {

        System.out.println("In MyPrimitive2DimDoubleArraySerializer");
        jg.writeStartArray();
        for (double d[] : t) {
            jg.writeStartArray();
            for (double dd : d) {
                BigDecimal bd = new BigDecimal(dd);
                bd.setScale(2, BigDecimal.ROUND_HALF_UP);
                jg.writeNumber(bd);
            }
            jg.writeEndArray();
        }
        jg.writeEndArray();

    }

}
