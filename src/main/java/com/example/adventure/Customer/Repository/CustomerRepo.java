package com.example.adventure.Customer.Repository;

import com.example.adventure.Customer.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository <Customer, Long> {

}
