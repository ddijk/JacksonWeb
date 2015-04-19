package nl.ortecfinance.opal.jacksonweb.rest;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("res")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {

        final Set<Class<?>> classes = new HashSet<Class<?>>();

        // register root resources
//        classes.add(EmptyArrayResource.class);
//        classes.add(NonJAXBBeanResource.class);
//        classes.add(CombinedAnnotationResource.class);
        // register Jackson ObjectMapper resolver
        classes.add(RestService.class);
        classes.add(MyObjectMapperProvider.class);

        return classes;
    }
}
