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
}