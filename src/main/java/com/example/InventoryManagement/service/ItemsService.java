package com.example.InventoryManagement.service;


import com.example.InventoryManagement.domain.Items;
import com.example.InventoryManagement.domain.Orders;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ItemsService {


    List<Items> getSelectAll();

    Optional<Items> getItemOrderAll(int id);

    @Transactional
    Optional<Items> getSelectOne(int id);

    @Transactional
    void requestItemAdd(Items items);


    @Transactional
    void itemOrderAdd(Orders orders);

    @Transactional
    void itemOrderDelete(Items delete);


    @Transactional
    List<Items> orderSelect();

// TODO: Ordersを排した修正をSeviceimplで行う
    // 発注処理
    @Transactional
    List<Orders> orderAll();

    @Transactional
    void itemRequestOrder(Items items);

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
    void itemOrderRequest(Items items, Orders orders);
}

