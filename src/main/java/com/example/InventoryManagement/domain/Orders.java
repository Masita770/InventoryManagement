package com.example.InventoryManagement.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Orders {
    private int ordersId;
    @NotNull(message = "入力してください")
    @Pattern(regexp = "", message = "入力された製品番号は正しくありません。 半角で入力してください。")
    private int itemsId;
    @NotNull
    @Size(max = 20)

    private int orderDate;
    private String deliveryDate;

    public Orders(int ordersId, int itemsId, int orderDate, String deliveryDate) {
        this.ordersId = ordersId;
        this.itemsId = itemsId;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
    }
}
