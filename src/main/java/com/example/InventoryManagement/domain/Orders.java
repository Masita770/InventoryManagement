package com.example.InventoryManagement.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Orders {
    private int ordersId;
    private int itemsId;
    private int orderDate;
    private String deliveryDate;

    public Orders(int ordersId, int itemsId, int orderDate, String deliveryDate) {
        this.ordersId = ordersId;
        this.itemsId = itemsId;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
    }
}
