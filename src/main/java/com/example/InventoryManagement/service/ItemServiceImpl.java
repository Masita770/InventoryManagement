package com.example.InventoryManagement.service;


import com.example.InventoryManagement.domain.Items;
import com.example.InventoryManagement.domain.Stocks;
import com.example.InventoryManagement.mapper.ItemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    public Optional<Items> getSelectOne(int id) {
        return itemsMapper.itemsSelectOne(id);
    }

    @Override
    public void requestItemAdd(Items items) {
        itemsMapper.itemAdd(items);
    }

//    @Override
//    public Optional<Stocks> getStockOne(int id) {
//        return itemsMapper.stockSelectOne(id);
//    }
    @Override
    public void itemDetailUpdate(Items items) {
        itemsMapper.itemDetailUpdate(items);
    }
}
