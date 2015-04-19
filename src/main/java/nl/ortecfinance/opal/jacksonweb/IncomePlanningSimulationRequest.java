package nl.ortecfinance.opal.jacksonweb;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Date;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Java representation of a simulation request.
 */
//@JsonSerialize(using = YearMonthDateSerializer.class)
public class IncomePlanningSimulationRequest {

    @JsonProperty(required = true)
    @NotNull
    @Min(1)
    @Max(540)
    private int horizon;

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

    //  @JsonSerialize(using = YearMonthDateSerializer.class)
    // @JsonDeserialize(using = YearMonthDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "CET")
    @JsonProperty("geboortedatum")
    public Date dob;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM", timezone = "CET")
    //  @JsonProperty("processingDate")
    public Date processingDate;

    @NotNull
    private int age;

    private String name = "naam";

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

    /**
     * Retrieves the horizon of the client
     *
     * @return an int representing the horizon
     */
    public int getHorizon() {
        return horizon;
    }

    public void setHorizon(int horizon) {
        this.horizon = horizon;
    }

    /**
     * Retrieves the month and year (day is set to 1) of the date of the start
     * period
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

}
