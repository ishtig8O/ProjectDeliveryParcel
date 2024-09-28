package com.example.project2.Table;

public class TableStaffWho {



    Integer id_staff;
    String name;
    String phone;
    Integer center_id;


    public  TableStaffWho(Integer id_staff, String name, String phone, Integer center_id) {
        this.id_staff = id_staff;
        this.name = name;
        this.phone = phone;
        this.center_id = center_id;
    }
//
    public int getId_staff() {
        return id_staff;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }
    public Integer getCenter_id() {
        return center_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId_staff(int id_staff) {
        this.id_staff = id_staff;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setCenter_id(int center_id) {
        this.center_id = center_id;
    }

}
