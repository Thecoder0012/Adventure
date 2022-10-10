package com.example.adventure.customer.service;//


import com.example.adventure.booking.model.Booking;
import com.example.adventure.customer.model.Customer;
import com.example.adventure.customer.repository.CustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepo customerRepo;

    public Customer add(Customer customer){
        return customerRepo.save(customer);
    }



    public ArrayList<Customer> fetchAll(){
        return (ArrayList<Customer>) customerRepo.findAll();
    }

    public Customer findById(Long id){
        return customerRepo.findById(id).orElseThrow(()->
                new RuntimeException("%s %d not found!".formatted("com/example/adventure/customer", id)));
    }

    public Customer getCustomerById(Long id){
        return customerRepo.findById(id).orElse(null);
    }

    public Optional<Customer> update(Long id, Customer customer){
        return customerRepo.findById(id).map(oldItem -> {
            return customerRepo.save(customer);});
    }

    public Customer delete(Long id){
        customerRepo.deleteById(id);
        return null;
    }
}
