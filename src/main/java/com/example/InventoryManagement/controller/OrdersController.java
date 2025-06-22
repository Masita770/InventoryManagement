package com.example.InventoryManagement.controller;


import com.example.InventoryManagement.form.OrderRequestForm;
import com.example.InventoryManagement.service.ItemsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/items")
public class OrdersController {

    private ItemsService itemsService;

    @GetMapping("orderForm")
    public ModelAndView newOrder(@ModelAttribute OrderRequestForm orderRequestForm,
                                 ModelAndView mav) {
        mav.setViewName("items/orderForm");
        mav.addObject(orderRequestForm.getItemsId());
        mav.addObject(orderRequestForm.getOrderDate());
        return mav;
    }
}
