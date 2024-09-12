package com.vipsfoodcourt.order.controller;

import com.vipsfoodcourt.order.DTO.OrderDTO;
import com.vipsfoodcourt.order.DTO.OrderDTOFromFE;
import com.vipsfoodcourt.order.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class OrderControllerTest {


    @InjectMocks
    private OrderController orderController;

    @Mock
    private OrderService mockOrderService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

    }


    @Test
    public void testSaveOrder() {

    // Arrange
        OrderDTOFromFE mockOrderDTOFromFE = new OrderDTOFromFE();
        OrderDTO mockOrderSavedInDB = new OrderDTO();
        when(mockOrderService.saveOrderInDB(mockOrderDTOFromFE)).thenReturn(mockOrderSavedInDB);


        // Act
        ResponseEntity<OrderDTO> response = orderController.saveOrder(mockOrderDTOFromFE);

        //Assert

        verify(mockOrderService,times(1)).saveOrderInDB(mockOrderDTOFromFE);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        assertEquals(response.getBody(),mockOrderSavedInDB);



    }


}
