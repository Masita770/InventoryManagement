package com.example.InventoryManagement.domain;

import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class Items {
    private int itemId;
    private String category;
    private String item;
    private String registrationDate;
    private String deletedDate;

    private List<Stocks> stocksList;

    private List<Orders> ordersList;
//    Orders ordersList;

    public Items(int itemId,String category, String item, String registrationDate, String deletedDate, List<Stocks> stocksList, List<Orders> ordersList) {
        this.itemId = itemId;
        this.category = category;
        this.item = item;
        this.registrationDate = registrationDate;
        this.deletedDate = deletedDate;
        this.stocksList = stocksList;
        this.ordersList = ordersList;
//        this.ordersList = ordersList;
    }
}
