package com.example.InventoryManagement.service;


import com.example.InventoryManagement.domain.Items;
import com.example.InventoryManagement.mapper.ItemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsService {

    @Autowired
    ItemsMapper itemsMapper;


    public List<Items> getSelectAll() {
        return itemsMapper.itemsSelectAll();
    }
}
