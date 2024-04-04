package sit.int204.classicmodelsservicedemo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelsservicedemo.dtos.CustomerDTO;
import sit.int204.classicmodelsservicedemo.entities.Customer;
import sit.int204.classicmodelsservicedemo.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;
    @Autowired
    private ModelMapper modelMapper;

    //get all customers
    @GetMapping("")
    public List<Customer> getAllCustomer(){
        return service.getAllCustomers();
    }
    //get customer by Id
//    @GetMapping("/{customerId}")
//    public Customer getCustomer(@PathVariable Integer customerId){
//        return service.getCustomer(customerId);
//    }
    @PostMapping("")
    public Customer createCustomer(@RequestBody Customer newCustomer){
        return service.createCustomer(newCustomer);
    }
    @PutMapping("{customerId}")
    public Customer updateCustomer(@PathVariable Integer customerId,@RequestBody Customer customer){
        return service.updateCustomer(customerId,customer);
    }
    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable Integer customerId){
        service.removeCustomer(customerId);
    }

    //Get customers by id and from using customerDTO
    @GetMapping("/{customerId}")
    public CustomerDTO getSimpleCustomerById(@PathVariable Integer customerId){
        return modelMapper.map(service.getCustomer(customerId),CustomerDTO.class);
    }

}
