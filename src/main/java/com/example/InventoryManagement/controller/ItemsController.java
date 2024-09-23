package com.example.InventoryManagement.controller;


import com.example.InventoryManagement.domain.Items;
import com.example.InventoryManagement.form.ItemRequestForm;
import com.example.InventoryManagement.service.ItemsService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("index")
    public String itemsAll(Model model) {
        List<Items> getAll = itemsService.getSelectAll();
        model.addAttribute("items", getAll);
        return "items/index";
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
//    public String newItem(@RequestBody(required = false) Model model) {
        return "items/form";
    }
    @PostMapping("itemRequestEdit")
    public String formItemAdd(@ModelAttribute Items items, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
//            List<Items> itemsList = itemsService.getSelectAll();
//            model.addAttribute("item", itemsList);
            return "items/form";
        }
        itemsService.requestItemAdd(items);
        return "redirect:index";
    }
}
