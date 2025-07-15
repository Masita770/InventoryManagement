package com.example.InventoryManagement.controller;


import com.example.InventoryManagement.domain.Items;
import com.example.InventoryManagement.domain.Orders;
import com.example.InventoryManagement.form.OrderRequestForm;
import com.example.InventoryManagement.service.ItemsService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

//@RestController
@Controller
@RequestMapping("/items")
public class ItemsController {

    private ItemsService itemsService;

    @Autowired
    public ItemsController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @RequestMapping("/index")
    public String itemsAll(Model model) {
        List<Items> getAll = itemsService.getSelectAll();
        model.addAttribute("items", getAll);
        return "items/index";
    }

    // TODO: rest処理で実行するべし
    @GetMapping("orderList/{id}")
    public String orderAll(@PathVariable("id") int itemsId, Model model) {
        List<Orders> orders = itemsService.getOrderAll(itemsId);
        model.addAttribute("orders", orders);
        return "items/orderList";
    }


    @GetMapping("itemDetail/{id}")
    public String itemsOne(@PathVariable("id")int itemsId, Model model) throws NotFoundException {
        Optional<Items> itemsOne = itemsService.getSelectOne(itemsId);
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
    public String itemUpdate(@PathVariable("id") int itemsId, Model model) {
        Optional<Items> quantityUpdate = itemsService.getSelectOne(itemsId);
        quantityUpdate.ifPresentOrElse(inside -> {
            model.addAttribute("itemUpdate", inside);
        }, () -> {
            System.out.println();
        });
        return "items/itemQuantityUpdate";
    }



//    @GetMapping("orderForm")
//    public ModelAndView newOrder(@ModelAttribute OrderRequestForm orderRequestForm,
//                                 ModelAndView mav) {
//        mav.setViewName("items/orderForm");
//        mav.addObject(orderRequestForm.getItemsId());
//        mav.addObject(orderRequestForm.getOrderDate());
//        return mav;
//    }
    @GetMapping("orderForm")
    public String newOrder(Model model) {
        return "items/orderForm";
    }

    //TODO: ordersに登録しようとして、itemsに行ってしまう理由を探す。
    @PostMapping("itemOrderEdit")
    public String orderRequest(@Validated OrderRequestForm orderRequestForm, @ModelAttribute Orders orders, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "items/error";
        }
//        int itemsId = orders.getItemsId();
//        int orderDate = orders.getOrderDate();
        itemsService.orderAdd(orders);
        return "items/itemOrderEdit";
    }

    //TODO 2025/04/22 Formクラスに作成していく
//    @PostMapping("itemOrderEdit")
//    public String a(@ModelAttribute OrderRequestForm form, Model model) {
//        model.addAttribute("order", form.getOrderDate());
//        return "items/itemOrderEdit";
//    }

    @RequestMapping("orderDelete/{ordersId}")
    public String orderDelete(@PathVariable("ordersId")int ordersId, Model model, Orders orders) {
        Optional<Orders> orderSelect = itemsService.orderOne(ordersId);
        orderSelect.ifPresentOrElse(inside -> {
            model.addAttribute("orderDelete", inside);
        }, () -> {
            System.out.println("削除失敗");
        });
        return "/items/orderDelete";
    }
    @GetMapping("deletedEdit/{ordersId}")
//    @GetMapping("deletedEdit")
    public String deletedEdit(@ModelAttribute Orders orders) {
        itemsService.orderDelete(orders);
        return "items/deletedEdit";
    }



}
