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

    Optional<Items> itemsSelectOne(int id);

    void itemAdd(Items items);

    void orderAdd(Orders orders);

    List<Orders> orderAll();
//    Optional<Orders> itemOrderOne(int id);
//

    void requestStock(Stocks stocks);
    void itemOrderAdd(Items items);

    void deleteOrder(Items delete);


    List<Items> orderSelect();

    void itemRequestOrder(Items items, Orders orders);
}
