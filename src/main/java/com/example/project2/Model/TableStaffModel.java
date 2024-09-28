package com.example.project2.Model;
import com.example.project2.Context;
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
                    Context.getDBName(),
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



    public  ObservableList<TableStaffWho> getDate() {
//        Connection connection = ConnectDB();
        ObservableList<TableStaffWho> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from Courier");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new TableStaffWho(Integer.parseInt(rs.getString("courier_id")), rs.getString("courier_name"), rs.getString("courier_phone_number"), Integer.parseInt(rs.getString("center_id"))));
            }
        }catch (Exception e){

        }
        return list;
    }

    public void add_staffi(String idText, String nameText, String phoneText, String centerId) {

        String sql = "INSERT INTO `Courier`(`courier_id`, `courier_name`, `courier_phone_number`, center_id) VALUES (?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(idText));
            pst.setString(2, nameText);
            pst.setString(3, phoneText);
            pst.setInt(4, Integer.parseInt(centerId));
            pst.executeUpdate();

            tableStaffController.updateTable();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void edit(TextField idText, TextField nameText, TextField phoneText, TextField centerId) {
//        try {
            String value1 = idText.getText();
            String value2 = nameText.getText();
            String value3 = phoneText.getText();
            Integer value4 = Integer.parseInt(centerId.getText());


//            String sql = "UPDATE `Courier` SET`courier_name`='" + value2 + "',`courier_phone_number`='" + value3 + "' WHERE `courier_id`='" + value1 + "' ";
            String sql = "UPDATE `Courier` SET`courier_name`=?,`courier_phone_number`=?, `center_id`=? WHERE `courier_id`=?";

            try {
                pst = connection.prepareStatement(sql);
                pst.setString(1, value2);
                pst.setString(2, value3);
                pst.setString(3, value1);
                pst.setInt(4, value4);
                pst.executeUpdate();

                tableStaffController.updateTable();
            }catch (Exception e){
                System.out.println(e);
            }

    }

    public void delete(TextField idText) {
        String value1 = idText.getText();

        String sql = "DELETE from `Courier` WHERE `courier_id`=?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, value1);

            pst.executeUpdate();

            tableStaffController.updateTable();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}