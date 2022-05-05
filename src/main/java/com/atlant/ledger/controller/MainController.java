package com.atlant.ledger.controller;

import com.atlant.ledger.model.Account;
import com.atlant.ledger.model.AccountForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private static final List<Account> accountList = new ArrayList<>();

    static {
        accountList.add(new Account("Tinkoff", "4500"));
        accountList.add(new Account("Alfa", "8758.52"));
    }

    @GetMapping(value = {"/", "index"})
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/accountList")
    public String getAccounts(Model model) {
        model.addAttribute("accountList", accountList);
        return "accountList";
    }

    @GetMapping("/addAccount")
    public String getAccountForm(Model model) {
        model.addAttribute("accountForm", new AccountForm());
        return "addAccount";

    }

    @PostMapping("/addAccount")
    public String saveAccount(Account account,
                              @ModelAttribute("accountForm") AccountForm accountForm) {
//        String name = accountForm.getName();
//        String balance = accountForm.getBalance();
//
//        accountList.add(new Account(name, balance));
        accountList.add(account);

        return "redirect:/accountList";
    }
}
