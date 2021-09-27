package com.benjamin.gui.controllers;

import com.benjamin.App;
import com.benjamin.gui.model.SuppliersManager;
import com.benjamin.gui.services.RegexMatches;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class InsertController {
    @FXML
    private TextField txtCompanyName, txtAddress, txtPostalCode, textCity, txtContactName;
    @FXML
    private TextField[] fields = {txtCompanyName, txtAddress, txtPostalCode, textCity, txtContactName};

    public void addSupplier(ActionEvent actionEvent) {
        SuppliersManager sm = new SuppliersManager();
        TextField[] toValidate = {txtCompanyName, txtAddress, textCity, txtContactName};

        resetBorders(toValidate);
        if (validateAll(toValidate) & validateStrings(toValidate) & validatePostal()) {
            sm.addNewSupplier(
                    txtCompanyName.getText(),
                    txtAddress.getText(),
                    txtPostalCode.getText(),
                    textCity.getText(),
                    txtContactName.getText()
            );
            clearAll(toValidate);
        }
    }

    public void clearForm(ActionEvent actionEvent) {
        TextField[] toValidate = {txtCompanyName, txtAddress, txtPostalCode, textCity, txtContactName};
        clearAll(toValidate);
    }

    public void clearAll(TextField[] fields) {
        for (TextField field : fields) {
            field.setStyle("-fx-border-color: none;");
            field.clear();
        }
    }

    public void resetBorders(TextField[] fields) {
        for (TextField field : fields) {
            field.setStyle("-fx-border-color: none;");
        }
    }

    public boolean validateAll(TextField[] strings) {
        int invalid = 0;
        for (TextField string : strings) {
            if (string.getText().length() <= 0) {
                string.setStyle("-fx-border-color: red;");
                invalid++;
            }
        }
        return invalid == 0;
    }

    public boolean validateStrings(TextField[] strings) {
        RegexMatches regex = new RegexMatches();
        int invalid = 0;
        for (TextField string : strings) {
            if (!regex.isValidString(string.getText())) {
                string.setStyle("-fx-border-color: red;");
                invalid++;
            }
        }
        return invalid == 0;
    }

    public boolean validatePostal() {
        RegexMatches regex = new RegexMatches();

        if (regex.isValidPostalCode(txtPostalCode.getText())) {
            txtPostalCode.setStyle("-fx-border-color: none;");
            return true;
        } else {
            txtPostalCode.setStyle("-fx-border-color: red;");
            return false;
        }
    }

    public void returnToMenu(ActionEvent actionEvent) throws IOException {
        App.changeFxml("menu.fxml");
    }
}
