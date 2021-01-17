package ru.vsu.cs.roschupkin_ya_a.controller;

import ru.vsu.cs.roschupkin_ya_a.model.DatesHandler;
import ru.vsu.cs.roschupkin_ya_a.view.DatesHandlerView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class DatesHandlerController
{
    DatesHandler datesHandler;
    DatesHandlerView datesHandlerView;

    public DatesHandlerController(DatesHandler datesHandler, DatesHandlerView datesHandlerView)
    {
        this.datesHandler = datesHandler;
        this.datesHandlerView = datesHandlerView;

        initiateExtractDatesButton();
    }

    public void initiateExtractDatesButton()
    {
        JButton extractDatesButton = datesHandlerView.getExtractDatesButton();
        extractDatesButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String initialText = getInitialDataFromTextArea();
                boolean[] enabledDateFormats = getEnabledDateFormatsFromCheckBoxes();

                Pattern selectedDates = datesHandler.setupDateFormats(enabledDateFormats[0],
                        enabledDateFormats[1], enabledDateFormats[2], enabledDateFormats[3]);

                String extractedDates = datesHandler.extractDates(initialText, selectedDates);

                putExtractedDatesToTextArea(extractedDates);
            }
        });
    }

    String getInitialDataFromTextArea()
    {
        return datesHandlerView.getInitialTextArea().getText();
    }

    void putExtractedDatesToTextArea(String extractedDates)
    {
        JTextArea extractedTextArea = datesHandlerView.getExtractedTextArea();
        extractedTextArea.setText(extractedDates);
    }

    boolean[] getEnabledDateFormatsFromCheckBoxes()
    {
        JCheckBox dayMonthNumberYearCheckBox = datesHandlerView.getDayMonthNumberYearCheckBox();
        JCheckBox dayMonthNameYearCheckBox = datesHandlerView.getDayMonthNameYearCheckBox();
        JCheckBox monthNameDayCommaYearCheckBox = datesHandlerView.getMonthNameDayCommaYearCheckBox();
        JCheckBox dayMonthNameCheckBox = datesHandlerView.getDayMonthNameCheckBox();

        boolean[] enabledDateFormats = new boolean[4];

        enabledDateFormats[0] = dayMonthNumberYearCheckBox.isSelected();
        enabledDateFormats[1] = dayMonthNameYearCheckBox.isSelected();
        enabledDateFormats[2] = monthNameDayCommaYearCheckBox.isSelected();
        enabledDateFormats[3] = dayMonthNameCheckBox.isSelected();

        return enabledDateFormats;
    }
}
