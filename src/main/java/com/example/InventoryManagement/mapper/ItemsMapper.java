package com.example.InventoryManagement.mapper;

import com.example.InventoryManagement.domain.Items;
import com.example.InventoryManagement.domain.Stocks;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ItemsMapper {

    List<Items> itemsSelectAll();

    Optional<Items> itemsSelectOne(int id);

    void itemAdd(Items items);

    Optional<Stocks> stockSelectOne(int id);

    void itemDetailUpdate(Items items);
}
