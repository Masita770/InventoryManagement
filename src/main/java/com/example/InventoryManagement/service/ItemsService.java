package com.example.InventoryManagement.service;


import com.example.InventoryManagement.domain.Items;
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
    void itemDetailUpdate(Items items);

    @Transactional
    void itemOrderDelete(Items delete);


    @Transactional
    List<Items> orderSelect();
}

