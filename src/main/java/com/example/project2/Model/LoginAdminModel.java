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


    public boolean createLog(String log, String pass) {
        if (log.equals("a12") && pass.equals("a123")) {
            Context.getInstance().setMainPage("menuAll.fxml");
            Context.getInstance().setIsAdmin(true);
            return true;
        }
        else
            return false;
    }

}
