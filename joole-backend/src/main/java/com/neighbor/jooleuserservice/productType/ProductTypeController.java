package com.neighbor.jooleuserservice.productType;

import com.neighbor.jooleuserservice.productsummary.ProductSummary;
import com.neighbor.jooleuserservice.productsummary.ProductSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "false")
public class ProductTypeController {
    @Autowired
    private ProductTypeService ptService;

    @GetMapping("/api/product-types")
    public List<ProductType> getAllPs(){
        return ptService.getAllProductTypes();
    }

    @PostMapping("/api/product-type")
    public HttpStatus addProductType(@RequestBody ProductType pt){
        return ptService.addProductType(pt) ? HttpStatus.CREATED :
                HttpStatus.BAD_REQUEST; //adds a product type in database
    }

    @DeleteMapping("api/product-type/{id}")
    public void deleteProduct(@PathVariable Integer id){
        ptService.deletePtById(id);
    }
}
