package com.example.InventoryManagement.service;


import com.example.InventoryManagement.domain.Items;
import com.example.InventoryManagement.domain.Orders;
import com.example.InventoryManagement.form.OrderRequestForm;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ItemsService {

//item全件取得処理
    List<Items> getSelectAll();

//    Optional<Items> getItemOrderAll(int id);

    @Transactional
    Optional<Items> getSelectOne(int itemsId);

    // 製品ごとの注文全件表示
    @Transactional
    List<Orders> getOrderAll(int itemsId);

//    @Transactional
    void requestItemAdd(Items items);

    void orderForm(OrderRequestForm orderRequestForm);

    @Transactional
    void orderAdd(Orders orders);

    @Transactional
    Optional<Orders> orderOne(int ordersId);
    @Transactional
    void orderDelete(Orders delete);


    @Transactional
    List<Items> orderSelect();

// TODO: Ordersを排した修正をSeviceimplで行う
    // 発注処理
//    @Transactional
//    List<Orders> orderAll();

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
}

