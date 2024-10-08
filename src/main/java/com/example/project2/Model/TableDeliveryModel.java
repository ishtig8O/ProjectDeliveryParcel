package com.example.project2.Model;
import com.example.project2.Context;
import com.example.project2.Controller.TableDeliveryController;
import com.example.project2.Table.TableDeliveryWho;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

import java.sql.*;

public class TableDeliveryModel {

    Connection connection = null;

    PreparedStatement pst = null;

    TableDeliveryController tableDeliveryController;



    public TableDeliveryModel(TableDeliveryController t) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(Context.getDBName(),
                    "root", "");
//            preparedStatement = connection.prepareStatement("Select * from Courier where ")
            this.connection = connection;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.tableDeliveryController = t;
    }




    public  ObservableList<TableDeliveryWho> getDate() {
//        Connection connection = ConnectDB();
        ObservableList<TableDeliveryWho> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from Delivery_Center");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new TableDeliveryWho(Integer.parseInt(rs.getString("center_id")), rs.getString("center_name"), rs.getString("center_address")));
            }
        }catch (Exception e){

        }
        return list;
    }

    public void add_staffi(String nameText, String DText) {

        String sql = "INSERT INTO `Delivery_Center`(`center_name`, `center_address`) VALUES (?,?)";
        try {
            pst = connection.prepareStatement(sql);
            //pst.setInt(1, Integer.parseInt(idText));
            pst.setString(1, nameText);
            pst.setString(2, DText);
            pst.executeUpdate();

            tableDeliveryController.updateTable();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void edit(TextField idText, TextField nameText, TextField dText) {

            String value1 = idText.getText();
            String value2 = nameText.getText();
            String value3 = dText.getText();


//            String sql = "UPDATE `Delivery_Center` SET`center_name`='" + value2 + "',`center_address`='" + value3 + "' WHERE `center_id`='" + value1 + "' ";
            String sql = "UPDATE `Delivery_Center` SET `center_name` = ? ,`center_address`= ? WHERE `center_id`= ?";

            try {
                pst = connection.prepareStatement(sql);
                pst.setString(1, value2);
                pst.setString(2, value3);
                pst.setString(3, value1);
                pst.executeUpdate();

                tableDeliveryController.updateTable();
            }catch (Exception e){
                System.out.println(e);
            }
    }

    public void delete(TextField idText) {
        String value1 = idText.getText();

        String sql = "DELETE from `Delivery_Center` WHERE `center_id`=?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, value1);

            pst.executeUpdate();

            tableDeliveryController.updateTable();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}