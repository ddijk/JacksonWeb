package nl.ortecfinance.opal.jacksonweb.rest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public final class DateHelper {

    private DateHelper() {

    }

    public static Date getDate(int iYear, int iMonthJava) {
        Calendar cal = new GregorianCalendar(iYear, iMonthJava, 1);
        return cal.getTime();
    }

    public static Date addYears(Date date, int years) {
        return addPeriods(date, years, Calendar.YEAR);
    }

    public static Date addMonths(Date date, int months) {
        return addPeriods(date, months, Calendar.MONTH);
    }

    /**
     * This method returns a new date, to which the supplied number of periods are added
     *
     * @param date the date to which the periods need to be added
     * @param periods the number of periods
     * @param periodType the type of periods, i.e. Calendar.DATE, Calendar.MONTH, Calendar.YEAR
     *
     * @return
     */
    public static Date addPeriods(Date date, int periods, int periodType) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(periodType, periods);
        return cal.getTime();
    }

//    public static Date getDate(String value) {
//        if (value != null && value.length() > 0) {
//            try {
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FormatConstants.DATEFORMAT);
//                return simpleDateFormat.parse(value);
//            } catch (ParseException ex) {
//                LOGGER.error("Cannot parse String value '" + value + "' to a Date.", ex);
//                return null;
//            }
//        }
//        return null;
//    }
//    public static String getDateStringValue(Date date) {
//        if (date == null) {
//            return "";
//        }
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FormatConstants.DATEFORMAT);
//        return simpleDateFormat.format(date);
//    }
    public static List<Date> getMonthlyDates(Date referenceDate, Date endDate) {
        List<Date> dates = new ArrayList<>();
        Date startDate = new Date(referenceDate.getTime());
        while (!startDate.after(endDate)) {
            dates.add(startDate);
            startDate = DateHelper.addPeriods(startDate, 1, Calendar.MONTH);
        }
        return dates;
    }

    public static List<Date> getMonthlyDates(Date referenceDate, int horizonInMonths) {
        Date endDate = DateHelper.addPeriods(referenceDate, horizonInMonths, Calendar.MONTH);
        return getMonthlyDates(referenceDate, endDate);
    }

    public static <T> List<T> getYearlyValuesFromStart(List<T> monthlyValues) {
        List<T> yearlyListValues = new ArrayList<>();
        for (int i = 0; i < monthlyValues.size() - 1; i += 12) {
            yearlyListValues.add(monthlyValues.get(i));
        }
        yearlyListValues.add(monthlyValues.get(monthlyValues.size() - 1));
        return yearlyListValues;
    }

    public static String getDateForPeriod(Locale locale, int months, Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMMM yyyy", locale);
        return sdf.format(addMonths(date, months));
    }

    /**
     * Determine end date of the horizon when given horizon startdate, years and months. This method is typically used
     * to build client settings screen where client's birthday is used as horizon start date and horzon is given as
     * number of years and the end date is eventually determined by this method and saved in db. This method does not
     * support number of days of the horizon.
     *
     * @param horizonStartDate horizon's start date, must not be null
     * @param horizonYears horizon's years, can be null but not negative
     * @param horizonMonths horizon's months, can be null but not negative
     * @return end date of horizon as java.lang.Date
     */
    public static Date determineEndDateFromHorizon(Date horizonStartDate, Integer horizonYears, Integer horizonMonths) {
        if (horizonYears == null && horizonMonths == null) {
            return null;
        }
        if (horizonYears != null && horizonYears < 0) {
            throw new IllegalArgumentException("years of horizon must not be negative");
        }
        if (horizonMonths != null && horizonMonths < 0) {
            throw new IllegalArgumentException("months of horizon must not be negative");
        }
        Date horizonEndDate = horizonStartDate;

        if (horizonYears != null) {
            horizonEndDate = DateHelper.addPeriods(horizonEndDate, horizonYears, Calendar.YEAR);
        }
        if (horizonMonths != null) {
            horizonEndDate = DateHelper.addPeriods(horizonEndDate, horizonMonths, Calendar.MONTH);
        }
        return horizonEndDate;
    }

    public static XMLGregorianCalendar getXMLGregorianCalendarDate(int year, int month, int day) throws DatatypeConfigurationException {
        DatatypeFactory df = DatatypeFactory.newInstance();
        XMLGregorianCalendar xgc = df.newXMLGregorianCalendar();
        xgc.setYear(year);
        xgc.setMonth(month);
        xgc.setDay(day);
        return xgc;
    }

    public static Date getDate(int year, int month, int day) {
        Calendar c = Calendar.getInstance();
        c.set(year, month, day);
        Date d = new Date();
        d.setTime(c.getTimeInMillis());
        return d;
    }

    /**
     * This method is responsible for providing a list of Date wrapped monthly dates for a given startDate and horizon.
     *
     * @param now startDate
     * @param horizonInMonths
     * @return
     */
    public static List<Date> generateDateList(Date now, int horizonInMonths) {
        List<Date> list = new ArrayList<>();
        for (Date d : getMonthlyDates(now, horizonInMonths - 1)) {  // exclude last month
            Date cal = new Date();
            cal.setTime(d.getTime());
        }

        return list;

    }

}
