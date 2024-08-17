//package com.example.demo4;
//
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.TextFieldTableCell;
//
//import java.lang.reflect.Field;
//import java.sql.*;
////
//public class Connect {
//    Registration registration;
//
//    TextField registration7;
//
//
////    public Connect (Registration registration){
////        this.registration = registration;
////        registration7 = registration.get();
////    }
////
////    public static void iii() {
////
////    }
//
//    public static void main(String[] args){
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
////
//            Connection connection = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:8080/deliveryTest",
//                    "root", "");
////
//            Statement statement = connection.createStatement();
//            String query = "SELECT * FROM Client";
//            ResultSet result = statement.executeQuery(query);
//
//            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8080/deliveryTest", "root", "")){
//
//                Statement statement1 = conn.createStatement();
//                int rows = statement1.executeUpdate("INSERT INTO `Client`(`client_id`, `client_name`, `client_phone_number`, `client_address`, `delivery_point_id`) VALUES ('0','value','ddd','tttt', 9)");
//                System.out.printf("Added %d rows", rows);
//            }
//
//
//            while(result.next()){
//                int id = result.getInt("client_id");
//                String name = result.getString("client_name");
//                String short_name = result.getString("client_phone_number");
////
//
//                System.out.print("Vacant post: ");
//                System.out.print("id = " + id);
//                System.out.print(", name = \"" + name + "\"");
//                System.out.println(", short name = \"" + short_name + "\".");
//            }
//
//            connection.close();
//        }
//        catch(Exception e){
//            System.out.println(e);
//        }
//    }
//
//
//}
//
//package com.example.demo4;
//
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.TextFieldTableCell;
//
//import java.lang.reflect.Field;
//import java.sql.*;
////
//public class Connect {
//    Registration registration;
//
//    TextField registration7;
//
//
//    public Connect (Registration registration){
//        this.registration = registration;
//        iii(registration);
//    }
//
//    public static void iii(Registration registration) {
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
////
//            Connection connection = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:8080/deliveryTest",
//                    "root", "");
////
//            Statement statement = connection.createStatement();
//            String query = "SELECT * FROM Client";
//            ResultSet result = statement.executeQuery(query);
//
//            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8080/deliveryTest", "root", "")){
//
//                Statement statement1 = conn.createStatement();
//                int rows = statement1.executeUpdate("INSERT INTO `Client`(`client_id`, `client_name`, `client_phone_number`, `client_address`, `delivery_point_id`) VALUES ('"+ registration.get() +"','value','ddd','tttt', 9)");
//                System.out.printf("Added %d rows", rows);
//            }
//
//
//            while(result.next()){
//                int id = result.getInt("client_id");
//                String name = result.getString("client_name");
//                String short_name = result.getString("client_phone_number");
////
//
//                System.out.print("Vacant post: ");
//                System.out.print("id = " + id);
//                System.out.print(", name = \"" + name + "\"");
//                System.out.println(", short name = \"" + short_name + "\".");
//            }
//
//            connection.close();
//        }
//        catch(Exception e){
//            System.out.println(e);
//        }
//    }
//
//    public static void main(String[] args){
//
//    }
//
//
//}