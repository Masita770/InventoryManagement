package com.example.InventoryManagement.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Orders {
    private int orderId;
    private int itemsId;
    private int orderDate;
    private String deliveryDate;

    public Orders(int orderId, int itemsId, int orderDate, String deliveryDate) {
        this.orderId = orderId;
        this.itemsId = itemsId;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
    }
}
