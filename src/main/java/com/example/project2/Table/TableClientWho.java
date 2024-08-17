package com.example.project2.Table;

public class TableClientWho {



    Integer id;
    String name;
    String address;

    String phone;
    Integer delivery;



    public  TableClientWho(Integer client_id, String name, String address, String phone, Integer delivery ) {
        this.id = client_id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.delivery = delivery;
    }
    //
    public int getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public Integer getDelivery() {
        return delivery;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int client_id) {
        this.id = client_id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDelivery(Integer delivery) {
        this.delivery = delivery;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
