package com.example.InventoryManagement.controller;


import com.example.InventoryManagement.domain.Items;
import com.example.InventoryManagement.domain.Orders;
import com.example.InventoryManagement.service.ItemsService;
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


    @GetMapping("itemDetail/{id}")
    public String itemsOne(@PathVariable("id")int itemId, Model model) throws NotFoundException {
        Optional<Items> itemsOne = itemsService.getSelectOne(itemId);
        itemsOne.ifPresentOrElse(inside -> model.addAttribute("item", inside), () ->
                model.addAttribute("not", itemsOne)
        );
        return "items/itemDetail";
    }

    @GetMapping("form")
    public String newItem(@RequestBody(required = false) Model model, Items items) {
//        ItemRequestForm itemRequestForm = new ItemRequestForm();
//       items.setCategory(itemRequestForm.getCategory());
//       items.setItem(itemRequestForm.getItem());
//        model.addAttribute("select", items);
        return "items/form";
    }

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
    public String itemUpdate(@PathVariable("id") int itemId, Model model) {
        Optional<Items> quantityUpdate = itemsService.getSelectOne(itemId);
        quantityUpdate.ifPresentOrElse(inside -> {
            model.addAttribute("itemUpdate", inside);
        }, () -> {
            System.out.println();
        });
        return "items/itemQuantityUpdate";
    }



    @GetMapping("orderForm")
    String newOrder(@RequestBody(required = false) Orders orders, Model model) {
        return "items/orderForm";
    }

    //TODO: ordersに登録しようとして、itemsに行ってしまう理由を探す。
    @PostMapping("itemOrderEdit")
    public String orderRequest(@ModelAttribute Orders orders, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            List<Orders> i = itemsService.orderAll();
            model.addAttribute("i", i);
            return "items/itemOrderEdit";
        }
        itemsService.orderAdd(orders);
        return "redirect:index";
    }
}
