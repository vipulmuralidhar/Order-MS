package com.vipsfoodcourt.order.service;

import com.vipsfoodcourt.order.DTO.OrderDTO;
import com.vipsfoodcourt.order.DTO.OrderDTOFromFE;
import com.vipsfoodcourt.order.DTO.UserDTO;
import com.vipsfoodcourt.order.entity.Order;
import com.vipsfoodcourt.order.mapper.OrderMapper;
import com.vipsfoodcourt.order.repo.OrderRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class OrderServiceTest {


    @InjectMocks
    OrderService orderService;

    @Mock
    OrderRepo mockOrderRepo;

    @Mock
    RestTemplate mockRestTemplate;

    @Mock
    SequenceGenerator mockSequenceGenerator;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testSaveOrderInDB(){

        //Arrange
        OrderDTOFromFE mockOrderDTOFromFE = new OrderDTOFromFE();
        Integer mockOrderID = 123;
        UserDTO mockUserDTO = new UserDTO();
        Order mockOrderToBeSaved = new Order(mockOrderID,mockOrderDTOFromFE.getFoodItemsList(),mockUserDTO,mockOrderDTOFromFE.getRestaurant());
        OrderDTO mockOrderDTOExpected = OrderMapper.INSTANCE.mapOrderToOrderDTO(mockOrderToBeSaved);

        when(mockOrderRepo.save(mockOrderToBeSaved)).thenReturn(mockOrderToBeSaved);
        when(mockSequenceGenerator.generateNextOrderId()).thenReturn(mockOrderID);
        when(mockRestTemplate.getForObject(anyString(),eq(UserDTO.class))).thenReturn(mockUserDTO);

        //Act
        OrderDTO result = orderService.saveOrderInDB(mockOrderDTOFromFE);

        //Assert
        verify(mockOrderRepo,times(1)).save(mockOrderToBeSaved);
        verify(mockRestTemplate,times(1)).getForObject(anyString(),eq(UserDTO.class));
        verify(mockSequenceGenerator,times(1)).generateNextOrderId();

        assertDoesNotThrow(()-> orderService.saveOrderInDB(mockOrderDTOFromFE));








    }





}
