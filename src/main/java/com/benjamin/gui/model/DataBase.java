package com.benjamin.gui.model;

import java.sql.*;

public class DataBase {


    protected Connection con;

    /**
     * Initialise connexion with MySQL DB
     */
    public DataBase() {
        this.con =  connect();
    }


    public Connection getCon() {
        return con;
    }

    /**
     * creates the connexion with MySql DataBase
     *
     * @return Connection
     */
    private Connection connect() {
        String url = "jdbc:mysql://localhost:3306/northwind?serverTimezone=UTC";
        String USER = "admin";
        String PWD = "admin";

        try {
            return DriverManager.getConnection(url, USER, PWD);
        } catch (SQLException e) {
            System.out.println("Error : impossible de se connecter a la base de données");
            System.out.println(e.getMessage());
        }

        return null;
    }

}
