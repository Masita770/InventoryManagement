package com.example.InventoryManagement.domain;

import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class Items {
    private int id;
    private String category;
    private String item;
    private String registrationDate;
    private String deletedDate;

    private Stocks stocksList;
//    Orders ordersList;

    public Items(int id,String category, String item, String registrationDate, String deletedDate, Stocks stocksList, Orders ordersList) {
        this.id = id;
        this.category = category;
        this.item = item;
        this.registrationDate = registrationDate;
        this.deletedDate = deletedDate;
        this.stocksList = stocksList;
//        this.ordersList = ordersList;
    }
}
