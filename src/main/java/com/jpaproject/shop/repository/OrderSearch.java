package com.jpaproject.shop.repository;

import com.jpaproject.shop.domain.enums.OrderStatus;
import lombok.Getter;

@Getter
public class OrderSearch {
    private String userName; //회원 이름
    private OrderStatus orderStatus;  //주문 상태[ORDER, CANCEL]
}
