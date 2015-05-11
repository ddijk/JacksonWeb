/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ortecfinance.opal.jacksonweb;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import nl.ortecfinance.opal.jacksonweb.serialize.MyDoubleArraySerializer;
import org.junit.Test;

/**
 *
 * @author DickD
 */
public class SimulationResponseTest {

    @Test
    public void testJsonIgnore() throws IOException {

        SimulationResponse resp = new SimulationResponse();

        resp.setCapitalGoalProbabilities(Arrays.asList(new Double(10), null, new Double(33)));

        StringWriter sr = new StringWriter();
        ObjectMapper om = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        //      module.addSerializer(List<Double[]>.class, new ListOfDoubleArraySerializer());
        module.addSerializer(Double[].class, new MyDoubleArraySerializer());
        om.registerModule(module);
        om.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        om.writeValue(sr, resp);

        System.out.println(
                "SimulationResponse=" + sr);

    }

}
