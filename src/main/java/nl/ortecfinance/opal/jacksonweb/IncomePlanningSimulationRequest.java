package nl.ortecfinance.opal.jacksonweb;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import nl.ortecfinance.opal.jacksonweb.deserialize.YearMonthDateDeserializer;
import nl.ortecfinance.opal.jacksonweb.serialize.ListOfDoubleArraySerializer;
import nl.ortecfinance.opal.jacksonweb.serialize.YearMonthDateSerializer;

/**
 * Java representation of a simulation request.
 */
//@JsonSerialize(using = YearMonthDateSerializer.class)
//@XmlRootElement
//@ValidateObject(type = CashflowDto.class)
//@ValidateObject(type = IncomePlanningSimulationRequest.class)
public class IncomePlanningSimulationRequest {

    private int bullProp;

    //   @JsonProperty(required = true)
    @NotNull
    @Min(1)
    @Max(540)
    // @JsonIgnore
    private Integer horizon;

    @JsonProperty(required = true)
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM", timezone = "CET")
    @JsonDeserialize(using = YearMonthDateDeserializer.class)
    //  @JsonSerialize(using = YearMonthDateSerializer.class)
    @Future
    private Date startPeriod;

    @JsonProperty(required = true)
    @NotNull
    @Min(0)
    @Max(999)
    private int startScenario;

    @JsonProperty(required = true)
    @NotNull
    @Min(1)
    @Max(1000)
    private int endScenario;

    @JsonProperty(required = false, defaultValue = "false")
    private boolean failureTestEnabled;

    @JsonProperty(required = true)
    @NotNull
    private boolean taxCalculationIncluded;

    @JsonSerialize(using = YearMonthDateSerializer.class)
    // @JsonDeserialize(using = YearMonthDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "CET")
    @JsonProperty("geboortedatum")
    public Date dob;

    @NotNull
    @JsonSerialize(using = ListOfDoubleArraySerializer.class)
    private List<double[]> values;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM", timezone = "CET")
    //  @JsonProperty("processingDate")
    public Date processingDate;

    @NotNull
    private int age;

    private String name;

    private Double myObjectDouble;
    private double myPrimitiveDouble;
    private double[] myPrimitiveDoubleArray;
    private double[][] myPrimitiveDouble2DimArray = new double[][]{{4, 5}, {3, 5}};
    private Double[] myObjectDoubleArray;

    public Double[] getMyObjectDoubleArray() {
        return myObjectDoubleArray;
    }

    public void setMyObjectDoubleArray(Double[] myObjectDoubleArray) {
        this.myObjectDoubleArray = myObjectDoubleArray;
    }

    public double[] getMyPrimitiveDoubleArray() {
        return myPrimitiveDoubleArray;
    }

    public void setMyPrimitiveDoubleArray(double[] myPrimitiveDoubleArray) {
        this.myPrimitiveDoubleArray = myPrimitiveDoubleArray;
    }

    public double[][] getMyPrimitiveDouble2DimArray() {
        return myPrimitiveDouble2DimArray;
    }

    public void setMyPrimitiveDouble2DimArray(double[][] myPrimitiveDouble2DimArray) {
        this.myPrimitiveDouble2DimArray = myPrimitiveDouble2DimArray;
    }

    public Double getMyObjectDouble() {
        return myObjectDouble;
    }

    public void setMyObjectDouble(Double myObjectDouble) {
        this.myObjectDouble = myObjectDouble;
    }

    public double getMyPrimitiveDouble() {
        return myPrimitiveDouble;
    }

    public void setMyPrimitiveDouble(double myPrimitiveDouble) {
        this.myPrimitiveDouble = myPrimitiveDouble;
    }

    public Date getProcessingDate() {
        return processingDate;
    }

    public void setProcessingDate(Date processingDate) {
        this.processingDate = processingDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public IncomePlanningSimulationRequest() {
    }

    public Integer getHorizon() {
        return horizon;
    }

    public void setHorizon(Integer horizon) {
        this.horizon = horizon;
    }

    /**
     * Retrieves the month and year (day is set to 1) of the date of the start period
     *
     * @return an Date object representing the start date
     */
    public Date getStartPeriod() {
        return startPeriod;
    }

    public void setStartPeriod(Date startPeriod) {
        this.startPeriod = startPeriod;
    }

    /**
     * Retrieves the scenario to start with
     *
     * @return an int representing the start scenario
     */
    public int getStartScenario() {
        return startScenario;
    }

    public void setStartScenario(int startScenario) {
        this.startScenario = startScenario;
    }

    /**
     * Retrieves the scenario to end with
     *
     * @return an int representing the end scenario
     */
    public int getEndScenario() {
        return endScenario;
    }

    public void setEndScenario(int endScenario) {
        this.endScenario = endScenario;
    }

    /**
     * Indicates if the request should always return an internal server error
     *
     * @return true if the request should return error, else false
     */
    public boolean isFailureTestEnabled() {
        return failureTestEnabled;
    }

    public void setFailureTestEnabled(boolean failureTestEnabled) {
        this.failureTestEnabled = failureTestEnabled;
    }

    @JsonProperty("geboortedatum")
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * Indicates if the tax calculation should be included
     *
     * @return true if tax should be included, else false
     */
    public boolean isTaxCalculationIncluded() {
        return taxCalculationIncluded;
    }

    public void setTaxCalculationIncluded(boolean taxCalculationIncluded) {
        this.taxCalculationIncluded = taxCalculationIncluded;
    }

    @JsonIgnore
    public int getBullProp() {
        return bullProp;
    }

    public void setBullProp(int bullProp) {
        this.bullProp = bullProp;
    }

    public List<double[]> getValues() {
        return values;
    }

    public void setValues(List<double[]> values) {
        this.values = values;
    }

}
