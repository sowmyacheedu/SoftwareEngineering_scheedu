package edu.iu.p565.customerservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import edu.iu.p565.customerservice.model.Customer;
import edu.iu.p565.customerservice.repository.CustomerRepository;
@RestController
@RequestMapping("/customers")

public class CustomerController {
    private CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }
    @GetMapping
    public List<Customer> findAll(){
        return repository.findAll();

    }
    @PostMapping
    public int create(@RequestBody Customer customer){
        return repository.create(customer);
    }

    @PutMapping("/{id}")
    public void update(Customer customer, @PathVariable int id) { repository.update(customer, id); }

    @ResponseStatus(HttpStatus.NO_CONTENT)

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        repository.delete(id);
    }

}

