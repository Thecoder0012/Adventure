package com.example.adventure.Customer.Service;


import com.example.adventure.Customer.Model.Customer;
import com.example.adventure.Customer.Repository.CustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
                new RuntimeException("%s %d not found!".formatted("com/example/adventure/Customer", id)));
    }

    public Optional<Customer> update(Long id, Customer customer, boolean partial){
        return customerRepo.findById(id).map(oldItem -> {
            return customerRepo.save(oldItem.updateFrom(customer, partial));});
    }

    public Customer delete(Long id){
        customerRepo.deleteById(id);
        return null;
    }
}
