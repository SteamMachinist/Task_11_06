package ru.vsu.cs.roschupkin_ya_a;

import ru.vsu.cs.roschupkin_ya_a.controller.DatesHandlerController;
import ru.vsu.cs.roschupkin_ya_a.model.DatesHandler;
import ru.vsu.cs.roschupkin_ya_a.view.DatesHandlerView;

import java.util.Locale;

public class Main
{
    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ROOT);

        DatesHandlerView datesHandlerView = new DatesHandlerView();
        DatesHandler datesHandler = new DatesHandler();
        DatesHandlerController datesHandlerController = new DatesHandlerController(datesHandler, datesHandlerView);
    }
}
