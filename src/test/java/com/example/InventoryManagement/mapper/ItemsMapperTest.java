package com.example.InventoryManagement.mapper;


import com.example.InventoryManagement.domain.Items;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@MybatisTest
//@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@ExtendWith(MockitoExtension.class)
class ItemsMapperTest {

//    @InjectMocks
//    ItemsService itemsService;

    @Autowired
    ItemsMapper itemsMapper;


    @Test
    @DataSet(value = "datasets/tests.yml")
    void 全件一覧取得できるか検証() {
        List<Items> itemsList = itemsMapper.itemsSelectAll();
        Assertions.assertThat(itemsList).hasSize(3).contains(
                //TODO: 値をtests.ymlと合わせる
                new Items(3, "机", "オフィスデスク", "2025-03-06 23:45:18", "0000-00-00 00:00:00"),
                new Items(4, "机", "キッチンテーブル", "2025-03-06 23:45:57", "0000-00-00 00:00:00"),
                new Items(5, "机", "ゲーミングデスク", "2025-03-06 23:46:32", "0000-00-00 00:00:00")
        );
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
