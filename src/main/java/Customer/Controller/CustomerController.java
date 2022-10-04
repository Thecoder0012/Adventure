package Customer.Controller;


import Customer.Model.Customer;
import Customer.Service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService service;

    @GetMapping
    public ResponseEntity<List<Customer>>fetchAll(){
        List<Customer> list = service.fetchAll();

        return new ResponseEntity<List<Customer>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> create(Customer customer){
        service.add(customer);
        return ResponseEntity.ok().body(customer);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Customer> patch(@PathVariable("id") Long id, Customer customer){
        return ResponseEntity.ok().body(customer.updateFrom(customer, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> delete(@PathVariable("id") Long id){
        Customer delete = service.findById(id);
        return ResponseEntity.ok().body(delete);
    }


}

