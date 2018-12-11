package com.bandq.spring.Entities;

import javax.persistence.*;

@Entity
@Table(name="address",
        uniqueConstraints={@UniqueConstraint(columnNames={"Id"})})
public class Address {

    @Column(name="Id", nullable = false, unique = true, length = 11)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "Street", nullable = false, length = 36)
    private String streetName;

    @Column(name = "Town", nullable = false)
    private String townName;

    @Column(name = "Postcode", nullable = false)
    private String postcode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
