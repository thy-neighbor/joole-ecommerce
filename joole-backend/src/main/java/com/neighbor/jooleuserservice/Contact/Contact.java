package com.neighbor.jooleuserservice.Contact;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.neighbor.jooleuserservice.productsummary.ProductSummary;

import javax.persistence.*;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contact_Id;

    private String title;

    private String name;

    private String department;

    private String phone;

    private String email;

    private String web;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="pid" , nullable = false)
    private ProductSummary ps;

    public Contact() {
    }

    public Contact(String title, String name, String department, String phone, String email, String web, ProductSummary ps) {
        this.title = title;
        this.name = name;
        this.department = department;
        this.phone = phone;
        this.email = email;
        this.web = web;
        this.ps = ps;
    }

    public Integer getContact_Id() {
        return contact_Id;
    }

    public void setContact_Id(Integer contact_Id) {
        this.contact_Id = contact_Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public ProductSummary getPs() {
        return ps;
    }

    public void setPs(ProductSummary ps) {
        this.ps = ps;
    }
}
