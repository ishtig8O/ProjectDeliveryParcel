package com.example.project2.Table;

public class TableDeliveryWho {



    Integer id;
    String name;
    String address;


    public  TableDeliveryWho(Integer center_id, String name, String address) {
        this.id = center_id;
        this.name = name;
        this.address = address;
    }
    //
    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int center_id) {
        this.id = center_id;
    }

    public void setAddress(String phone) {
        this.address = phone;
    }

}
