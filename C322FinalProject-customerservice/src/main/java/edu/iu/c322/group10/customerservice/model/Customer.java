package edu.iu.c322.group10.customerservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

import java.util.Objects;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @NotEmpty
    private String name;

    private String email;

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return getCustomerId() == customer.getCustomerId() && getName().equals(customer.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerId(), getName());
    }
}
