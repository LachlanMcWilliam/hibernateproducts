package com.bandq.spring.Entities;


import javax.persistence.*;

@Entity
@Table(name="product",
        uniqueConstraints={@UniqueConstraint(columnNames={"Id"})})
public class Product {

    public Product() {
    }

    public Product(String name, int stock, int weight, int price){
        this.name = name;
        this.stock = stock;
        this.weight = weight;
        this.price = price;
    }

    public Product(String name, int stock, int weight, int price, String description){
        this.name = name;
        this.stock = stock;
        this.weight = weight;
        this.price = price;
        this.description = description;
    }

    public Product(int id, String name, int stock, int weight, int price, String description){
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.weight = weight;
        this.price = price;
        this.description = description;
    }

    @Column(name="Id", nullable = false, unique = true, length = 11)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "Product_Name", nullable = false, length = 36)
    private String name;

    @Column(name = "Stock", nullable = false)
    private int stock;

    @Column(name = "Weight", nullable = false)
    private int weight;

    @Column(name = "Price", nullable = false)
    private int price;

    @Column(name = "Description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Category_Id")
    private Category categories;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
