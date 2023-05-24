package ru.hard2code.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.hard2code.exception.AccountNotFoundException;
import ru.hard2code.exception.AmountExceedException;
import ru.hard2code.model.Account;
import ru.hard2code.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountServiceImpl accountService;

    private Account sender;
    private Account receiver;

    @BeforeEach
    void setup() {
        sender = new Account(1L, "Sender", BigDecimal.valueOf(2000));
        receiver = new Account(2L, "Receiver", BigDecimal.valueOf(1000));
    }

    @Test
    void givenExistingId_whenFindById_thenAccountReturned() {
        when(accountRepository.findById(sender.getId())).thenReturn(
                Optional.of(sender));
        assertEquals(sender, accountService.findById(sender.getId()));
    }

    @Test
    void givenWrongId_whenFindById_thenNotFoundExceptionReturned() {
        when(accountRepository.findById(sender.getId())).thenReturn(
                Optional.empty());
        assertThrows(AccountNotFoundException.class,
                () -> accountService.findById(sender.getId()));
    }

    @Test
    void findAllSuccessFlow() {
        var accounts = List.of(sender, receiver);
        when(accountRepository.findAll()).thenReturn(accounts);
        assertIterableEquals(accounts, accountService.findAll());
    }

    @Test
    void transferMoneySuccessFlow() {
        when(accountRepository.findById(sender.getId())).thenReturn(
                Optional.of(sender));
        when(accountRepository.findById(receiver.getId())).thenReturn(
                Optional.of(receiver));

        var diff = BigDecimal.valueOf(1000);

        accountService.transferMoney(sender.getId(), receiver.getId(), diff);

        assertEquals(diff, sender.getAmount());
        assertEquals(diff, receiver.getAmount().subtract(diff));
    }

    @Test
    void givenExceedOfBalanceAmount_whenTransferMoney_thenExceptionReturned() {
        sender.setAmount(BigDecimal.valueOf(0));

        when(accountRepository.findById(sender.getId())).thenReturn(
                Optional.of(sender));

        assertThrows(AmountExceedException.class,
                () -> accountService.transferMoney(1L,
                        receiver.getId(),
                        BigDecimal.valueOf(Integer.MAX_VALUE)));
    }

}
