/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ortecfinance.opal.jacksonweb;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;
import org.junit.Assert;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author DickD
 */
public class IncomePlanningSimulationRequestTest {

    @Test
    public void testIncomePlanningSimulationRequest() throws IOException {

        IncomePlanningSimulationRequest req = new IncomePlanningSimulationRequest();
        req.setStartPeriod(new Date());
        ObjectMapper m = new ObjectMapper();
        m.writeValue(System.out, req);
    }

    @Test
    public void testDeserializeDate() throws IOException {
        String json = "{\"horizon\":0,\"startPeriod\":\"2015-04\",\"geboortedatum\":\"2005-08-13\"}";
        ObjectMapper m = new ObjectMapper();
        IncomePlanningSimulationRequest req = m.readValue(new StringReader(json), IncomePlanningSimulationRequest.class);

        Assert.assertEquals(0, req.getHorizon());
        Assert.assertEquals(DateUtils.createDate(2015, 4), req.getStartPeriod());
        final Date dobJens = DateUtils.createDate(2005, 8, 13);
        //  System.out.println("dobJens:"+dobJens.getTime());
        //     final Date actualDob = req.getDob();
        //   System.out.println("actual:"+actualDob);
        //   System.out.println("verschil:"+(dobJens.getTime()-actualDob.getTime()));
        Assert.assertEquals(dobJens, req.getDob());
        Assert.assertEquals(0, req.getStartScenario());
        Assert.assertEquals(0, req.getEndScenario());
        Assert.assertEquals(0, req.getAge());
    }

    // @Test
    public void testDeserializeCopiedFromChromeAdvancedRestClient() throws IOException {
        String json = "{\"horizon\":0,\"startScenario\":0,\"endScenario\":0,\"failureTestEnabled\":false,\"taxCalculationIncluded\":false,\"processingDate\":null,\"age\":0,\"name\":\"naam\",\"dob\":\"2015-04-19\"}";
        ObjectMapper m = new ObjectMapper();
        m.enable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES);
        m.enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        IncomePlanningSimulationRequest req = m.readValue(new StringReader(json), IncomePlanningSimulationRequest.class);

        Assert.assertEquals(0, req.getHorizon());
        Assert.assertEquals(DateUtils.createDate(2015, 4), req.getStartPeriod());
        final Date dobJens = DateUtils.createDate(2005, 8, 13);
        //  System.out.println("dobJens:"+dobJens.getTime());
        //     final Date actualDob = req.getDob();
        //   System.out.println("actual:"+actualDob);
        //   System.out.println("verschil:"+(dobJens.getTime()-actualDob.getTime()));
        Assert.assertEquals(dobJens, req.getDob());
        Assert.assertEquals(0, req.getStartScenario());
        Assert.assertEquals(0, req.getEndScenario());
        Assert.assertEquals(0, req.getAge());
    }

    // 
    @Test(expected = JsonProcessingException.class)
    public void testNullForMissingPrimitive() throws IOException {
        String json = "{\"age\":null}";
        ObjectMapper m = new ObjectMapper();
        m.enable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES);
        m.readValue(new StringReader(json), IncomePlanningSimulationRequest.class);

    }

    @Test
    public void testSerializeDate() throws IOException {

        IncomePlanningSimulationRequest req = new IncomePlanningSimulationRequest();
        final Date today = DateUtils.createDate(2015, 4);
        final Date dobLieve = DateUtils.createDate(2008, 8, 24);
        req.setStartPeriod(today);
        req.setDob(dobLieve);
        req.setProcessingDate(today);

        System.out.println("today:" + today);
        System.out.println("Lieve:" + dobLieve);

        StringWriter sw = new StringWriter();
        ObjectMapper m = new ObjectMapper();
        m.writeValue(sw, req);

        String json = sw.toString();
        System.out.println("testSerializeDate:" + json);

        StringReader sr = new StringReader(json);
        m.enable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES);
        IncomePlanningSimulationRequest reqReadBack = m.readValue(sr, IncomePlanningSimulationRequest.class);

        Assert.assertEquals(dobLieve, reqReadBack.getDob());
        Assert.assertEquals(today, reqReadBack.getStartPeriod());

    }

}
