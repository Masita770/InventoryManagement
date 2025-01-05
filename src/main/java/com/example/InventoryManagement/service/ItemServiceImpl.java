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
    public Optional<Items> getItemOrderAll(int id) {
        return itemsMapper.itemOrderAll(id);
    }

    @Override
    public Optional<Items> getSelectOne(int id) {
        return itemsMapper.itemsSelectOne(id);
    }

    @Override
    public void requestItemAdd(Items items) {
        itemsMapper.itemAdd(items);
    }

    @Override
    public void itemOrderAdd(Orders orders) {

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


    @Override
    public List<Orders> orderAll() {
        return itemsMapper.orderAll();
    }

    @Override
    public void itemRequestOrder(Items items) {

    }


    //    @Override
//    public void requestOrder(Items items) {
//        itemsMapper.itemAdd(items);
//        for (Stocks stocks : items.getStocksList()) {
//            stocks.setItemsId(items.getId());
//            itemsMapper.requestStock(stocks);
//            for (Orders orders : stocks.ordersList) {
//                orders.setStocksId(stocks.getId());
//                itemsMapper.itemOrderAdd(orders);
//            }
//        }
    @Override
    public void itemOrderRequest(Items items, Orders orders) {
        itemsMapper.itemRequestOrder(items, orders);
    }
}
