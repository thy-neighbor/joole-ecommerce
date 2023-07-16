package com.neighbor.jooleuserservice.productDocumentation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.neighbor.jooleuserservice.productsummary.ProductSummary;

import javax.persistence.*;

@Entity
public class ProductDocumentation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pdocId;

    private String name;

    private String type;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="pid" , nullable = false)
    private ProductSummary ps;

    public ProductDocumentation(){}

    public ProductDocumentation(String name, String type, ProductSummary ps) {
        this.name = name;
        this.type = type;
        this.ps = ps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ProductSummary getPs() {
        return ps;
    }

    public void setPs(ProductSummary ps) {
        this.ps = ps;
    }
}
