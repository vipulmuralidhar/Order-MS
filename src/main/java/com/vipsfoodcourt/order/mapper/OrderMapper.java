package com.vipsfoodcourt.order.mapper;

import com.vipsfoodcourt.order.DTO.OrderDTO;
import com.vipsfoodcourt.order.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface OrderMapper {


    OrderMapper INSTANCE= Mappers.getMapper(OrderMapper.class);


    Order  mapOrderDTOToOrder (OrderDTO orderDTO);
    OrderDTO mapOrderToOrderDTO (Order order);




}
