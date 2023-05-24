package ru.hard2code.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hard2code.dto.TransferMoneyRequest;
import ru.hard2code.model.Account;
import ru.hard2code.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public List<Account> getAll() {
        return accountService.findAll();
    }

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferMoneyRequest request) {
        accountService.transferMoney(request.getSenderId(),
                request.getReceiverId(), request.getAmount());
    }
}
