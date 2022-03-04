package esb.services;

import esb.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class NormalShippingService {

    @Autowired
    RestTemplate restTemplate;

    public void ship(Order order) {
        System.out.println("Normal Shipping");
        System.out.println("shipping: "+ order.toString());
        restTemplate.postForLocation("http://localhost:8081/orders", order);
    }

}
