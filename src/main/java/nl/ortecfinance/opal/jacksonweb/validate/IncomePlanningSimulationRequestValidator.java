package nl.ortecfinance.opal.jacksonweb.validate;

import nl.ortecfinance.opal.jacksonweb.IncomePlanningSimulationRequest;

public class IncomePlanningSimulationRequestValidator
        implements IObjectValidator<IncomePlanningSimulationRequest> {

    @Override
    public void validate(IValidationContext ivc, IncomePlanningSimulationRequest t) {

        System.out.println("IncomePlanningSimulationRequestValidator in validate....");
    }
}
