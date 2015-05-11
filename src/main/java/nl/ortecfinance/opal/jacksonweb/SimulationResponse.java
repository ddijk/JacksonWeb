package nl.ortecfinance.opal.jacksonweb;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import nl.ortecfinance.opal.jacksonweb.serialize.ListOfDoubleArraySerializer;

@XmlRootElement
public class SimulationResponse {

    // @JsonProperty(required = true)
    @NotNull
    @JsonIgnore
    private double[] percentiles;

    @JsonProperty(required = true)
    @NotNull
    private String currencyCode;

    @JsonProperty(required = true)
    @NotNull
    @JsonSerialize(using = ListOfDoubleArraySerializer.class)
    private List<double[]> totalCapital;

    //@JsonProperty(required = true)
    @JsonIgnore
    @NotNull
    //  @JsonSerialize(using = ListOfDoubleArraySerializer.class)
    private List<double[]> totalAvailableCapital;

    @JsonProperty(required = true)
    @NotNull
    private List<Double> capitalGoalProbabilities = new ArrayList<>();

    @JsonProperty(required = true)
    @NotNull
    private List<SimulationItemResponse> withdrawalGoalProbabilities = new ArrayList<>();

    @JsonProperty(required = true)
    @NotNull
    private List<Date> yearMonthValues;

    public List<Date> getYearMonthValues() {
        return yearMonthValues;
    }

    public void setYearMonthValues(List<Date> yearMonthValues) {
        this.yearMonthValues = yearMonthValues;
    }

    public double[] getPercentiles() {
        return percentiles;
    }

    public void setPercentiles(double[] percentiles) {
        this.percentiles = percentiles;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public List<double[]> getTotalCapital() {
        return totalCapital;
    }

    public void setTotalCapital(List<double[]> totalCapital) {
        this.totalCapital = totalCapital;
    }

    public List<double[]> getTotalAvailableCapital() {
        return totalAvailableCapital;
    }

    public void setAvailableCapital(List<double[]> totalAvailableCapital) {
        this.totalAvailableCapital = totalAvailableCapital;
    }

    public List<Double> getCapitalGoalProbabilities() {
        return capitalGoalProbabilities;
    }

    public void setCapitalGoalProbabilities(List<Double> capitalGoalProbabilities) {
        this.capitalGoalProbabilities = capitalGoalProbabilities;
    }

    public List<SimulationItemResponse> getWithdrawalGoalProbabilities() {
        return withdrawalGoalProbabilities;
    }

    public void setWithdrawalGoalProbabilities(List<SimulationItemResponse> withdrawalGoalProbabilities) {
        this.withdrawalGoalProbabilities = withdrawalGoalProbabilities;
    }

}
