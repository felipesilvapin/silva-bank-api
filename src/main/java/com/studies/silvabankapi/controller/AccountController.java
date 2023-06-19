package com.studies.silvabankapi.controller;

import com.studies.silvabankapi.entity.Account;
import com.studies.silvabankapi.entity.AccountRegistration;
import com.studies.silvabankapi.entity.ListAccounts;
import com.studies.silvabankapi.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("accounts")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;
    @PostMapping("open-account")
    public void openAccount(@RequestBody AccountRegistration data) {
        accountRepository.save(new Account(data));
    }
    @GetMapping
    public Page<ListAccounts> listAccounts(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
        Page<Account> accountPage = accountRepository.findAll(pagination);
        return accountPage.map(account -> new ListAccounts(account.getId(), account.getName(), account.getCpf(), account.getBirth(), account.getEmail(), account.getAddress()));
    }
}
