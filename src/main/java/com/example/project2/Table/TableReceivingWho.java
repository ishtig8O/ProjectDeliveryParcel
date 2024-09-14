package com.example.project2.Table;

import javafx.scene.control.cell.PropertyValueFactory;

public class TableReceivingWho {

    Integer deliveryId;
    Integer typeId;
    Integer weight;
    String uniqueCode;




    public  TableReceivingWho(Integer deliveryId, Integer typeId, Integer weight, String uniqueCode) {

        this.deliveryId = deliveryId;
        this.typeId = typeId;
        this.weight = weight;
        this.uniqueCode = uniqueCode;
    }


    public Integer getDeliveryId() {
        return deliveryId;
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
    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
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
