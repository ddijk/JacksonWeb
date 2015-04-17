package nl.ortecfinance.opal.jacksonweb.rest;

import java.util.Date;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import nl.ortecfinance.opal.jacksonweb.IncomePlanningSimulationRequest;

@Path("test")
public class RestService {

    @GET
    @Produces("application/json")
    public Response get() {
        IncomePlanningSimulationRequest req = new IncomePlanningSimulationRequest();
        req.setStartPeriod(new Date());
        req.setDob(new Date());

        System.out.println("*******************");
        // System.out.println("age is "+ req.get);
//        ObjectMapper m = new ObjectMapper();
//        StringWriter sr = new StringWriter();
//        try {
//            m.writeValue(sr, req);
//
//        } catch (IOException ex) {
//            System.err.println("Failed. " + ex);
//        }

        return Response.ok(req).build();
        //   return Response.ok(sr.toString()).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response post(IncomePlanningSimulationRequest req) {
        System.out.println("req dob:" + req.getDob());
        System.out.println("" + req.getAge());

        return Response.ok(req).build();
    }
}
