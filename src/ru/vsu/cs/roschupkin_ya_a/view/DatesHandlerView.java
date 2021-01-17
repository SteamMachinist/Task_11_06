package ru.vsu.cs.roschupkin_ya_a.view;

import javax.swing.*;
import java.awt.*;

public class DatesHandlerView
{
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JButton extractDatesButton;
    private JCheckBox dayMonthNumberYearCheckBox;
    private JCheckBox dayMonthNameYearCheckBox;
    private JCheckBox monthNameDayCommaYearCheckBox;
    private JCheckBox dayMonthNameCheckBox;
    private JLabel initialTextLabel;
    private JLabel extractedDatesLabel;
    private JLabel formatsLabel;
    private JTextArea initialTextArea;
    private JTextArea extractedTextArea;
    private JScrollPane initialTextScrollPane;
    private JScrollPane extractedScrollPane;



    public DatesHandlerView()
    {
        initiateMainFrame();
        initiateTextAreas();
    }

    void initiateMainFrame()
    {
        mainFrame = new JFrame("Dates extractor");
        mainFrame.setContentPane(mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setMinimumSize(new Dimension(350, 250));
        mainFrame.setPreferredSize(new Dimension(512, 384));
        mainFrame.setSize(mainFrame.getPreferredSize());
        mainFrame.setVisible(true);
    }

    void initiateTextAreas()
    {
        extractedTextArea.setEditable(false);

        initialTextArea.setLineWrap(true);
        initialTextArea.setWrapStyleWord(true);
    }

    public JButton getExtractDatesButton()
    {
        return extractDatesButton;
    }

    public JCheckBox getDayMonthNumberYearCheckBox()
    {
        return dayMonthNumberYearCheckBox;
    }

    public JCheckBox getDayMonthNameYearCheckBox()
    {
        return dayMonthNameYearCheckBox;
    }

    public JCheckBox getMonthNameDayCommaYearCheckBox()
    {
        return monthNameDayCommaYearCheckBox;
    }

    public JCheckBox getDayMonthNameCheckBox()
    {
        return dayMonthNameCheckBox;
    }

    public JTextArea getInitialTextArea()
    {
        return initialTextArea;
    }

    public JTextArea getExtractedTextArea()
    {
        return extractedTextArea;
    }
}
