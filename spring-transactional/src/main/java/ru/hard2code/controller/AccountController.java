package ru.hard2code.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hard2code.dto.TransferRequest;
import ru.hard2code.model.Account;
import ru.hard2code.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;


    @PostMapping("/transfer")
    private void transferMoney(@RequestBody TransferRequest request) {
        accountService.transferMoney(request.getSenderAccountId(),
                request.getReceiverAccountId(), request.getAmount());
    }

    @GetMapping
    public List<Account> getAll() {
        return accountService.findAllAccounts();
    }

    @PutMapping("{id}")
    public void changeAmount(@PathVariable("id") long id,
                             @RequestBody Account account) {
        accountService.updateAccountById(id, account.getAmount());
    }
}
