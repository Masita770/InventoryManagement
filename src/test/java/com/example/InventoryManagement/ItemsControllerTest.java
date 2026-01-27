package com.example.InventoryManagement;

import com.example.InventoryManagement.controller.ItemsController;
import com.example.InventoryManagement.service.ItemsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(ItemsController.class)
public class ItemsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private ItemsService itemsService;


    @Test
    void 製品一覧全件取得() throws Exception{
        mockMvc.perform(get("/items/index"))
                .andExpect(MockMvcResultMatchers.status().isOk());
//                .andExpect(MockMvcResultMatchers.content().json("[]"));
        Mockito.verify(itemsService, Mockito.times(1)).getSelectAll();
//                .andExpect(MockMvcResultMatchers.view().name("items/items"))
//                .andExpect(MockMvcResultMatchers.content().string());
    }
}
