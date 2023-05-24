package ru.hard2code.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hard2code.exception.AccountNotFoundException;
import ru.hard2code.exception.AmountExceedException;
import ru.hard2code.model.Account;
import ru.hard2code.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    @Transactional
    public void transferMoney(long senderId, long receiverId,
                              BigDecimal amount) {

        var sender = findById(senderId);

        if (isAmountExceedAccountBalance(sender.getAmount().doubleValue(),
                amount.doubleValue())) {
            throw new AmountExceedException();
        }

        var receiver = findById(receiverId);

        sender.setAmount(sender.getAmount().subtract(amount));
        receiver.setAmount(receiver.getAmount().add(amount));

        accountRepository.save(sender);
        accountRepository.save(receiver);
    }

    @Override
    public Account findById(long id) {
        return accountRepository.findById(id)
                .orElseThrow(AccountNotFoundException::new);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    private boolean isAmountExceedAccountBalance(double amount,
                                                 double requestedAmount) {
        return amount < requestedAmount;
    }


}
