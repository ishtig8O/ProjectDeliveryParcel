package com.example.project2.Model;

import com.example.project2.Context;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.sql.*;
import java.util.Collection;

public class JobModel {
    Collection collection;
    PreparedStatement preparedStatement;
    Connection connection;

    public JobModel() {
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

    public void movePackage(String center_id, String unique_code) {
        try {

            preparedStatement = connection.prepareStatement("UPDATE `Package` SET center_id=? WHERE unique_code=?");
            preparedStatement.setString(1, center_id);
            preparedStatement.setString(2, unique_code);

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
