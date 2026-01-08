package com.example.InventoryManagement.mapper;


import com.example.InventoryManagement.domain.Items;
import com.example.InventoryManagement.domain.Orders;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.List;
import java.util.Optional;


@MybatisTest
//@Transactional
class ItemsMapperTest {


    @Autowired
    private ItemsMapper itemsMapper;



//    @Test
//    void test_selectededById() {
//        List<Items> items = itemsMapper.itemsSelectOne(List.of("1"));
//    }

    @Test
//    @Sql(scripts = "/data.sql")
    void 全件一覧取得できるか検証() {
        List<Items> actual = itemsMapper.itemsSelectAll();
//        System.out.println(actual.size());
        assertThat(actual).hasSize(3);
    }
//        Assertions.assertThat(1);
//        List<Items> expected = List.of(
//                Assertions.assertThat(new Items(1, "机", "オフィスデスク", "2025-03-16 21:01:30", "0000-00-00 00:00:00")),
//                Assertions.assertThat(new Items(2, "机", "キッチンテーブル", "2025-03-12 23:43:21", "0000-00-00 00:00:00")),
//                Assertions.assertThat(new Items(3, "机", "ゲーミングデスク", "2025-03-12 23:43:31", "0000-00-00 00:00:00"));
//        List<Items> itemsList = itemsMapper.itemsSelectAll();
//        Assertions.assertThat(expected);

//        Assertions.assertThat(itemsList).hasSize(3);
//        Assertions.assertThat(itemsList).hasSize(3).contains(
//                new Items(1, "机", "オフィスデスク", "2025-03-16 21:01:30", "0000-00-00 00:00:00"),
//                new Items(2, "机", "キッチンテーブル", "2025-03-12 23:43:21", "0000-00-00 00:00:00"),
//                new Items(3, "机", "ゲーミングデスク", "2025-03-12 23:43:31", "0000-00-00 00:00:00")
//        );
//        List<Stocks> stocksList = List.of(
//                new Stocks(1, 1, 5, "0000-00-00 00:00:00")
//        );
//        List<Orders> ordersList = List.of(
//                new Orders(1, 1, 5, "0000-00 00:00:00")
//        );
//    }

//    @Test
////    @Sql()
//    @DataSet(value = "datasets/tests.yml")
//    @ExpectedDataSet(value = "datasets/tests_expected.yml")
//    @Transactional
//    void 一件取得できるか検証() throws Exception {
//        Optional<Items> selectOne = itemsMapper.itemsSelectOne(1);
////        Mockito.doReturn(Optional.of(selectOne)).when(itemsMapper.itemsSelectOne(id))
//        Assertions.assertThat(selectOne).isEqualTo(Optional.of(
////                new Items()));
//                new Items(1, "机", "オフィスデスク", "0000-00-00 00:00:00", "0000-00-00 00:00:00")));
//    }
//
//    @Test
//    @DataSet(value = "insertTest.yml")
//    @ExpectedDataSet(value = "insertTest_expected.yml")
//    void insertテスト() {
//        itemsMapper.orderAdd(new Orders(2, 1, 20, "2025-03-20 23:49:23"));
////        Orders orders = new Orders(2,1, 20, "2025-03-20 23:49:23");
////        itemsMapper.orderAdd(orders);
//
//        //TODO: 注文データを確認する機能を付ける必要性
////        Orders orders1 = itemsMapper.itemsSelectOne(orders.getOrderId()).orElse(null);
//
//        }
//
//    @Test
//    void updateTest() throws Exception{
//    }
//
//
//    @Test
//    @DataSet(value = "deleteTest.yml")
//    @ExpectedDataSet(value = "deleteTest_expected.yml")
//    void deleteTest() {
//        itemsMapper.orderDelete(new Orders(2, 1, 20, "2025-03-20 23:49:23"));
//        }
}
