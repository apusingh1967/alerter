package com.rbccm.alerter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderControllerTest {

  @Autowired
  public OrderController orderController;

  @Test
  public void whenOrderGt10000ThenDiscount(){
    Order order = orderController.orderNow(new Order("HDFC", "HDFC", 0, 11000));
    System.out.println(order);
  }
}
