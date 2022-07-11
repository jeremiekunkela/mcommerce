package com.mcommandes.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    private int id;

    private Integer productId;

    private Date orderDate;

    private Integer amount;

    private Boolean orderPay;

    public Order() {
    }

    @Override
    public String toString() {
        return "commande{" +
                "id=" + id +
                ", productId=" + productId +
                ", orderDate=" + orderDate +
                ", amount=" + amount +
                ", orderPay=" + orderPay +
                '}';
    }
}
