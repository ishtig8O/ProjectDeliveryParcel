package com.example.project2.Model;
import com.example.project2.Controller.TableStaffController;
import com.example.project2.Table.TableStaffWho;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

import java.sql.*;

public class TableStaffModel {

    Connection connection = null;

    PreparedStatement pst = null;

    TableStaffController tableStaffController;



    public TableStaffModel(TableStaffController t) {

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
        this.tableStaffController = t;
    }

//    public static Connection ConnectDB () {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
////
//            Connection connection = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:8080/deliveryTest",
//                    "root", "");
//            return connection;
//        } catch (Exception e) {
//            return null;
//        }
//    }


    public  ObservableList<TableStaffWho> getDate() {
//        Connection connection = ConnectDB();
        ObservableList<TableStaffWho> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from Courier");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new TableStaffWho(Integer.parseInt(rs.getString("courier_id")), rs.getString("courier_name"), rs.getString("courier_phone_number")));
            }
        }catch (Exception e){

        }
        return list;
    }

    public void add_staffi(String idText, String nameText, String phoneText) {

        String sql = "INSERT INTO `Courier`(`courier_id`, `courier_name`, `courier_phone_number`) VALUES (?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(idText));
            pst.setString(2, nameText);
            pst.setString(3, phoneText);
            pst.executeUpdate();

            tableStaffController.updateTable();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void edit(TextField idText, TextField nameText, TextField phoneText) {
        try {
            String value1 = idText.getText();
            String value2 = nameText.getText();
            String value3 = phoneText.getText();


            String sql = "UPDATE `Courier` SET`courier_name`='" + value2 + "',`courier_phone_number`='" + value3 + "' WHERE `courier_id`='" + value1 + "' ";

            pst = connection.prepareStatement(sql);
            pst.execute();
            tableStaffController.updateTable();

        }catch (Exception e){}
    }
}