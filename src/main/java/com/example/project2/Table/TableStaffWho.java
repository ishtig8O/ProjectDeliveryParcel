package com.example.project2.Table;

public class TableStaffWho {



    Integer id_staff;
    String name;
    String phone;


    public  TableStaffWho(Integer id_staff, String name, String phone) {
        this.id_staff = id_staff;
        this.name = name;
         this.phone = phone;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setId_staff(int id_staff) {
        this.id_staff = id_staff;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
