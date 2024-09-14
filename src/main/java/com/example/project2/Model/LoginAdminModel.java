package com.example.project2.Model;

import com.example.project2.Context;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.sql.*;
import java.util.Collection;

public class LoginAdminModel {
    Collection collection;
    PreparedStatement preparedStatement;
    Connection connection;

//    public LoginStaffModel() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            Connection connection = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:8080/deliveryTest",
//                    "root", "");
////            preparedStatement = connection.prepareStatement("Select * from Courier where ")
//            this.connection = connection;
//
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public boolean createLog(String log, String pass) {
        if (log.equals("a12") && pass.equals("a123")) {
            Context.getInstance().setMainPage("menuAll.fxml");
            return true;
        }
        else
            return false;
    }

}
