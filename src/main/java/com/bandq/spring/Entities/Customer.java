package com.bandq.spring.Entities;

import javax.persistence.*;

@Entity
@Table(name="customers",
        uniqueConstraints={@UniqueConstraint(columnNames={"Id"})})
public class Customer {

    @Column(name="Id", nullable = false, unique = true, length = 11)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "AddressId", nullable = false, length = 36)
    private int addressId;

    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @Column(name = "Surname", nullable = false)
    private String surname;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "Password", nullable = false)
    private String password;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
