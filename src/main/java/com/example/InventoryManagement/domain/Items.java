package com.example.InventoryManagement.domain;

import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Items {
    private int itemsId;
    private String category;
    private String item;
    private String registrationDate;
    private String deletedDate;

    private List<Stocks> stocksList;

    private List<Orders> ordersList;
//    Orders ordersList;

    public Items(int itemsId,String category, String item, String registrationDate, String deletedDate) {
        this.itemsId = itemsId;
        this.category = category;
        this.item = item;
        this.registrationDate = registrationDate;
        this.deletedDate = deletedDate;
    }
}
