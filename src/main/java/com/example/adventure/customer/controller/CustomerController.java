package com.example.adventure.customer.controller;//


import com.example.adventure.customer.model.Customer;
import com.example.adventure.customer.service.CustomerService;
import com.example.adventure.dtotest.ActivityDto;
import com.example.adventure.dtotest.BookingDto;
import com.example.adventure.dtotest.CustomerDto;
import com.example.adventure.dtotest.DtoFactory;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService service;

    @GetMapping("/get")
    public ResponseEntity<List<CustomerDto>> findAll() {
        return ResponseEntity.ok().body(DtoFactory.fromCustomer(service.fetchAll()));
    }


    @PostMapping
    public ResponseEntity<Customer> create(@Valid @RequestBody Customer customer){
        service.add(customer);
        return ResponseEntity.ok().body(customer);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Customer> patch(@PathVariable("id") Long id,
                                          @Valid @RequestBody  Customer customer){
        return ResponseEntity.ok().body(service.update(id, customer, true).orElseThrow(()->
                new RuntimeException("Not found")));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(service.delete(id));
    }

}

