package com.shipment.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shipment.main.entity.Buyer;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long>{

}
