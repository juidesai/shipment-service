package com.solstice.shipmentservice.com.solstice.shipmentservice.Domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name="Shipment")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long shipmentId;

    @Column(name = "shipment_account_id")
    private long shipment_account_id;

    @Column(name = "shipment_address_id")
    private long shipment_address_id;

    @Column(name = "shipment_orderlineitem_id")
    private long shipment_orderlineitem_id;

    private Date shippedDate;
    private Date deliveryDate;


    public Shipment(){}

    public Shipment(long shipmentId, long shipment_account_id, long shipment_address_id, long shipment_orderlineitem_id, Date shippedDate, Date deliveryDate) {
        this.shipmentId = shipmentId;
        this.shipment_account_id = shipment_account_id;
        this.shipment_address_id = shipment_address_id;
        this.shipment_orderlineitem_id = shipment_orderlineitem_id;
        this.shippedDate = shippedDate;
        this.deliveryDate = deliveryDate;
    }

    public long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(long shipmentId) {
        this.shipmentId = shipmentId;
    }

    public long getShipment_account_id() {
        return shipment_account_id;
    }

    public void setShipment_account_id(long shipment_account_id) {
        this.shipment_account_id = shipment_account_id;
    }

    public long getShipment_address_id() {
        return shipment_address_id;
    }
    public void setShipment_address_id(long shipment_address_id) {
        this.shipment_address_id = shipment_address_id;
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
