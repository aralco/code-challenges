package com.cochabamba.interview.nearsure.model;

//package com.codesignal.model;

import java.math.BigDecimal;

public class Account {

    private String id;
    private String firstName;
    private String lastName;
    private BigDecimal amount;
    private boolean isAcquired = false;

    public Account(String firstName, String lastName, BigDecimal amount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.amount = amount;
    }

    public Account(String id, String firstName, String lastName, BigDecimal amount) {
        this(firstName, lastName, amount);
        this.id = id;
    }

    public Account(String id, String firstName, String lastName, BigDecimal amount, boolean isAcquired) {
        this(id, firstName, lastName, amount);
        this.isAcquired = isAcquired;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isAcquired() {
        return isAcquired;
    }

    public void setAcquired(boolean acquired) {
        isAcquired = acquired;
    }
}

