package com.rbccm.alerter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

  @Autowired
  private OrderController orderController;

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("********** STARTED ************");
    Order order = orderController.orderNow(new Order("HDFC", "HDFC", 0, 11000));
    System.out.println(order);
  }
}
