package nl.ortecfinance.opal.jacksonweb.validate;

import app.owf.inject.DependencyContainer;
import app.owf.inject.DependencyType;
import nl.ortecfinance.opal.jacksonweb.IncomePlanningSimulationRequest;

public abstract class ExternalApiModule {

    public static void initialize(DependencyContainer container) {

        container.registerType(new DependencyType<IObjectValidator<IncomePlanningSimulationRequest>>() {
        }, IncomePlanningSimulationRequestValidator.class);
    }
}
