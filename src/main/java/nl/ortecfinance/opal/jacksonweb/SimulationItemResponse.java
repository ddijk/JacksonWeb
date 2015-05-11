package nl.ortecfinance.opal.jacksonweb;

import nl.ortecfinance.opal.jacksonweb.serialize.ListOfDoubleArraySerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.List;
import javax.validation.constraints.NotNull;

/**
 * Represents result values for individual items such as goals and accounts.
 */
public class SimulationItemResponse {

    @JsonProperty(required = true)
    @NotNull
    private String id;

    @JsonProperty(required = true)
    @NotNull
    @JsonSerialize(using = ListOfDoubleArraySerializer.class)
    private List<double[]> values;

    /**
     * Gets the item id.
     *
     * @return the item id.
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the item value.
     *
     * @return the item value.
     */
    public List<double[]> getValues() {
        return values;
    }

    public void setValues(List<double[]> values) {
        this.values = values;
    }

}
