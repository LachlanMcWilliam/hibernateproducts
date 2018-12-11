package com.bandq.spring.Entities;

import javax.persistence.*;

@Entity
@Table(name="payment details",
        uniqueConstraints={@UniqueConstraint(columnNames={"Id"})})
public class PaymentDetails {
    @Column(name="Id", nullable = false, unique = true, length = 11)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "CardNumber", nullable = false, length = 36)
    private int cardNumber;

    @Column(name = "ExpiryDate", nullable = false)
    private int expiryDate;

    @Column(name = "NameOnCard", nullable = false)
    private String NameOnCard;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(int expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getNameOnCard() {
        return NameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        NameOnCard = nameOnCard;
    }
}
