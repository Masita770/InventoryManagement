package com.example.InventoryManagement.domain;

import lombok.*;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class Items {
    private int id;
    private String category;
    private String item;
    private String registrationDate;
    private String deletedDate;

    public Items(int id,String category, String item, String registrationDate, String deletedDate) {
        this.id = id;
        this.category = category;
        this.item = item;
        this.registrationDate = registrationDate;
        this.deletedDate = deletedDate;
    }
}
