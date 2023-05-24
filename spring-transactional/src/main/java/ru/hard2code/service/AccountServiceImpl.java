package ru.hard2code.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hard2code.model.Account;
import ru.hard2code.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public List<Account> findAllAccounts() {
        List<Account> result = new ArrayList<>();
        accountRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Account findAccountById(long id) {
        return accountRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Cannot find account with id " + id));
    }

    @Override
    public void updateAccountById(long id, BigDecimal amount) {
        var account = findAccountById(id);
        account.setAmount(amount);
        accountRepository.save(account);
    }

    @Transactional
    @Override
    public void transferMoney(long idSender, long idReceiver,
                              BigDecimal amount) {
        var sender = findAccountById(idSender);
        var receiver = findAccountById(idReceiver);
        var diff = sender.getAmount().doubleValue() -
                receiver.getAmount().doubleValue();

        if (diff <= sender.getAmount().doubleValue()) {
            throw new RuntimeException("Exceeded the allowed amount");
        }

        sender.setAmount(sender.getAmount().subtract(amount));
        receiver.setAmount(receiver.getAmount().add(amount));
        accountRepository.save(sender);
        accountRepository.save(receiver);
    }
}
