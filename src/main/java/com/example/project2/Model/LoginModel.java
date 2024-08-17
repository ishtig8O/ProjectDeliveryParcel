package com.example.project2.Model;

import com.example.project2.Context;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.sql.*;
import java.util.Collection;

public class LoginModel {
    Collection collection;
    PreparedStatement preparedStatement;
    Connection connection;

    public LoginModel() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:8080/delivery",
                    "root", "");
//            preparedStatement = connection.prepareStatement("Select * from Courier where ")
            this.connection = connection;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createLog(String name, String phone) {
        try {
            //preparedStatement = connection.prepareStatement("INSERT INTO `Client`(`client_name`, `client_phone_number`, `client_address`) VALUES ('"+ name +"','"+phone+"','"+address+"')");
            preparedStatement = connection.prepareStatement("SELECT * FROM `Client` WHERE client_name=? and client_phone_number=?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phone);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                Integer id = rs.getInt("client_id");
                Context.getInstance().setId(id);
                Context.getInstance().setIsClient(true);
                return true;
            }
            else
                return false;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
