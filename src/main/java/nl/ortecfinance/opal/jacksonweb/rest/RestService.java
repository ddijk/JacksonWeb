package nl.ortecfinance.opal.jacksonweb.rest;

import java.util.Arrays;
import java.util.Date;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import nl.ortecfinance.opal.jacksonweb.IncomePlanningSimulationRequest;

@Path("test")
public class RestService {

    @GET
    @Produces("application/json")
    public Response get(@QueryParam("age") int age) {
        IncomePlanningSimulationRequest req = new IncomePlanningSimulationRequest();
        req.setStartPeriod(new Date());
        req.setDob(new Date());
        req.setAge(age);
        req.setValues(Arrays.asList(new double[]{3, 5}, new double[]{31, 53}));

        System.out.println("*******************");
        System.out.println("age is " + req.getAge());
//        ObjectMapper m = MyObjectMapperProvider.createDefaultMapper();
//        StringWriter sr = new StringWriter();
//        try {
//            m.writeValue(sr, req);
//            System.out.println("IncomePlanningSimulationRequest:" + sr.toString());
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
        System.out.println("HOrizon" + req.getHorizon());

        return Response.ok(req).build();
    }
}
