package sit.int204.classicmodelsservicedemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelsservicedemo.entities.Office;

public interface OfficeRepository extends JpaRepository<Office,String> {

}
