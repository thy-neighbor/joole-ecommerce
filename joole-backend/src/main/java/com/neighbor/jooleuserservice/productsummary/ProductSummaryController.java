package com.neighbor.jooleuserservice.productsummary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "false")
public class ProductSummaryController {

    @Autowired
    private ProductSummaryService psService;

    @GetMapping("/api/products")
    public List<ProductSummary> getAllPs(){
        return psService.getAllProductSummaries();
    }

    @GetMapping("/api/products/{id}")
    public List<ProductSummary> getOneProduct(@PathVariable Integer id){
        return psService.getAllProductSummaries();
    }

    @PostMapping("/api/products")
    public HttpStatus addProduct(@RequestBody ProductSummary ps){
        return psService.addProduct(ps) ? HttpStatus.CREATED :
                HttpStatus.BAD_REQUEST; //adds a product summ in database
    }

    @DeleteMapping("api/products/{id}")
    public void deleteProduct(@PathVariable Integer id){
        psService.deletePsById(id);
    }
}

/*To Do List
*
* 1. Foreign Keys
* 2. Sorting
* 3. Frontend
*
* - fix token expiration being returned
* */