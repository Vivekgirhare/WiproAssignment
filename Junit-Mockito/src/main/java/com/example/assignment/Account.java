package com.example.assignment;

public class Account {

    private String id;
    private double balance;

    public Account(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (balance >= amount)
            this.balance -= amount;
        else
            throw new IllegalArgumentException("Insufficient balance");
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}
