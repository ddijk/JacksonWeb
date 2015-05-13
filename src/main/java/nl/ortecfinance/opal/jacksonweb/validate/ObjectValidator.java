package nl.ortecfinance.opal.jacksonweb.validate;

import javax.validation.ConstraintValidatorContext;

public class ObjectValidator extends AbstractValidator<ValidateObject, Object> {

    @Override
    @SuppressWarnings("deprecation")
    public boolean doIsValid(Object value, ConstraintValidatorContext validatorContext) {

        System.out.println("Processing. ... ObjectValidator ");
        return true;
    }
}
