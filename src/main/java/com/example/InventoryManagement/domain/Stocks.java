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
    private int stockId;
    private int itemsId;
    private int quantity;
    private String updateDate;


    public Stocks(int stockId, int itemsId, int quantity, String updateDate) {
        this.stockId = stockId;
        this.itemsId = itemsId;
        this.quantity = quantity;
        this.updateDate = updateDate;
    }
}
