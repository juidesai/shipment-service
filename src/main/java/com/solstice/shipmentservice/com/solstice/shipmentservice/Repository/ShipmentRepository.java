package com.solstice.shipmentservice.com.solstice.shipmentservice.Repository;

import com.solstice.shipmentservice.com.solstice.shipmentservice.Domain.Shipment;
import com.solstice.shipmentservice.com.solstice.shipmentservice.Domain.ShipmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
    @Query(value = "select * " +
            "from shipment o " +
            "where o.shipment_account_id = ?1 ", nativeQuery = true)
    Shipment findShipementByAccountId(@Param("shipment_account_id") long accountId);

    @Query(value = "select shipment_address_id " +
            "from shipment o " +
            "where o.shipment_account_id = ?1 ", nativeQuery = true)
    long findShipementAddressIdByAccountId(@Param("shipment_account_id") long accountId);
}