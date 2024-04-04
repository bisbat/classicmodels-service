package sit.int204.classicmodelsservicedemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelsservicedemo.entities.Product;
import sit.int204.classicmodelsservicedemo.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService service;
//    @GetMapping("")
//    public List<Product> getAllProducts(){
//        return service.getAllProduct();
//    }
//    @GetMapping("")
//    public List<Product>getProductByPriceAndName(
//            @RequestParam(defaultValue = "0") Double min,
//            @RequestParam(defaultValue = "0") Double max,
//            @RequestParam(defaultValue = "") String name
//    ){
//    return service.getProductByPriceAndName(min,max,name);
//    }

    //get product with pageable
//    @GetMapping("")
//    public Page<Product> getProductByNameContain(
//            @RequestParam(defaultValue = "") String name,
//            @RequestParam(defaultValue = "0") int pageNo,
//            @RequestParam(defaultValue = "5") int pageSize
//    ){
//        return service.getProductByNameWithPage(name,pageNo,pageSize);
//    }

    //Get all products filter by price between and product name contains sorting as request specify
    @GetMapping("")
    public ResponseEntity<Page<Product>> getProductByPriceAndNameSort(
            @RequestParam(defaultValue = "0") Double min,
            @RequestParam(defaultValue = "0") Double max,
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(defaultValue = "") String[] sortBy,
            @RequestParam(defaultValue = "asc") String[] direction
    ){
        return ResponseEntity.ok(service.getProductByPriceAndNameAndSort(min,max,name,pageNo,pageSize,sortBy,direction));
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable String productId){
        return service.getProductById(productId);
    }

    @PostMapping("")
    public Product addNewProduct(@RequestBody Product newProduct){
        return service.addNewProduct(newProduct);
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable String productId,@RequestBody Product updatedProduct){
        return service.updateProduct(productId,updatedProduct);
    }

}



