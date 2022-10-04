package com.example.adventure.customer.model;//

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    public Customer(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

/*    public Customer updateFrom(Customer customer, boolean partial){
        if(!partial || customer.firstName!=null) {this.firstName = customer.firstName;}
        if (!partial || customer.lastName!=null) {this.lastName = customer.lastName;}
        if (!partial || customer.email!=null) {this.email = customer.email;}
        if (!partial || customer.phoneNumber!=null) {this.phoneNumber = customer.phoneNumber;}
        return this;
    }*/

}
