package ru.hard2code.repository;

import org.springframework.data.repository.CrudRepository;
import ru.hard2code.model.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

}
