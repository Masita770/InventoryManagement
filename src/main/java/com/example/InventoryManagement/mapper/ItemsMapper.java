package com.example.InventoryManagement.mapper;

import com.example.InventoryManagement.domain.Items;
import com.example.InventoryManagement.domain.Orders;
import com.example.InventoryManagement.domain.Stocks;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ItemsMapper {

    List<Items> itemsSelectAll();

    Optional<Items> itemOrderAll(int id);

    Optional<Items> itemsSelectOne(int itemId);

    void itemAdd(Items items);

    void orderAdd(Orders orders);
    Orders orderOne(int orderId);

    List<Orders> orderAll();


    void deleteOrder(Items delete);


    List<Items> orderSelect();
}
