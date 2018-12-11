package com.bandq.spring.Entities;

import javax.persistence.*;
import java.util.ArrayList;


@Entity
@Table(name="catagories",
        uniqueConstraints={@UniqueConstraint(columnNames={"Id"})})
public class Category {
    @Column(name = "Id", nullable = false, unique = true, length = 11)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, length = 36)
    private String _name;

    @OneToMany(mappedBy = "Catagories", cascade = CascadeType.ALL, orphanRemoval = true)
    //@JoinTable(name = "products", joinColumns = @JoinColumn(name = "Id"), inverseJoinColumns = @JoinColumn(name = "Id"))
    private ArrayList<Product> _products;

    //**Getters and Setters**\\

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public ArrayList<Product> get_products() {
        return _products;
    }

    public void set_products(ArrayList<Product> _products) {
        this._products = _products;
    }
}
