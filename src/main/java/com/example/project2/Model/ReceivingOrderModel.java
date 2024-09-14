package com.example.project2.Model;
import com.example.project2.Context;
import com.example.project2.Controller.ReceivingOrderController;
import com.example.project2.Controller.TableTakeController;
import com.example.project2.Table.TableReceivingWho;
import com.example.project2.Table.TableStaffWho;
import com.example.project2.Table.TableTakeWho;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

import java.sql.*;

public class ReceivingOrderModel {

    Connection connection = null;

    PreparedStatement pst = null;

    ReceivingOrderController receivingOrderController;



    public ReceivingOrderModel(ReceivingOrderController t) {

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
        this.receivingOrderController = t;
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


    public  ObservableList<TableReceivingWho> getDate() {
        ObservableList<TableReceivingWho> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT p.delivery_id as deliveryId, p.type_id as typeId, p.weight as weight, p.unique_code as uniqueCode FROM Package as p inner join Delivery as d on p.delivery_id = d.delivery_id where d.recipient_id = ?;");
            ps.setInt(1, Context.getInstance().getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(
                        new TableReceivingWho(
                                rs.getInt("deliveryId")
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

//    public void edit(TextField package_id) {
//        try {
//            String value1 = package_id.getText();
//            String value2 = Integer.toString(Context.getInstance().getId());
//
//
//
//            String sql = "UPDATE `Package` SET `courier_id`='" + value2 + "' WHERE `package_id`='" + value1 + "' ";
//
//            pst = connection.prepareStatement(sql);
//            pst.execute();
//            receivingOrderController.updateTable();
//
//        }catch (Exception e){}
//    }
}