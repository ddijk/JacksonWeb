package nl.ortecfinance.opal.jacksonweb.rest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.SimpleDateFormat;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author japod
 */
@Provider
public class MyObjectMapperProvider implements ContextResolver<ObjectMapper> {

    final ObjectMapper defaultObjectMapper;
    // final ObjectMapper combinedObjectMapper;

    public MyObjectMapperProvider() {
        defaultObjectMapper = createDefaultMapper();
        // combinedObjectMapper = createCombinedObjectMapper();
    }

//    @Override
//    public ObjectMapper getContext(Class<?> type) {
//
//        if (type == CombinedAnnotationBean.class) {
//            return combinedObjectMapper;
//        } else {
//            return defaultObjectMapper;
//        }
//    }
//
//    private static ObjectMapper createCombinedObjectMapper() {
//
//        Pair combinedIntrospector = createJaxbJacksonAnnotationIntrospector();
//        ObjectMapper result = new ObjectMapper();
//        result.configure(Feature.WRAP_ROOT_VALUE, true);
//        result.setDeserializationConfig(result.getDeserializationConfig().withAnnotationIntrospector(combinedIntrospector));
//        result.setSerializationConfig(result.getSerializationConfig().withAnnotationIntrospector(combinedIntrospector));
//
//        return result;
//    }
    static ObjectMapper createDefaultMapper() {

        ObjectMapper result = new ObjectMapper();
        result.enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        result.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        result.enable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
        result.enable(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE);
        result.enable(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS);
        result.enable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES);
        result.setDateFormat(new SimpleDateFormat("yyyy-MM"));
        //result.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //result.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
//        SimpleModule module = new SimpleModule();
//        module.addSerializer(IncomePlanningSimulationRequest.class, null)
//        result.registerModule(module);

        System.out.println("*** createDefaultMapper  aangeroepen");
        return result;
    }

//    private static Pair createJaxbJacksonAnnotationIntrospector() {
//
//        AnnotationIntrospector jaxbIntrospector = new JaxbAnnotationIntrospector();
//        AnnotationIntrospector jacksonIntrospector = new JacksonAnnotationIntrospector();
//
//        return new AnnotationIntrospector.Pair(jacksonIntrospector, jaxbIntrospector);
//    }
    @Override
    public ObjectMapper getContext(Class<?> type) {
        System.out.println("*** getContext  aangeroepen");
        return defaultObjectMapper;
    }
}
