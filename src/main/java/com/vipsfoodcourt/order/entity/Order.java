package com.vipsfoodcourt.order.entity;

import com.vipsfoodcourt.order.DTO.FoodItemsDTO;
import com.vipsfoodcourt.order.DTO.Restaurant;
import com.vipsfoodcourt.order.DTO.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "order")
public class Order {

    private Integer orderID;
    private List<FoodItemsDTO> foodItemsDTOList;
    private UserDTO userDTO;
    private Restaurant restaurant;
}
