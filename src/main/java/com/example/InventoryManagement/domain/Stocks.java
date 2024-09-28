package com.example.InventoryManagement.domain;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Stocks {
    private int id;
    private int itemsId;
    private int quantity;
    private String updateDate;

    public Stocks(int id, int itemsId, int quantity, String updateDate) {
        this.id = id;
        this.itemsId = itemsId;
        this.quantity = quantity;
        this.updateDate = updateDate;
    }
}
