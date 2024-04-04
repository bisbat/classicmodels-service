package sit.int204.classicmodelsservicedemo.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import sit.int204.classicmodelsservicedemo.entities.Product;
import sit.int204.classicmodelsservicedemo.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    //get all products
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    //Get all products filter by price between and product name contains
    public List<Product> getProductByPriceAndName(double min,double max, String name){
        return productRepository.findByBuyPriceBetweenAndAndProductNameContains(min,max,name);
    }
    //Get product by product id
    public Product getProductById(String productId){
        return productRepository.findById(productId).orElseThrow(
                ()->new HttpClientErrorException(HttpStatus.NOT_FOUND,"Product Id "+productId+" does not EXIST!!!")
        );
    }
    // Add new product
    @Transactional
    public Product addNewProduct(Product newProduct){
        return productRepository.save(newProduct);
    }
    //Update product
    @Transactional
    public Product updateProduct(String productId,Product updatedProduct){
        Product existingProduct=productRepository.findById(productId).orElseThrow(
                ()->new HttpClientErrorException(HttpStatus.NOT_FOUND,"Product Id "+productId+" does not EXIST!!!")
        );
        return productRepository.save(updatedProduct);
    }

    //get product with name contain and pageable
    public Page<Product> getProductByNameWithPage(String name,int pageNo,int pageSize){
        Pageable pageable= PageRequest.of(pageNo,pageSize);
        return productRepository.findByProductNameContains(name,pageable);
    }

    //Get all products filter by price between and product name contains sorting as request specify
    public Page<Product> getProductByPriceAndNameAndSort(double min,double max, String name,int pageNo,int pageSize,String[] sortBy,String[] direction){
        List<Sort.Order>sortOrder=new ArrayList<>();
        if(sortBy!=null&&sortBy.length>0){
            for (int i=0;i< sortBy.length;i++){
                sortOrder.add(new Sort.Order((direction[i].equalsIgnoreCase("asc")?
                        Sort.Direction.ASC:Sort.Direction.DESC),sortBy[i]));
            }
        }

        Pageable pageable1=PageRequest.of(pageNo,pageSize, Sort.by(sortBy));
        return productRepository.findByBuyPriceBetweenAndProductNameContains(min,max,name,pageable1);
    }
}
