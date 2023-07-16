package com.neighbor.jooleuserservice.productDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.neighbor.jooleuserservice.productsummary.ProductSummary;

import javax.persistence.*;

@Entity
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pdId;

    private String content;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="pid" , nullable = false)
    private ProductSummary ps;

    public ProductDetails() {

    }

    public ProductDetails(String content) {
        this.content=content;
    }

    public Integer getPdId() {
        return pdId;
    }

    public void setPdId(Integer pdId) {
        this.pdId = pdId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ProductSummary getPs() {
        return ps;
    }

    public void setPs(ProductSummary ps) {
        this.ps = ps;
    }
}

