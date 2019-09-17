package com.sbo.springbootpostgresql.repository;

import com.sbo.springbootpostgresql.app.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}