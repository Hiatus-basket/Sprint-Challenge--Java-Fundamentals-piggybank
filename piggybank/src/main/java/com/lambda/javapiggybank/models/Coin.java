package com.lambda.javapiggybank.models;

import javax.persistence.*;

@Entity
@Table(name="coins")
public class Coin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long coinid;
    String name;
    String namepural;
    double value;
    long quantity;

    public Coin(String name, String namepural, double value, long quantity) {
        this.name = name;
        this.namepural = namepural;
        this.value = value;
        this.quantity = quantity;
    }

    public Coin() {
    }

    public long getCoinid() {
        return coinid;
    }

    public void setCoinid(long coinid) {
        this.coinid = coinid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamepural() {
        return namepural;
    }

    public void setNamepural(String namepural) {
        this.namepural = namepural;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        if(quantity == 1){
            return quantity + " " + name;
        } else {
            return quantity + " " + namepural;
        }
    }
}
