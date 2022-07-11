package com.mpaiement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private Integer idOrder;

    private Integer sum;

    private Long cardNumber;


    @Override
    public String toString() {
        return "Payement{" +
                "id=" + id +
                ", idOrder=" + idOrder +
                ", sum=" + sum +
                ", cardNumber=" + cardNumber +
                '}';
    }
}
