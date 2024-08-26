package com.vipsfoodcourt.order.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO {
    private Integer orderID;
    private List<FoodItemsDTO> foodItemsDTOList;
    private UserDTO userDTO;
    private Restaurant restaurant;
}
