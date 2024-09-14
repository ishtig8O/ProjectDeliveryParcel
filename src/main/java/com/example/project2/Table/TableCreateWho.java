package com.example.project2.Table;

import javafx.scene.control.cell.PropertyValueFactory;

public class TableCreateWho {



    String centerAddress;
    String clientAddress;
    Integer deliveryId;
    Integer packageId;
    Integer typeId;
    Integer weight;
    String uniqueCode;




    public  TableCreateWho(String centerAddress, String clientAddress, Integer deliveryId, Integer packageId, Integer typeId, Integer weight, String uniqueCode) {
        this.centerAddress = centerAddress;
        this.clientAddress = clientAddress;
        this.deliveryId = deliveryId;
        this.packageId = packageId;
        this.typeId = typeId;
        this.weight = weight;
        this.uniqueCode = uniqueCode;
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
    public Integer getTypeId() {
        return typeId;
    }
    public Integer getWeight() {
        return weight;
    }
    public String getUniqueCode() {
        return uniqueCode;
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
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
    public void setWeight(Integer weight) {
        this.weight = weight;
    }
    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode;
    }
}
