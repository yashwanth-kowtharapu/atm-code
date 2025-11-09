package com.example.atm.service;

import org.springframework.stereotype.Service;

@Service
public class ATMService {
    private double balance = 0.0;

    public String deposit(double amount) {
        if (amount <= 0) {
            return "❌ Invalid deposit amount!";
        }
        balance += amount;
        return "✅ Successfully deposited ₹" + amount;
    }

    public String withdraw(double amount) {
        if (amount <= 0) {
            return "❌ Invalid withdrawal amount!";
        }
        if (amount > balance) {
            return "⚠️ Insufficient balance!";
        }
        balance -= amount;
        return "✅ Successfully withdrawn ₹" + amount;
    }

    public double getBalance() {
        return balance;
    }
}
