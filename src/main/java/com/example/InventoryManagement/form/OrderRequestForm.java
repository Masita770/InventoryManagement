package com.example.InventoryManagement.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class OrderRequestForm {

    @NotNull
    private int ordersId;

    @NotNull
    private int itemsId;
    @Pattern(regexp = "^[0-9]*$")
    @NotNull
    private int orderDate;
    private String deliveryDate;
}
