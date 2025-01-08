package com.example.InventoryManagement.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Orders {
    private int id;
    private int itemsId;
    private int orderDate;
    private String deliveryDate;

    public Orders(int id, int itemsId, int orderDate, String deliveryDate) {
        this.id = id;
        this.itemsId = itemsId;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
    }
}
