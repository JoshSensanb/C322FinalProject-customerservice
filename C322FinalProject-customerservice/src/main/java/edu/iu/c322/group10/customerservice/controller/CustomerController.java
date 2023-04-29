package edu.iu.c322.group10.customerservice.controller;

import edu.iu.c322.group10.customerservice.model.Customer;
import edu.iu.c322.group10.customerservice.repository.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public int create(@RequestBody Customer customer) {
        Customer c =customerRepository.save(customer);
        return c.getCustomerId();

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/update/{id}")
    public void update(@Valid @RequestBody Customer customer, @PathVariable int id){
        customer.setCustomerId(id);
        customerRepository.save(customer);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        Customer customer = new Customer();
        customer.setCustomerId(id);
        customerRepository.delete(customer);
    }

}
