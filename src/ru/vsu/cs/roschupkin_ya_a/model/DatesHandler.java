package ru.vsu.cs.roschupkin_ya_a.model;

import java.util.regex.*;

public class DatesHandler
{
    public String extractDates(String initialText, Pattern dates)
    {
        Matcher date = dates.matcher(initialText);

        StringBuilder extractedDates = new StringBuilder();

        while (date.find())
        {
            extractedDates.append(date.group());
            extractedDates.append("\n");
        }

        return extractedDates.toString();
    }

    public Pattern setupDateFormats(boolean dayMonthNumberYear, boolean dayMonthNameYear,
                                    boolean monthNameDayCommaYear, boolean dayMonthName)
    {
        final String months = "(january|february|march|april|june|july|august|september|october|november|december" +
                "|jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec)";

        String dateRegex = "";

        if (dayMonthNumberYear)
        {
            dateRegex += "([1-3]?[0-9]\\.[0-1][0-9]\\.\\d+)";
        }

        if (dayMonthNameYear)
        {
            if (!dateRegex.isEmpty())
            {
                dateRegex += "|";
            }
            dateRegex += "([1-3]?[0-9]\\s" + months + "\\s\\d+)";
        }

        if (monthNameDayCommaYear)
        {
            if (!dateRegex.isEmpty())
            {
                dateRegex += "|";
            }
            dateRegex += "(" + months + "\\s[1-3]?[0-9],\\s\\d+)";
        }

        if (dayMonthName)
        {
            if (!dateRegex.isEmpty())
            {
                dateRegex += "|";
            }
            dateRegex += "([1-3]?[0-9]\\s" + months + ")";
        }

        return Pattern.compile(dateRegex, Pattern.CASE_INSENSITIVE);
    }
}
