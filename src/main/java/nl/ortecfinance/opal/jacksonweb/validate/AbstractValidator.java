package nl.ortecfinance.opal.jacksonweb.validate;

import java.lang.annotation.Annotation;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public abstract class AbstractValidator<A extends Annotation, T> implements ConstraintValidator<A, T> {

    private A constraint;

    protected A getConstraint() {
        return constraint;
    }

    @Override
    public void initialize(A constraint) {
        this.constraint = constraint;
    }

    @Override
    public boolean isValid(T value, ConstraintValidatorContext validatorContext) {
        return value == null || doIsValid(value, validatorContext);
    }

    protected abstract boolean doIsValid(T value, ConstraintValidatorContext validatorContext);
}
