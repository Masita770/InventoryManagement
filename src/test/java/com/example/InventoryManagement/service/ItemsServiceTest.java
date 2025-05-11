package com.example.InventoryManagement.service;


import com.example.InventoryManagement.domain.Items;
import com.example.InventoryManagement.domain.Orders;
import com.example.InventoryManagement.domain.Stocks;
import com.example.InventoryManagement.mapper.ItemsMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ItemsServiceTest {

    @InjectMocks
    ItemServiceImpl itemsService;

    @Mock
    ItemsMapper itemsMapper;


    @Test
    void データ一覧を取得できるか検証() {
        List<Items> itemsList = List.of(
                new Items(1, "机", "オフィスデスク", "0000-00-00 00:00:00","0000-00-00 00:00:00"),
                new Items(2, "机", "オフィスデスク", "0000-00-00 00:00:00", "0000-00-00 00:00:00"),
                new Items(3, "机", "ゲーミングデスク", "2024-09-16 22:36:15", "0000-00-00 00:00:00")
        );
        doReturn(itemsList).when(itemsMapper).itemsSelectAll();
        List<Items> actual = itemsService.getSelectAll();
        Assertions.assertThat(actual).isEqualTo(itemsList);
        verify(itemsMapper, times(1)).itemsSelectAll();
    }

    // TODO 削除処理のテストを完成させる
    @Test
    void 選択したデータを削除できるか検証() {
        Orders orders = new Orders(2, 1, 20, "2025-03-20 23:49:23");
//        doReturn()
    }
}
