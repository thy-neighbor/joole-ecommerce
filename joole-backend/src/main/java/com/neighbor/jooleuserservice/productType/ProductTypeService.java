package com.neighbor.jooleuserservice.productType;

import com.neighbor.jooleuserservice.productsummary.ProductSummary;
import com.neighbor.jooleuserservice.productsummary.ProductSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductTypeService {
    @Autowired
    private ProductTypeRepository ptRepo;

    @Transactional
    public List<ProductType> getAllProductTypes() {
        List<ProductType> pt = new ArrayList<>();
        ptRepo.findAll().forEach(pt::add);
        return pt;
    }

    @Transactional
    public void deletePtById(Integer id) {
        ptRepo.deleteById(id);
    }

    @Transactional
    public boolean addProductType(ProductType pt) {
        return ptRepo.save(pt)!= null;
    }

    @PostConstruct
    private void setupDefaultPt() {
        if (ptRepo.count() == 0) {//if nothing in database create

            ptRepo.save(new ProductType("Mechanical", null));
            ptRepo.save(new ProductType("Electronic", null));
            ptRepo.save(new ProductType("HVAC Fans", "Mechanical"));
        }
    }
}
