package com.example.InventoryManagement.domain;

import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
public class Items {
    private int id;
    private String category;
    private String item;
    private String registrationDate;
    private String deletedDate;

    List<Stocks> stocksList;
//    Orders ordersList;

    public Items(int id,String category, String item, String registrationDate, String deletedDate, List<Stocks> stocksList, Orders ordersList) {
        this.id = id;
        this.category = category;
        this.item = item;
        this.registrationDate = registrationDate;
        this.deletedDate = deletedDate;
        this.stocksList = stocksList;
//        this.ordersList = ordersList;
    }
}
