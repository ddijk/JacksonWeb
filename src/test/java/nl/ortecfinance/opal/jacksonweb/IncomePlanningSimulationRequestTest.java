/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ortecfinance.opal.jacksonweb;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Date;
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
}
