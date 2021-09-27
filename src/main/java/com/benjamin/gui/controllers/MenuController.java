package com.benjamin.gui.controllers;

import com.benjamin.App;
import javafx.event.ActionEvent;

import java.io.IOException;

public class MenuController {
    public void changeToOrders(ActionEvent actionEvent) throws IOException {
        App.changeFxml("orders.fxml");
    }

    public void changeToCustomer(ActionEvent actionEvent) throws IOException {
        App.changeFxml("traitement.fxml");
    }

    public void changeToAdd(ActionEvent actionEvent) throws IOException {
        App.changeFxml("insert.fxml");
    }
}
