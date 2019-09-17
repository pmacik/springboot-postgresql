package com.sbo.springbootpostgresql.controller;

import com.sbo.springbootpostgresql.app.Account;
import com.sbo.springbootpostgresql.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountService service;

    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.GET)
    public ResponseEntity<Account> getAccountById(@PathVariable Long id){
        return new ResponseEntity<Account>(service.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/", method = RequestMethod.GET)
    public ResponseEntity<List<Account>> getAccounts(){
        return new ResponseEntity<List<Account>>(service.getAll(), HttpStatus.OK);
    }
    @RequestMapping(value = "/accounts/", method = RequestMethod.POST)
    public ResponseEntity<String> createAccount(@RequestBody Account account){
        service.create(account);
        return new ResponseEntity<String>("Account created", HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String > updateAccount(@PathVariable Long id, @RequestBody Account updatedAccount){
        if(service.findById(id) == null){
            return new ResponseEntity<String>("Account not found", HttpStatus.NOT_FOUND);
        }
        else{
            service.update(updatedAccount);
            return new ResponseEntity<String>("Account updated successfully", HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        if(service.findById(id) == null){
            return new ResponseEntity<String>("Account not found", HttpStatus.NOT_FOUND);
        }
        else{
            service.delete(id);
            return new ResponseEntity<String>("Account deleted successfully", HttpStatus.OK);
        }
    }
}
