package sit.int204.classicmodelsservicedemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelsservicedemo.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
