package com.solstice.shipmentservice.com.solstice.shipmentservice.Controller;

import com.solstice.shipmentservice.com.solstice.shipmentservice.Domain.Shipment;
import com.solstice.shipmentservice.com.solstice.shipmentservice.Domain.ShipmentDetails;
import com.solstice.shipmentservice.com.solstice.shipmentservice.ProxyClient.ShipmentAccountProxyClient;
import com.solstice.shipmentservice.com.solstice.shipmentservice.Repository.ShipmentRepository;
import com.solstice.shipmentservice.com.solstice.shipmentservice.Service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class ShipmentController {

    private static final Logger logger = LoggerFactory.getLogger(ShipmentController.class);
    @Autowired
    ShipmentService shipmentService;

    @Autowired
    ShipmentRepository shipmentRepository;

    @GetMapping(value = "/shipments/accountId/{accountId}")
    public ShipmentDetails getShipmentDetailsByAccountId(@PathVariable(value = "accountId") long accountId)
    {
        logger.info("Successs");
        return shipmentService.getShipmentDetails(accountId);
    }

    @GetMapping(value = "/shipments/accountId/{accountId}/addressId")
    public long getShipmentAddressByAccountId(@PathVariable(value = "accountId") long accountId){
        logger.info("Successs");
        return shipmentRepository.findShipementAddressIdByAccountId(accountId);
    }
    @GetMapping(value = "/shipmentsDetails/{accountId}")
    public Shipment getShipmentByAccountId(@PathVariable(value = "accountId") long accountId){
        logger.info("Successs");
        return shipmentRepository.findShipementByAccountId(accountId);
    }

}
