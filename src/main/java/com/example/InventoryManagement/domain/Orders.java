package com.example.InventoryManagement.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Orders {
    private int id;
    private int itemsId;
    private int stocksId;
    private int orderDate;
    private String deliveryDate;

    public Orders(int id, int itemsId, int stocksId, int orderDate, String deliveryDate) {
        this.id = id;
        this.itemsId = itemsId;
        this.stocksId = stocksId;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
    }
}
