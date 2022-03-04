package esb.router;

import esb.Order;

public class OrderTypeRouter {

    public String route(Order order) {
        String destinationChannel = null;
        if (order.getOrderType().equals(esb.OrderType.DOMESTIC))
            destinationChannel = "domesticShipping";
        else
            destinationChannel = "internationalShipping";
        return destinationChannel;
    }
}
