package com.neighbor.jooleuserservice.productsummary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSummaryRepository extends JpaRepository<ProductSummary,Integer> {
    ProductSummary findByModel(String model);
}
