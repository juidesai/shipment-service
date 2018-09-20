# shipment-service
This is the microservice created using Spring boot and deployed on PCF using Jenkins pipeline. 
Below are the endpoints which are implemented here. Here Data-Rest Api is also used which provides many 
default endpoints but below are the endpoints which it doesn't provide.

1)Get Shipment details by accountId
Url: Get: /shipments/accountId/{accountId}
Body: 
{
    "shipmentId": 9,
    "shipment_orderlineitem_id": 32,
    "shippedDate": "2018-07-10T00:00:00.000+0000",
    "deliveryDate": "2018-07-11T00:00:00.000+0000",
    "orders": [
        {
            "orderNumber": 31,
            "orderDate": "2018-06-30T20:00:00"
        }
    ],
    "orderLineItems": [
        {
            "orderItemsId": 32,
            "quantity": 2,
            "price": 10,
            "totalPrice": 20,
            "productId": 5
        }
    ],
    "product": {
        "productName": "Apple"
    }
}
