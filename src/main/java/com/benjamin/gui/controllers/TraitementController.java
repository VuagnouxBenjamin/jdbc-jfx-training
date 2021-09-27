package com.benjamin.gui.controllers;

import com.benjamin.App;
import com.benjamin.gui.model.DataBase;
import com.benjamin.gui.model.SuppliersManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.HashMap;

public class TraitementController {
    @FXML
    public TextField supplierId, supName, supAddress, supCity, supPostal, supContact;

    /**
     * Update TextFields after DB query.
     *
     * @param actionEvent
     */
    public void getSupplierInformations(ActionEvent actionEvent) {
        SuppliersManager $suppliersManager = new SuppliersManager();
        HashMap<String, String> infos= $suppliersManager.getSupplierInfos(Integer.parseInt(supplierId.getText()));

        supName.setText(infos.get("CompanyName"));
        supAddress.setText(infos.get("Address"));
        supCity.setText(infos.get("City"));
        supPostal.setText(infos.get("PostalCode"));
        supContact.setText(infos.get("ContactName"));
    }

    public void returnToMenu(ActionEvent actionEvent) throws IOException {
        App.changeFxml("menu.fxml");
    }
}
