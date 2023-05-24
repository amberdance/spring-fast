package ru.hard2code;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.hard2code.model.Account;
import ru.hard2code.service.AccountService;

import java.math.BigDecimal;


@Configuration
public class DataLoader {

    @Bean
    public ApplicationRunner accountDataLoader(AccountService accountService) {
        return args -> {
            accountService.save(new Account("Peter", BigDecimal.valueOf(1500)));
            accountService.save(new Account("Harry", BigDecimal.valueOf(3500)));
        };
    }
}
