package com.rbccm.alerter;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {

  @Autowired
  private KieSession session;

  public Order orderNow(Order order){
    session.insert(order);
    session.fireAllRules();
    return order;
  }
}
