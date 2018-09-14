package com.solstice.shipmentservice.com.solstice.shipmentservice.ProxyClient;

import com.solstice.shipmentservice.com.solstice.shipmentservice.Domain.Orders;
import com.solstice.shipmentservice.com.solstice.shipmentservice.Domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "product-service")
public interface ShipmentProductProxyClient {
    @RequestMapping(value = "/products/{productId}")
    Product findProductById(@PathVariable(value = "productId") long productId);
}
