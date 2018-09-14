package com.solstice.shipmentservice.com.solstice.shipmentservice.ProxyClient;

import com.solstice.shipmentservice.com.solstice.shipmentservice.Domain.OrderLineItems;
import com.solstice.shipmentservice.com.solstice.shipmentservice.Domain.Orders;
import org.hibernate.criterion.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "order-service")
public interface ShipmentOrderProxyClient {

    @RequestMapping(value = "/orders/accountId/{accountId}")
    List<Orders> findOrdersByAccountId(@PathVariable(value = "accountId") long accountId);

    @RequestMapping(value = "/orders/{orderId}/orderLineItems")
    List<OrderLineItems> findAllOrderLineItemByOrderId(@PathVariable(value = "orderId") long orderId);
}
