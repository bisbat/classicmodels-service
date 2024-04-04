package sit.int204.classicmodelsservicedemo.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import sit.int204.classicmodelsservicedemo.entities.Customer;
import sit.int204.classicmodelsservicedemo.repositories.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    //get all customers
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    //get customer by Id
    public Customer getCustomer(Integer customerId){
        return customerRepository.findById(customerId).orElseThrow(
                ()->new HttpClientErrorException(HttpStatus.NOT_FOUND,"Customer Id "+customerId+" does not EXIST!!!")
        );
    }

    //add new customer
    @Transactional
    public Customer createCustomer(Customer newCustomer){
        return customerRepository.save(newCustomer);
    }

    //Update a customers with id
    @Transactional
    public Customer updateCustomer(Integer customerId,Customer customer){
        Customer existingCustomer=customerRepository.findById(customerId).orElseThrow(
                ()->new HttpClientErrorException(HttpStatus.NOT_FOUND,"Customer Id "+customerId+" does not EXIST!!!")
        );


        return customerRepository.save(customer);
    }

    // Delete a customers with id
    public void removeCustomer(Integer customerId){
        Customer customer=customerRepository.findById(customerId).orElseThrow(
                ()->new HttpClientErrorException(HttpStatus.NOT_FOUND,"Customer Id "+customerId+" does not EXIST!!!")
        );
        customerRepository.delete(customer);
    }

    // Get all orders for customer id


}
