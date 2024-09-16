package com.example.InventoryManagement.service;


import com.example.InventoryManagement.domain.Items;
import com.example.InventoryManagement.mapper.ItemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemsService{

    @Autowired
    ItemsMapper itemsMapper;

    @Override
    public List<Items> getSelectAll() {
        return itemsMapper.itemsSelectAll();
    }

    @Override
    public void requestItemAdd(Items items) {
        itemsMapper.itemAdd(items);
    }
}
