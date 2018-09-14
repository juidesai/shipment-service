package com.solstice.shipmentservice.com.solstice.shipmentservice.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.solstice.shipmentservice.com.solstice.shipmentservice.Domain.OrderLineItems;
import com.solstice.shipmentservice.com.solstice.shipmentservice.Domain.Orders;
import com.solstice.shipmentservice.com.solstice.shipmentservice.Domain.Shipment;
import com.solstice.shipmentservice.com.solstice.shipmentservice.Domain.ShipmentDetails;
import com.solstice.shipmentservice.com.solstice.shipmentservice.ProxyClient.ShipmentAccountProxyClient;
import com.solstice.shipmentservice.com.solstice.shipmentservice.ProxyClient.ShipmentOrderProxyClient;
import com.solstice.shipmentservice.com.solstice.shipmentservice.ProxyClient.ShipmentProductProxyClient;
import com.solstice.shipmentservice.com.solstice.shipmentservice.Repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.Data;
import java.util.List;
import java.util.Optional;

@Service
public class ShipmentService {
    @Autowired
    private ShipmentRepository shipmentRepository;

    @Autowired
    ShipmentAccountProxyClient shipmentAccountProxyClient;

    @Autowired
    ShipmentOrderProxyClient shipmentOrderProxyClient;

    @Autowired
    ShipmentProductProxyClient shipmentProductProxyClient;

    private static final Logger logger = LoggerFactory.getLogger(ShipmentService.class);

    public ShipmentService(ShipmentRepository shipmentRepository) { this.shipmentRepository = shipmentRepository;
    }

    public List<Shipment> getAllShipment() {
        return shipmentRepository.findAll();
    }

    public void addNewShipment(Shipment shipment) {
        shipmentRepository.save(shipment);
    }

    @HystrixCommand(fallbackMethod = "getShipmentDetailsFallback")
    public ShipmentDetails getShipmentDetails(long accountId){
            ShipmentDetails shipmentDetails = new ShipmentDetails();
            Shipment shipment1 = shipmentRepository.findShipementByAccountId(accountId);//get shipment object
            shipmentDetails.setOrders(shipmentOrderProxyClient.findOrdersByAccountId(accountId));
            List<Orders> orders = shipmentOrderProxyClient.findOrdersByAccountId(accountId);
            for (Orders orderList : orders) {
                long orderNumber = orderList.getOrderNumber();
                List<OrderLineItems> orderLineItems = shipmentOrderProxyClient.findAllOrderLineItemByOrderId(orderNumber);
                for (OrderLineItems orderLineItems1 : orderLineItems) {
                    shipmentDetails.setProduct(shipmentProductProxyClient.findProductById(orderLineItems1.getProductId()));
                }
                shipmentDetails.setOrderLineItems(shipmentOrderProxyClient.findAllOrderLineItemByOrderId(orderNumber));
            }
            shipmentDetails.setShipmentId(shipment1.getShipmentId());
            shipmentDetails.setShipment_orderlineitem_id(shipment1.getShipment_orderlineitem_id());
            shipmentDetails.setDeliveryDate(shipment1.getDeliveryDate());
            shipmentDetails.setShippedDate(shipment1.getShippedDate());
//            shipmentDetails1.add(shipmentDetails);
//        shipmentDetails.setAddress(shipmentAccountProxyClient.getShippingAddressDetailByAddressId(new Long(shipment1.getShipment_address_id())));
        return shipmentDetails;
    }

    @SuppressWarnings("unused")
    public ShipmentDetails getShipmentDetailsFallback(long accountId){
        ShipmentDetails shipmentDetails=new ShipmentDetails();
        logger.error("other service is down");
        return shipmentDetails;
    }
}
