package sit.int204.classicmodelsservicedemo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelsservicedemo.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,String> {
    public List<Product> findByBuyPriceBetweenAndAndProductNameContains(Double min,Double max,String name);
    Page<Product> findByProductNameContains(String name, Pageable pageable);
    Page<Product>findByBuyPriceBetweenAndProductNameContains(Double min,Double max,String name,Pageable pageable);
}
