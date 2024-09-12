package com.vipsfoodcourt.order.controller;


import com.vipsfoodcourt.order.DTO.OrderDTO;
import com.vipsfoodcourt.order.DTO.OrderDTOFromFE;
import com.vipsfoodcourt.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/order")
public class OrderController {


    OrderService orderService;


    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromFE orderDTOFromFE){

        return  new ResponseEntity<>(orderService.saveOrderInDB(orderDTOFromFE),HttpStatus.CREATED);
    }


}
