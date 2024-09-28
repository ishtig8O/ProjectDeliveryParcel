package com.example.project2.Model;

import com.example.project2.Context;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.sql.*;
import java.util.Collection;

public class ChangeDataModel {
    Collection collection;
    PreparedStatement preparedStatement;
    Connection connection;

    public ChangeDataModel() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(
                    Context.getDBName(),
                    "root", "");
//            preparedStatement = connection.prepareStatement("Select * from Courier where ")
            this.connection = connection;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void changeData(String name, String phone, String address) {
        try {

            preparedStatement = connection.prepareStatement("UPDATE `Client` SET client_name=?, client_phone_number=?, client_address=? WHERE client_id=?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, address);
            preparedStatement.setInt(4, Context.getInstance().getId());

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
