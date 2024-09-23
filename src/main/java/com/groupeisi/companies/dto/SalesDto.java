package com.groupeisi.companies.dto;

import java.util.Date;

public class SalesDto {
    
    private long id;
    private Date dateP;
    private double quantity;
    private ProductDto product;
    
    public SalesDto() {
        this.dateP = new Date();
    }

    public SalesDto(long id, Date dateP, double quantity, ProductDto product) {
        this.id = id;
        this.dateP = dateP;
        this.quantity = quantity;
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateP() {
        return dateP;
    }

    public void setDateP(Date dateP) {
        this.dateP = dateP;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }
}
