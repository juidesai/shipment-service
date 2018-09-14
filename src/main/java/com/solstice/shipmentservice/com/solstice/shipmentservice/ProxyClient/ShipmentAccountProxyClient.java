package com.solstice.shipmentservice.com.solstice.shipmentservice.ProxyClient;

import com.solstice.shipmentservice.com.solstice.shipmentservice.Domain.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "account-service")
public interface ShipmentAccountProxyClient {
    @RequestMapping(value = "/addresses/{addressId}")
    Address getShippingAddressDetailByAddressId(@PathVariable("addressId") long addressId);
}
