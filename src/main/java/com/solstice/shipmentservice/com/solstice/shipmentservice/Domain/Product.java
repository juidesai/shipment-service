package com.solstice.shipmentservice.com.solstice.shipmentservice.Domain;

import javax.persistence.*;

public class Product {
    private String productName;

    public Product(){}
    public Product(String productName) {
        this.productName = productName;

    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

}
