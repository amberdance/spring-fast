package ru.hard2code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hard2code.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
