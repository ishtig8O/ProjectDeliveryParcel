package com.example.project2.Model;
import com.example.project2.Controller.TableClientController;
import com.example.project2.Table.TableClientWho;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

import java.sql.*;

public class TableClientModel {

    Connection connection = null;

    PreparedStatement pst = null;

    TableClientController tableClientController;



    public TableClientModel(TableClientController t) {

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
        this.tableClientController = t;
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


    public  ObservableList<TableClientWho> getDate() {
//        Connection connection = ConnectDB();
        ObservableList<TableClientWho> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from Client");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new TableClientWho(Integer.parseInt(rs.getString("client_id")),rs.getString("client_name"), rs.getString("client_address"), rs.getString("client_phone_number"), Integer.parseInt(rs.getString("client_id"))));
            }
        }catch (Exception e){

        }
        return list;
    }

    public void add_staffi(String idText, String nameText, String phoneText, String address) {

        String sql = "INSERT INTO `Client`(`client_name`, `client_address`, `client_phone_number`) VALUES (?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            //pst.setInt(1, Integer.parseInt(idText));
            pst.setString(1, nameText);
            pst.setString(2, phoneText);
            pst.setString(3, address);
            pst.executeUpdate();

            tableClientController.updateTable();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void edit(TextField idText, TextField nameText, TextField phoneText, TextField address, TextField point) {
        try {
            String value1 = idText.getText();
            String value2 = nameText.getText();
            String value3 = phoneText.getText();
            String value4 = address.getText();
            String value5 = point.getText();


            String sql = "UPDATE Client SET client_name='" + value2 + "',client_address='" + value4 + "',client_phone_number='" + value3 +"', delivery_point_id=" + value5 +"  WHERE client_id=" + value1 + " ";

            pst = connection.prepareStatement(sql);
            pst.execute();
            tableClientController.updateTable();

        }catch (Exception e){}
    }
}