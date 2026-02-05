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
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ItemsServiceTest {

    @InjectMocks
    ItemServiceImpl itemsService;

    @Mock
    ItemsMapper itemsMapper;


    @Test
    void 製品一覧を全件取得できるか検証() {
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

    @Test
    void 商品選択と注文データを取得() {
        Optional<Items> i = Optional.of(
                new Items(1, "机", "オフィスデスク", "0000-00-00 00:00:00","FALSE",  List.of(new Stocks()), List.of(new Orders(47, 1, 20, "2025-11-12 23:48:00"),
                        new Orders(48, 1, 20, "2025-11-17 20:08:37"),
                        new Orders(49, 1, 20, "2025-11-17 22:22:52"),
                        new Orders(50, 1, 20, "2025-11-30 19:54:16"),
                        new Orders(64, 1, 3, "2025-12-18 22:56:14")))
        );
        doReturn(i).when(itemsMapper).itemsSelectOne(1);
        Optional<Items> actual = itemsService.getSelectOne(1);
        Assertions.assertThat(actual).isEqualTo(i);
        verify(itemsMapper, times(1)).itemsSelectOne(1);
//        Optional<Items> i = itemsMapper.itemsSelectOne(1);
    }

    // TODO 削除処理のテストでitemsMapperが呼び出されない理由を調べる
    @Test
    void 選択したデータを削除できるか検証() {
        Orders orders = new Orders(2, 1, 20, "2025-03-20 23:49:23");
//        this.itemsMapper.orderDelete(orders);
//        doReturn(Optional.of(orders)).when(itemsMapper).orderOne(2);
        doNothing().when(itemsMapper).orderDelete(orders);
        itemsService.orderDelete(orders);
        verify(itemsMapper, times(1)).orderDelete(orders);
    }
}
