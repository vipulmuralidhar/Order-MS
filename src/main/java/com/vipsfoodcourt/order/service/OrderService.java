package com.vipsfoodcourt.order.service;

import com.vipsfoodcourt.order.DTO.OrderDTO;
import com.vipsfoodcourt.order.DTO.OrderDTOFromFE;
import com.vipsfoodcourt.order.DTO.UserDTO;
import com.vipsfoodcourt.order.entity.Order;
import com.vipsfoodcourt.order.mapper.OrderMapper;
import com.vipsfoodcourt.order.repo.OrderRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Service
public class OrderService {

    OrderRepo orderRepo;

    SequenceGenerator sequenceGenerator;

    RestTemplate restTemplate;

    public OrderDTO saveOrderInDB(OrderDTOFromFE orderDTOFromFE) {


        Integer orderID = sequenceGenerator.generateNextOrderId();
        UserDTO userDeatils = getUserDetailsFromUserMS(orderDTOFromFE.getUserID());
        Order orderToBeSaved = new Order(orderID, orderDTOFromFE.getFoodItemsList(), userDeatils, orderDTOFromFE.getRestaurant());

        orderRepo.save(orderToBeSaved);

         // convert to orderDTO using mapper
        return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved);
    }



    private UserDTO getUserDetailsFromUserMS(Integer id) {

        //  return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchById/"+ restaurantId, Restaurant.class);
            //localhost:9093/user/fetchUserById/1   USER-SERVICE
        return restTemplate.getForObject("http://USER-SERVICE/user/fetchUserById/"+ id, UserDTO.class);
    }


}

