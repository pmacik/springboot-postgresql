package com.sbo.springbootpostgresql.service;


import com.sbo.springbootpostgresql.app.Account;
import com.sbo.springbootpostgresql.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository repository;

    public Account findById(Long id){
        return repository.getOne(id);
    }

    public List<Account> getAll(){
        return repository.findAll();
    }

    public void create(Account account){
        repository.save(account);
    }

    public void update(Account updatedAccount){
        Account accountToBeUpdated = repository.getOne(updatedAccount.getId());
        accountToBeUpdated.setName(updatedAccount.getName());
        accountToBeUpdated.setEmail(updatedAccount.getEmail());
        repository.save(accountToBeUpdated);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
