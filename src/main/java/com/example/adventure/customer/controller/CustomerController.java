package com.example.adventure.customer.controller;//


import com.example.adventure.customer.model.Customer;
import com.example.adventure.customer.service.CustomerService;
import com.example.adventure.dtotest.CustomerDto;
import com.example.adventure.dtotest.DtoFactory;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService service;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> findAll() {
        List<Customer> customers = service.fetchAll();
        if (customers != null) {
            return ResponseEntity.ok().body(DtoFactory.fromCustomer(customers));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getActivityById(@PathVariable Long id) {
        return ResponseEntity.ok().body(DtoFactory.fromCustomer(service.getCustomerById(id)));
    }


    @PostMapping
    public ResponseEntity<Customer> create(@Valid @RequestBody Customer customer) {
        service.add(customer);
        return ResponseEntity.ok().body(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> put(@PathVariable("id") Long id, @Valid @RequestBody CustomerDto dto) {
        return ResponseEntity.ok().body(update(id, dto));
    }

    private CustomerDto update(Long id, CustomerDto dto) {
        Optional<Customer> item = service.update(id, DtoFactory.fromCustomerDto(dto));
        return DtoFactory.fromCustomer(item.get());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Customer> patch(@PathVariable("id") Long id,
                                          @Valid @RequestBody Customer customer) {
        return ResponseEntity.ok().body(service.update(id, customer).orElseThrow(() ->
                new RuntimeException("Not found")));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> delete(@PathVariable("id") Long id) {
        if (id != null) {
            return ResponseEntity.ok().body(service.delete(id));
        }
        return ResponseEntity.badRequest().build();
    }

}

