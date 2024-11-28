package com.example.InventoryManagement.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Setter
@Getter
@NoArgsConstructor
public class Stocks {
    private int id;
    private int itemsId;
    private int quantity;
    private String updateDate;
    public List<Orders> ordersList;

    public Stocks(int id, int itemsId, int quantity, String updateDate, List<Orders> ordersList) {
        this.id = id;
        this.itemsId = itemsId;
        this.quantity = quantity;
        this.updateDate = updateDate;
        this.ordersList = ordersList;
    }
}
