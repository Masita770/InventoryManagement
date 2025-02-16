package com.example.InventoryManagement.mapper;


import com.example.InventoryManagement.domain.Items;
import com.example.InventoryManagement.domain.Stocks;
import com.github.database.rider.core.api.dataset.DataSet;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ListAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@MybatisTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@ExtendWith(MockitoExtension.class)
class ItemsMapperTest {

//    @InjectMocks
//    ItemsService itemsService;

    @Autowired
    ItemsMapper itemsMapper;


    @Test
    @DataSet(value = "com/example/InventoryManagement/ItemsMapperTest.yml")
    @Transactional
    void 全件一覧取得できるか検証() {
        List<Items> sut = itemsMapper.itemsSelectAll();
//        List<Items> itemsList = Assertions.assertThat(sut).hasSize(3).contains(
//                new Items(1, "机", "オフィスデスク", "0000-00-00 00:00:00", "0000-00-00-00-00-0000"),
//                new Items(2, "机", "オフィスデスク", "0000-00-00 00:00:00", "0000-00-00-00-00-0000"),
//                new Items(3, "机", "ゲーミングデスク", "2024-09-16 22:36:15", "0000-00-00-00-0000")
//        );
    }

    @Test
//    @Sql()
    @Transactional
    void 一件取得できるか検証() throws Exception {
        Optional<Items> selectOne = itemsMapper.itemsSelectOne(1);
//        Mockito.doReturn(Optional.of(selectOne)).when(itemsMapper.itemsSelectOne(id))
        Assertions.assertThat(selectOne).isEqualTo(Optional.of(
//                new Items()));
                new Items(1, "机", "オフィスデスク", "0000-00-00 00:00:00", "0000-00-00 00:00:00")));
    }
}
