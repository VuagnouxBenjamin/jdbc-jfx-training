package com.benjamin.gui.model;

import com.benjamin.gui.services.RegexMatches;
import javafx.scene.control.Alert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class SuppliersManager extends DataBase {

    /**
     * Return Data of SupplierID asked.
     *
     * @param $supplierID
     * @return Hashmap
     */
    public HashMap<String, String> getSupplierInfos(int $supplierID) {
        HashMap<String, String> SupplierInfos = new HashMap<String, String>();

        try {

            PreparedStatement stm = con.prepareStatement("SELECT CompanyName, Address, City, PostalCode, ContactName FROM suppliers WHERE SupplierID = ?");
            stm.setInt(1, $supplierID);
            ResultSet result = stm.executeQuery();

            PreparedStatement validate = con.prepareStatement("SELECT SupplierID FROM suppliers WHERE SupplierID = ?");
            validate.setInt(1, $supplierID);
            ResultSet isValid = validate.executeQuery();

            if (isValid.next()) {
                while (result.next()) {
                    SupplierInfos.put("CompanyName", result.getString("CompanyName"));
                    SupplierInfos.put("Address", result.getString("Address"));
                    SupplierInfos.put("City", result.getString("City"));
                    SupplierInfos.put("PostalCode", result.getString("PostalCode"));
                    SupplierInfos.put("ContactName", result.getString("ContactName"));
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Erreur");
                alert.setHeaderText("Le fournisseur " + $supplierID + " n'éxiste pas. Veuillez réessayer.");
                alert.showAndWait();
            }

            // else : show alert

            stm.close();
            result.close();
            con.close();

            return SupplierInfos;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * Insert new supplier into db
     *
     * @param companyName
     * @param address
     * @param postalCode
     * @param city
     * @param contactName
     */
    public void addNewSupplier(String companyName, String address, String postalCode, String city, String contactName) {
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("INSERT INTO suppliers (CompanyName, Address, PostalCode, City, ContactName) VALUES (?, ?, ?, ?, ?)");
            stm.setString(1, companyName);
            stm.setString(2, address);
            stm.setString(3, postalCode);
            stm.setString(4, city);
            stm.setString(5, contactName);

            stm.execute();
            stm.close();
            con.close();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Le fournisseur est ajouté correctement");
            alert.showAndWait();

        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Erreur : veuillez réessayer");
            alert.showAndWait();

            e.printStackTrace();
        }
    }

    private boolean validateStrings(String[] strings) {
        RegexMatches rm = new RegexMatches();
        for (String s : strings) {
            if (!rm.isValidString(s)) {
                return false;
            }
        }
        return true;
    }

}
