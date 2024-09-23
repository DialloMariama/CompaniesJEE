package com.groupeisi.companies.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class ProductEntity implements Serializable {
    
    @Id
    @Column(name = "ref", length = 200, nullable = false, unique = true)
    private String ref;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "stock", nullable = false)
    private double stock;

    @OneToMany(mappedBy = "product")
    private List<Purchases> purchases;

    @OneToMany(mappedBy = "product")
    private List<Sales> sales;
    
    public ProductEntity() {}

    public ProductEntity(String ref, String name, double stock) {
        this.ref = ref;
        this.name = name;
        this.stock = stock;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public List<Purchases> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchases> purchases) {
        this.purchases = purchases;
    }

    public List<Sales> getSales() {
        return sales;
    }

    public void setSales(List<Sales> sales) {
        this.sales = sales;
    }
}
