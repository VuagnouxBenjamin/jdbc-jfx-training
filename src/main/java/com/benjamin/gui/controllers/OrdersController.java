package com.benjamin.gui.controllers;

import com.benjamin.App;
import com.benjamin.gui.model.CustomersManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OrdersController implements Initializable {
    @FXML
    public ComboBox comboBox;
    @FXML
    public TextArea result;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // setting up combo box data.
        CustomersManager cm = new CustomersManager();
        ObservableList<String> data = cm.getCustomerCB();
        comboBox.setItems(data);
    }

    public void showOrders(ActionEvent actionEvent) {
        result.clear();

        CustomersManager cm = new CustomersManager();
        ArrayList<String> orders = cm.getOrdersByCustomerName(comboBox.getSelectionModel().getSelectedItem().toString());

        for (String order : orders) {
            result.appendText(order + "\n");
        }
    }

    public void returnToMenu(ActionEvent actionEvent) throws IOException {
        App.changeFxml("menu.fxml");
    }
}
