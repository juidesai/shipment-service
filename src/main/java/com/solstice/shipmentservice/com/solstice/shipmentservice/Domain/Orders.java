package com.solstice.shipmentservice.com.solstice.shipmentservice.Domain;

import java.time.LocalDateTime;
import java.util.List;
public class Orders {

    private long orderNumber;
    private LocalDateTime orderDate;
    public Orders(){}

    public Orders(long orderNumber, LocalDateTime orderDate){
        this.orderNumber=orderNumber;
        this.orderDate=orderDate;
    }

    public Orders(long orderNumber, LocalDateTime orderDate, long address_order_id, List<OrderLineItems> orderLineItemsList, long account_order_id) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
