package sit.int204.classicmodelsservicedemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelsservicedemo.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
