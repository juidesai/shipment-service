package com.solstice.shipmentservice.com.solstice.shipmentservice.Domain;
import java.util.Date;
import java.util.List;

public class ShipmentDetails {

        private long shipmentId;
        private long shipment_orderlineitem_id;
        private Date shippedDate;
        private Date deliveryDate;
        private List<Orders> orders;
        private List<OrderLineItems> orderLineItems;
        private Product product;
    public ShipmentDetails() {
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public List<OrderLineItems> getOrderLineItems() {
        return orderLineItems;
    }

    public void setOrderLineItems(List<OrderLineItems> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }

    public ShipmentDetails(long shipmentId, long shipment_account_id, long shipment_address_id, long shipment_orderlineitem_id, Date shippedDate, Date deliveryDate, Address address, Account account, Shipment shipment) {
            this.shipmentId = shipmentId;
            this.shipment_orderlineitem_id = shipment_orderlineitem_id;
            this.shippedDate = shippedDate;
            this.deliveryDate = deliveryDate;
        }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getShipmentId() {
            return shipmentId;
        }

        public void setShipmentId(long shipmentId) {
            this.shipmentId = shipmentId;
        }
        public long getShipment_orderlineitem_id() {
            return shipment_orderlineitem_id;
        }

        public void setShipment_orderlineitem_id(long shipment_orderlineitem_id) {
            this.shipment_orderlineitem_id = shipment_orderlineitem_id;
        }
        public Date getShippedDate() {
            return shippedDate;
        }

        public void setShippedDate(Date shippedDate) {
            this.shippedDate = shippedDate;
        }

        public Date getDeliveryDate() {
            return deliveryDate;
        }

    public void setDeliveryDate(Date deliveryDate) {
            this.deliveryDate = deliveryDate;

        }

    }

