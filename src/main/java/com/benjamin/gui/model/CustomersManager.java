package com.benjamin.gui.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class CustomersManager extends DataBase{

    /**
     * get String customerName for View Combobox.
     *
     * @return ObservableList<String> customersName
     */
    public ObservableList<String> getCustomerCB() {
        ObservableList<String> customersName = FXCollections.observableArrayList();

        try {
            Statement stm = con.createStatement();
            ResultSet result = stm.executeQuery("SELECT ContactName FROM customers");

            while (result.next()) {
                customersName.add(result.getString(1));
            }

            return customersName;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<String> getOrdersByCustomerName(String customerName) {
        ArrayList<String> orders = new ArrayList<String>();

        try {
            PreparedStatement stm = con.prepareStatement("SELECT OrderDate FROM `orders` AS o JOIN customers AS c ON o.CustomerID = c.CustomerID WHERE ContactName = ? ");
            stm.setString(1, customerName);
            ResultSet result = stm.executeQuery();

            while (result.next()) {
                orders.add(result.getString("OrderDate"));
            }

            return orders;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
