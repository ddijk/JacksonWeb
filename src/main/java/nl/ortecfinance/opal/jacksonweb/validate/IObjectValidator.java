package nl.ortecfinance.opal.jacksonweb.validate;

/**
 * Generic object validator.
 *
 * @param <T> the type of object to validate.
 */
public interface IObjectValidator<T> {

    /**
     * Validates the specified object.
     *
     * @param context The validation context.
     * @param value The validated object.
     */
    void validate(IValidationContext context, T value);
}
