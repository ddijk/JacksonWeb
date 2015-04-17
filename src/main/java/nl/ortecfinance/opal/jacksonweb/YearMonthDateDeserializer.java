package nl.ortecfinance.opal.jacksonweb;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.util.Date;

/**
 * Deserializes a year-month to date
 */
public class YearMonthDateDeserializer extends JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonParser jsonparser,
            DeserializationContext deserializationcontext) throws IOException, JsonProcessingException {

        String text = jsonparser.getText();
        if (text.length() != 7) {
            throw new JsonParseException("Incorrect date format (required \"yyyy-mm\": " + text, jsonparser.getCurrentLocation());
        }

        try {
            int year = Integer.parseInt(text.substring(0, 4));
            int month = Integer.parseInt(text.substring(5, 7));
            if (year < 1900 || year > 2100) {
                throw new JsonParseException("Year must be in between 1900 and 2100: " + text, jsonparser.getCurrentLocation());
            }
            if (month < 1 || month > 12) {
                throw new JsonParseException("Month must be between 1 and 12: " + text, jsonparser.getCurrentLocation());
            }
            return DateUtils.createDate(year, month);
        } catch (NumberFormatException nfe) {
            throw new JsonParseException("Incorrect date format (required \"yyyy-mm\": " + text, jsonparser.getCurrentLocation());
        }
    }

}
