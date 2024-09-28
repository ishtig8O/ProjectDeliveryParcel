package com.example.project2.Model;

import com.example.project2.Context;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.sql.*;
import java.util.Collection;

public class ChangeDataStaffModel {
    Collection collection;
    PreparedStatement preparedStatement;
    Connection connection;

    public ChangeDataStaffModel() {
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

    public void changeDataStaff(String name, String phone) {
        try {

            preparedStatement = connection.prepareStatement("UPDATE `Courier` SET courier_name=?, courier_phone_number=? WHERE courier_id=?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phone);
            preparedStatement.setInt(3, Context.getInstance().getId());

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
