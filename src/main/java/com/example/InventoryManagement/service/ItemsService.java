package com.example.InventoryManagement.service;


import com.example.InventoryManagement.domain.Items;
import com.example.InventoryManagement.domain.Stocks;
import com.example.InventoryManagement.mapper.ItemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ItemsService {


    List<Items> getSelectAll();

    @Transactional
    Optional<Items> getSelectOne(int id);

    @Transactional
    void requestItemAdd(Items items);

    @Transactional
    void itemDetailUpdate(Stocks stocks);
}

