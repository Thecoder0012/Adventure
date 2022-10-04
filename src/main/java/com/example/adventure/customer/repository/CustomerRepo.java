package com.example.adventure.customer.repository;

import com.example.adventure.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository <Customer, Long> {

}
