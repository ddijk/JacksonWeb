package nl.ortecfinance.opal.jacksonweb.validate;

public interface IValidationContext {

    public boolean isValid();

    public void addError(String string, Object[] os);
}
