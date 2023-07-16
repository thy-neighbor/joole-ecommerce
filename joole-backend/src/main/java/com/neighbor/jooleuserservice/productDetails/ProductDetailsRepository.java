package com.neighbor.jooleuserservice.productDetails;

import com.neighbor.jooleuserservice.productsummary.ProductSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails , Integer> {
    //find by pid could go in here
}
