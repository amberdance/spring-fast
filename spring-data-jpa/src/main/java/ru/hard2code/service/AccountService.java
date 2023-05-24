package ru.hard2code.service;

import ru.hard2code.model.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {

    void transferMoney(long senderId, long receiverId, BigDecimal amount);

    Account findById(long id);

    List<Account> findAll();

    void save(Account account);
}
