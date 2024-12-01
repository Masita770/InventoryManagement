package com.example.InventoryManagement.controller;


import com.example.InventoryManagement.domain.Items;
import com.example.InventoryManagement.domain.Orders;
import com.example.InventoryManagement.domain.Stocks;
import com.example.InventoryManagement.form.ItemRequestForm;
import com.example.InventoryManagement.service.ItemsService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/items")
public class ItemsController {

    private ItemsService itemsService;

    @Autowired
    public ItemsController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @RequestMapping("index")
    public String itemsAll(Model model) {
        List<Items> getAll = itemsService.getSelectAll();
        model.addAttribute("items", getAll);
        return "items/index";
    }

    @GetMapping("itemOrderList/{id}")
    public String itemOrder(@PathVariable("id")int id, Model model) {
        List<Items> itemOrderList = itemsService.getItemOrderAll(id);
        model.addAttribute("itemOrder", itemOrderList);
        return "items/itemOrderList";
    }


    @GetMapping("itemDetail/{id}")
    public String itemsOne(@PathVariable("id")int id, Model model) throws NotFoundException {
        Optional<Items> itemsOne = itemsService.getSelectOne(id);
        itemsOne.ifPresentOrElse(inside -> model.addAttribute("item", inside), () ->
                model.addAttribute("not", itemsOne)
        );
        return "items/itemDetail";
    }

    @GetMapping("form")
    public String newItem(Model model, Items items) {
        ItemRequestForm itemRequestForm = new ItemRequestForm();
       items.setCategory(itemRequestForm.getCategory());
       items.setItem(itemRequestForm.getItem());
        model.addAttribute("select", items);
        return "items/form";
    }
    //TODO: 品番登録後、個数入力できるようにする
    @PostMapping("itemRequestEdit")
    public String formItemAdd(@ModelAttribute Items items, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            List<Items> itemsList = itemsService.getSelectAll();
            model.addAttribute("item", itemsList);
            return "items/form";
        }
        itemsService.requestItemAdd(items);
        return "redirect:index";
    }

    @GetMapping("itemQuantityUpdate/{id}")
    public String itemUpdate(@PathVariable("id") int id, Model model) {
        Optional<Items> quantityUpdate = itemsService.getSelectOne(id);
        quantityUpdate.ifPresentOrElse(inside -> {
            model.addAttribute("itemUpdate", inside);
        }, () -> {
            System.out.println();
        });
        return "items/itemQuantityUpdate";
    }
        @RequestMapping("itemRequestEdit/{id}")
        public String itemRequestUpdate (@PathVariable("id") int id, @ModelAttribute Items items, Stocks stocks, Orders orders,Model model){
            items.setId(id);
            itemsService.itemDetailUpdate(items);
            return "items/itemRequestEdit";
            //TODO: 個数入力を更新処理で実現
        }

//        @GetMapping("r/{id}")
//        public String delete(@PathVariable("id")int id, Orders ordersList, Model model) {
//            Optional<Items> itemOrderDelete = itemsService.getSelectOne(id, ordersList);
//            itemOrderDelete.ifPresentOrElse(insideDelete -> {
//                model.addAttribute("orderDelete", insideDelete);
//            } , () ->
//                    System.out.println("u"));
//            model.addAttribute("d", itemOrderDelete);
//            return "items/r";
//        }



        @GetMapping("r")
        public String inventory(Model model) {
            List<Items> select = itemsService.orderSelect();
//            items.setStocksList(stocks.getItemsList().getStocksList());
//            model.addAttribute("r", items);
//            select.ifPresentOrElse(inside -> model.addAttribute("r", inside) , () ->
            model.addAttribute("r", select);
            return "items/r";
        }
}
