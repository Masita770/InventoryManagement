package com.example.InventoryManagement.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class Stocks {
    private int id;
    private int itemsId;
    private int quantity;
    private String updateDate;
    Orders ordersList;

    public Stocks(int id, int itemsId, int quantity, String updateDate, Orders ordersList) {
        this.id = id;
        this.itemsId = itemsId;
        this.quantity = quantity;
        this.updateDate = updateDate;
        this.ordersList = ordersList;
    }
}
