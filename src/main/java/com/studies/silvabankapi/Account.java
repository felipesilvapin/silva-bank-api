package com.studies.silvabankapi;

public class Account {
    private int agency;
    private int account;
    private double balance;
    private Customer holder;

    public double getAgency() {
        return agency;
    }

    public Customer getHolder() {
        return holder;
    }

    public void setHolder(Customer holder) {
        this.holder = holder;
    }

    public void setAgency(int agency) {
        this.agency = agency;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double balance) {
        if (balance >= this.balance) {
            this.balance -= balance;
            return true;
        }

        return false;
    }

    public void deposit(double balance) {
        this.balance += balance;
    }

    public boolean transfer(double balance) {
        if (balance >= this.balance) {
            this.balance -= balance;
            return true;
        }

        return false;
    }
}
