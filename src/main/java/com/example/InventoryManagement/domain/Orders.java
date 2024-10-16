package com.example.InventoryManagement.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Orders {
    private int id;
    private int stocksId;
    private int orderDate;
    private String deliveryDate;

    public Orders(int id, int stocksId, int orderDate, String deliveryDate) {
        this.id = id;
        this.stocksId = stocksId;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
    }
}
