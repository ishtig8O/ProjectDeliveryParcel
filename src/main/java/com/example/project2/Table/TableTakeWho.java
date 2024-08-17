package com.example.project2.Table;

import javafx.scene.control.cell.PropertyValueFactory;

public class TableTakeWho {



    String centerAddress;
    String clientAddress;
    Integer deliveryId;
    Integer packageId;




    public  TableTakeWho(String centerAddress, String clientAddress, Integer deliveryId, Integer packageId) {
        this.centerAddress = centerAddress;
        this.clientAddress = clientAddress;
        this.deliveryId = deliveryId;
        this.packageId = packageId;
    }

    public String getCenterAddress() {
        return centerAddress;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setCenterAddress(String centerAddress) {
        this.centerAddress = centerAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }
}
