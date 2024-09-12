package com.example.InventoryManagement.mapper;

import com.example.InventoryManagement.domain.Items;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemsMapper {

    List<Items> itemsSelectAll();

    void itemAdd(Items items);
}
