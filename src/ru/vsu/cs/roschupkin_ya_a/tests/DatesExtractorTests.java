package ru.vsu.cs.roschupkin_ya_a.tests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import ru.vsu.cs.roschupkin_ya_a.controller.DatesHandlerController;
import ru.vsu.cs.roschupkin_ya_a.model.DatesHandler;
import ru.vsu.cs.roschupkin_ya_a.view.DatesHandlerView;

import java.util.Locale;

public class DatesExtractorTests
{
    DatesHandlerView datesHandlerView ;
    DatesHandler datesHandler;
    DatesHandlerController datesHandlerController;

    @Before
    public void initialSetup()
    {
        Locale.setDefault(Locale.ROOT);

        datesHandlerView = new DatesHandlerView();
        datesHandler = new DatesHandler();
        datesHandlerController = new DatesHandlerController(datesHandler, datesHandlerView);
    }

    @Test
    public void testAllFormats()
    {
        final String expectedResult = "20.03.2000\n18 June 1967\nMay 2, 2006\n3 November\n";

        final String testText = "Andrew was born 20.03.2000, his father was born 18 June 1967. " +
                "May 2, 2006 is important date for me. My sisters birthday in 3 November";

        assertEquals(expectedResult, getActualResult(testText));
    }

    @Test
    public void testLittleExtremeCondition()
    {
        final String expectedResult = "July 20, 1976\n30 December\n15.12.600\n";

        final String testText = "17.500.2015 is my birthday. No, your birthday is 20 John 1976. " +
                "Actually it's spelled July 20, 1976. Oh you're right. But today is 30 December. " +
                "I thought it's 12 James. Actually it's 15.12.600";

        assertEquals(expectedResult, getActualResult(testText));
    }

    String getActualResult(String testText)
    {
        datesHandlerView.getInitialTextArea().setText(testText);

        datesHandlerView.getExtractDatesButton().doClick();

       return datesHandlerView.getExtractedTextArea().getText();
    }
}
