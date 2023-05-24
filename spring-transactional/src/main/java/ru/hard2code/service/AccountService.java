package ru.hard2code.service;

import ru.hard2code.model.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {

    List<Account> findAllAccounts();

    Account findAccountById(long id);

    void updateAccountById(long id, BigDecimal amount);

    void transferMoney(long idSender, long idReceiver, BigDecimal amount);
}
