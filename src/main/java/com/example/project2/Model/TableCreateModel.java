package com.example.project2.Model;
import com.example.project2.Context;
import com.example.project2.Controller.TableCreateOrderController;
import com.example.project2.Controller.TableTakeController;
import com.example.project2.Table.TableCreateWho;
import com.example.project2.Table.TableStaffWho;
import com.example.project2.Table.TableTakeWho;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

import java.sql.*;

public class TableCreateModel {

    Connection connection = null;

    PreparedStatement pst = null;

    TableCreateOrderController tableCreateOrderController;



    public TableCreateModel(TableCreateOrderController t) {

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
        this.tableCreateOrderController = t;
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


    public  ObservableList<TableCreateWho> getDate() {
        ObservableList<TableCreateWho> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT dc.center_address as centerAddress ,c.client_address as clientAddress ,p.delivery_id as deliveryId ,p.package_id as packageId, p.type_id as typeId, p.weight as weight, p.unique_code as uniqueCode FROM Package as p inner join Delivery as d on p.delivery_id = d.delivery_id inner join Client as c on d.recipient_id = c.client_id inner join Delivery_Center as dc on p.center_id = dc.center_id inner join Client as cc on d.sender_id = cc.client_id where cc.client_id = ?;");
            ps.setInt(1, Context.getInstance().getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(
                        new TableCreateWho(
                                rs.getString("centerAddress")
                                , rs.getString("clientAddress")
                                , rs.getInt("deliveryId")
                                , rs.getInt("packageId")
                                , rs.getInt("typeId")
                                , rs.getInt("weight")
                                , rs.getString("uniqueCode")
                        )
                );

            }
        }catch (Exception e){
            System.out.println(e);

        }
        return list;
    }

//    public void add_staffi(String idText, String nameText, String phoneText) {
//
//        String sql = "INSERT INTO `Courier`(`courier_id`, `courier_name`, `courier_phone_number`) VALUES (?,?,?)";
//        try {
//            pst = connection.prepareStatement(sql);
//            pst.setInt(1, Integer.parseInt(idText));
//            pst.setString(2, nameText);
//            pst.setString(3, phoneText);
//            pst.executeUpdate();
//
//            tableStaffController.updateTable();
//        }catch (Exception e){
//            System.out.println(e);
//        }
//    }

    public void create(TextField rcpt_id, TextField type_id, TextField weight) {
        try {
            String value1 = rcpt_id.getText();
            String value2 = Integer.toString(Context.getInstance().getId());
            String value3 = type_id.getText();
            String value4 = weight.getText();


            String sql = "INSERT INTO Delivery (sender_id, recipient_id) VALUES(?,?)";

            pst = connection.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(value2));
            pst.setInt(2, Integer.parseInt(value1));
            pst.execute();

            String sql0 = "SELECT LAST_INSERT_ID() AS ID";
            pst = connection.prepareStatement(sql0);
            ResultSet rs0 = pst.executeQuery();

            int deliveryId = 0;
            if (rs0.next()) {
                deliveryId = rs0.getInt("ID");
            }
            else
                throw new Exception("Ошибка");


            String sqlCenter = "SELECT delivery_point_id from Client where client_id = ?";
            pst = connection.prepareStatement(sqlCenter);
            pst.setInt(1, Integer.parseInt(value2));
            ResultSet rs00 = pst.executeQuery();

            int centerId = 0;
            if (rs00.next()) {
                centerId = rs00.getInt("delivery_point_id");
            }
            else
                throw new Exception("Ошибка");


            String sql1 = "INSERT INTO Package (delivery_id, type_id, weight, center_id, state_id, unique_code) VALUES(?,?,?,?,1,?)";

            String uniqueCode = Integer.toString(deliveryId);

            pst = connection.prepareStatement(sql1);
            pst.setInt(1, deliveryId);
            pst.setInt(2, Integer.parseInt(value3));
            pst.setInt(3, Integer.parseInt(value4));
            pst.setInt(4, centerId);
            pst.setString(5, uniqueCode);
            pst.execute();

            String sql2 = "SELECT LAST_INSERT_ID() AS ID";
            pst = connection.prepareStatement(sql2);
            ResultSet rs000 = pst.executeQuery();
            int packageId = 0;
            if (rs000.next()) {
                packageId = rs0.getInt("ID");
            }
            else
                throw new Exception("Ошибка");



            tableCreateOrderController.updateTable();

        }catch (Exception e){
            System.out.println(e);
        }
    }
}