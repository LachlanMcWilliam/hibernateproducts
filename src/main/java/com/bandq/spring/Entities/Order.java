package com.bandq.spring.Entities;

import javax.persistence.*;

@Entity
@Table(name="orders",
        uniqueConstraints={@UniqueConstraint(columnNames={"Id"})})
public class Order {
    @Column(name="Id", nullable = false, unique = true, length = 11)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "AddressId", nullable = false, length = 36)
    private int addressId;

    @Column(name = "PaymentId", nullable = false)
    private int paymentId;

    @Column(name = "CustomerId", nullable = false)
    private int customerId;

    @Column(name = "NumberOfProducts", nullable = false)
    private int numOfProducts;

    @Column(name = "HasBeenOrdered", nullable = false)
    private Boolean beenOrdered;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getNumOfProducts() {
        return numOfProducts;
    }

    public void setNumOfProducts(int numOfProducts) {
        this.numOfProducts = numOfProducts;
    }

    public Boolean getBeenOrdered() {
        return beenOrdered;
    }

    public void setBeenOrdered(Boolean beenOrdered) {
        this.beenOrdered = beenOrdered;
    }
}
