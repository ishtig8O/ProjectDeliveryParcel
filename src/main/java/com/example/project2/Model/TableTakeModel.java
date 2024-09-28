package com.example.project2.Model;
import com.example.project2.Context;
import com.example.project2.Controller.TableTakeController;
import com.example.project2.Table.TableStaffWho;
import com.example.project2.Table.TableTakeWho;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

import java.sql.*;

public class TableTakeModel {

    Connection connection = null;

    PreparedStatement pst = null;

    TableTakeController tableTakeController;



    public TableTakeModel(TableTakeController t) {

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
        this.tableTakeController = t;
    }



    public  ObservableList<TableTakeWho> getDate() {
        ObservableList<TableTakeWho> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT dc.center_address as centerAddress ,c.client_address as clientAddress ,p.delivery_id as deliveryId ,p.package_id as packageId FROM Package as p inner join Delivery as d on p.delivery_id = d.delivery_id inner join Client as c on d.recipient_id = c.client_id inner join Delivery_Center as dc on p.center_id = dc.center_id inner join Courier as cc on dc.center_id = cc.center_id where p.center_id = c.delivery_point_id and p.courier_id is null and cc.courier_id = ?;");
            ps.setInt(1, Context.getInstance().getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(
                        new TableTakeWho(
                                rs.getString("centerAddress")
                                , rs.getString("clientAddress")
                                , rs.getInt("deliveryId")
                                , rs.getInt("packageId")
                        )
                );

            }
        }catch (Exception e){
            System.out.println(e);

        }
        return list;
    }



    public void edit(TextField package_id) {
//        try {
            String value1 = package_id.getText();
            String value2 = Integer.toString(Context.getInstance().getId());



//            String sql = "UPDATE `Package` SET `courier_id`='" + value2 + "' WHERE `package_id`='" + value1 + "' ";
            String sql = "UPDATE `Package` SET `courier_id`=? WHERE `package_id`=?";

            try {
                pst = connection.prepareStatement(sql);
                pst.setString(1, value2);
                pst.setString(2, value1);
                pst.executeUpdate();

                tableTakeController.updateTable();
            }catch (Exception e){
                System.out.println(e);
            }

//            pst = connection.prepareStatement(sql);
//            pst.execute();
//            tableTakeController.updateTable();

//        }catch (Exception e){}
    }
}