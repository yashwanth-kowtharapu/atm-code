package com.example.atm.controller;

import com.example.atm.service.ATMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ATMController {

    @Autowired
    private ATMService atmService;

    @GetMapping("/atm")
    public String home() {
        return "atm"; // main menu page
    }

    @GetMapping("/deposit")
    public String depositPage() {
        return "deposit";
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam double amount, Model model) {
        String message = atmService.deposit(amount);
        model.addAttribute("message", message);
        model.addAttribute("balance", atmService.getBalance());
        return "result";
    }

    @GetMapping("/withdraw")
    public String withdrawPage() {
        return "withdraw";
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam double amount, Model model) {
        String message = atmService.withdraw(amount);
        model.addAttribute("message", message);
        model.addAttribute("balance", atmService.getBalance());
        return "result";
    }

    @GetMapping("/balance")
    public String checkBalance(Model model) {
        model.addAttribute("balance", atmService.getBalance());
        return "balance";
    }

    @GetMapping("/exit")
    public String exit() {
        return "exit";
    }
}
