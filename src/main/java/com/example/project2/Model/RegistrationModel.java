package com.example.project2.Model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

public class RegistrationModel {

    PreparedStatement preparedStatement;
    Connection connection;

    public RegistrationModel() {
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

    public void createReg(String name, String address, String phone) {
        try {
            //preparedStatement = connection.prepareStatement("INSERT INTO `Client`(`client_name`, `client_phone_number`, `client_address`) VALUES ('"+ name +"','"+phone+"','"+address+"')");
            preparedStatement = connection.prepareStatement("INSERT INTO `Client`(`client_name`, `client_phone_number`, `client_address`) VALUES (?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, address);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
