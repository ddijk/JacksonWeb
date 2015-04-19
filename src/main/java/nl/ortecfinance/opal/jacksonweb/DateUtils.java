package nl.ortecfinance.opal.jacksonweb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateUtils {

    /**
     * Creates a new Date from the given year, month, and day (all 1-based).
     */
    public static Date createDate(int year, int month, int day) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(year, month - 1, day);

        return calendar.getTime();
    }

    /**
     * Returns a new date based on an offset from the given date.
     */
    public static Date add(Date date, int calendarField, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendarField, amount);
        return calendar.getTime();
    }

    /**
     * Creates a new Date from the given year, month. For day a default of 1 is
     * used.
     */
    public static Date createDate(int year, int month) {
        return createDate(year, month, 1);
    }

    /**
     * Gets the given date's year.
     */
    public static int getYear(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * Gets the given date's month (1-based).
     */
    public static int getMonth(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * Update a field of a date by given value
     *
     * @param date date to update
     * @param dateField field of date to update
     * @param value value to update
     * @return updated date
     */
    public static Date updateDateField(Date date, int dateField, int value) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(dateField, value);
        return cal.getTime();
    }

    /**
     * Returns a date representing the first day of the current month at 00:00
     * (i.e. no day and time components).
     */
    public static Date getCurrentMonthDate() {
        Calendar now = Calendar.getInstance();
        return createDate(now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1, 1);
    }

    /**
     * Returns the current year.
     */
    public static int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    /**
     * Returns the current month (1-based).
     */
    public static int getCurrentMonth() {
        return Calendar.getInstance().get(Calendar.MONTH) + 1;
    }

    /*
     * @Deprecated moved to DAOUtils
     */
    @Deprecated
    public static java.sql.Date toSQLDate(String sDate, String sDateFormat, boolean bCreateCurrentDate) throws ParseException {
        java.sql.Date date = null;
        java.util.Date uDate;

        if (sDate != null && !sDate.isEmpty()) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(sDateFormat);
            uDate = simpleDateFormat.parse(sDate);
            date = new java.sql.Date(uDate.getTime());
        } else { // no date found check whether is required to create a new date
            if (bCreateCurrentDate) {
                uDate = new java.util.Date();
                date = new java.sql.Date(uDate.getTime());
            }
        }

        return date;
    }

    /*
     * @Deprecated moved to DAOUtils
     */
    @Deprecated
    public static java.sql.Date toSQLDate(java.util.Date uDate) {
        java.sql.Date sqlDate = null;

        if (uDate != null) {
            sqlDate = new java.sql.Date(uDate.getTime());
        }

        return sqlDate;
    }

    /**
     * convert a date to XMLGregorianCalendar format
     *
     * @param date Date to convert
     * @return converted XMLGregorianCalendar
     */
    public static XMLGregorianCalendar convertToXMLGregorianCalendar(Date date) {
        return convertToXMLGregorianCalendar(getDatatypeFactory(), date);
    }

    /**
     * convert a collection of dates to a collection of XMLGregorianCalendar
     *
     * @param dates Collection of dates to convert
     * @return converted collection of XMLGregorianCalendars
     */
    public static List<XMLGregorianCalendar> convertToXMLGregorianCalendarList(List<Date> dates) {
        if (dates == null) {
            return null;
        }
        DatatypeFactory dtf = getDatatypeFactory();
        List<XMLGregorianCalendar> result = new ArrayList<>();
        for (Date date : dates) {
            result.add(convertToXMLGregorianCalendar(dtf, date));
        }
        return result;
    }

    private static XMLGregorianCalendar convertToXMLGregorianCalendar(DatatypeFactory dtf, Date date) {
        GregorianCalendar g = new GregorianCalendar();
        g.setTime(date);
        return dtf.newXMLGregorianCalendarDate(g.get(Calendar.YEAR), g.get(Calendar.MONTH) + 1, g.get(Calendar.DAY_OF_MONTH), DatatypeConstants.FIELD_UNDEFINED);
    }

    private static DatatypeFactory getDatatypeFactory() {
        try {
            return DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException ex) {
            throw new IllegalStateException(ex);
        }
    }

    /**
     * Returns the number of months since 0 for given date
     *
     * @param date date to determine months for
     * @return number of monts in date
     */
    public static int getDateAsMonths(Date date) {
        if (date == null) {
            return 0;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR) * 12 + calendar.get(Calendar.MONTH) + 1;
    }

    public static String getTimestamp(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        return sdf.format(new Date());
    }
}
