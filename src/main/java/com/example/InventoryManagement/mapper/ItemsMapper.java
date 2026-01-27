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

    List<Orders> orderAll(int itemsId);

    Optional<Items> itemsSelectOne(int itemsId);

    void itemAdd(Items items);

    void orderAdd(Orders orders);

    Optional<Orders> orderOne(int ordersId);
    void orderDelete(Orders orders);


    List<Items> orderSelect();
}
