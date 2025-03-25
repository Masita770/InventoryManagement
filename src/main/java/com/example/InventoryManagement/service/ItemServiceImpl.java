package com.example.InventoryManagement.service;


import com.example.InventoryManagement.domain.Items;
import com.example.InventoryManagement.domain.Orders;
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
    public List<Orders> getOrderAll(int itemsId) {
        return itemsMapper.orderAll(itemsId);
    }

    @Override
    public Optional<Items> getSelectOne(int itemsId) {
        return itemsMapper.itemsSelectOne(itemsId);
    }

    @Override
    public void requestItemAdd(Items items) {
        itemsMapper.itemAdd(items);
    }


    // 在庫更新　注文データ追加
    @Override
    public void orderAdd(Orders orders) {
//        Optional<Items> items = itemsMapper.itemsSelectOne(orders.getItemsId());
//        if(items == null) {
//            throw  new RuntimeException("この製品は存在しません");
//        }
        itemsMapper.orderAdd(orders);
    }

//    @Override
//    public void itemOrderAdd(Orders orders) {
//        itemsMapper.itemOrderAdd(orders);
//    }


    @Override
    public void itemOrderDelete(Items delete) {
        itemsMapper.deleteOrder(delete);
    }



    @Override
    public List<Items> orderSelect() {
        return itemsMapper.orderSelect();
    }


//    @Override
//    public List<Orders> orderAll() {
//        return itemsMapper.orderAll();
//    }

    @Override
    public void itemRequestOrder(Items items) {

    }
}
