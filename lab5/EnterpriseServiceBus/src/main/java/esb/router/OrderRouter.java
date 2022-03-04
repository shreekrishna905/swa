package esb.router;

import esb.Order;

public class OrderRouter {

    public String route(Order order) {
        String destinationChannel = null;
        if (order.getAmount() > 175)
            destinationChannel = "fastShippingChannel";
        else
            destinationChannel = "normalShippingChannel";
        return destinationChannel;
    }

}
