package com.solstice.shipmentservice.com.solstice.shipmentservice.Domain;

import javax.persistence.*;

public class OrderLineItems {
    private long orderItemsId;
    private int quantity;
    private double price;
    private double totalPrice;
    private Long productId;

    public OrderLineItems(){}
    public OrderLineItems(long orderItemsId, int quantity, double price, double totalPrice, Long productId) {
        this.orderItemsId = orderItemsId;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = this.getTotalPrice();
        this.productId=productId;
    }

    public long getOrderItemsId() {
        return orderItemsId;
    }

    public void setOrderItemsId(long orderItemsId) {
        this.orderItemsId = orderItemsId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return price*quantity;
    }

    public void setTotalPrice(OrderLineItems orderLineItems) {
        this.totalPrice = orderLineItems.getTotalPrice();
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }



    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
