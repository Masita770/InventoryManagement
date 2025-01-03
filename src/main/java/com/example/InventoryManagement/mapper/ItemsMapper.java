package com.example.InventoryManagement.mapper;

import com.example.InventoryManagement.domain.Items;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ItemsMapper {

    List<Items> itemsSelectAll();

    Optional<Items> itemOrderAll(int id);

    Optional<Items> itemsSelectOne(int id);

    void itemAdd(Items items);

    void itemDetailUpdate(Items items);

    void deleteOrder(Items delete);


    List<Items> orderSelect();
}
