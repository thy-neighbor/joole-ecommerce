package com.neighbor.jooleuserservice.productType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productTypeId;

    private String type;
    private String parentType;
    //if there are no more mechanical types delete all mechanical types


    public ProductType() {
    }

    public ProductType(String type, String parentType) {
        this.type = type;
        this.parentType = parentType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParentType() {
        return parentType;
    }

    public void setParentType(String parentType) {
        this.parentType = parentType;
    }
}
