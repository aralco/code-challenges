package com.cochabamba.interview.nearsure.service;

//package com.codesignal.service;

import com.cochabamba.interview.nearsure.model.Account;
import com.cochabamba.interview.nearsure.repository.AtomicRepository;

import java.math.BigDecimal;
import java.util.Optional;

public class BankingServiceImpl implements BankingService {

    private AtomicRepository<String, Account> accountRepository;

    public BankingServiceImpl(AtomicRepository<String, Account> accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void deposit(String accountId, BigDecimal amount) {
        synchronized (this) {
            if(accountId==null || amount==null || amount.signum()!=1){
                throw new IllegalArgumentException();
            }
            Optional<Account> optionalAccount = accountRepository.findById(accountId);
            if(optionalAccount.isPresent()) {
                Account account = optionalAccount.get();
                Account newAccount = new Account(account.getId(), account.getFirstName(),
                        account.getLastName(), account.getAmount().add(amount));
                accountRepository.compareAndSet(account.getId(), account, newAccount);
            } else  {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public void withdraw(String accountId, BigDecimal amount) {
        synchronized (this) {
            if(accountId==null || amount==null || amount.signum()!=1){
                throw new IllegalArgumentException();
            }
            Optional<Account> optionalAccount = accountRepository.findById(accountId);
            if(optionalAccount.isPresent()) {
                Account account = optionalAccount.get();
                if(amount.compareTo(account.getAmount())>0)    {
                    throw new IllegalArgumentException();
                }
                Account newAccount = new Account(account.getId(), account.getFirstName(),
                        account.getLastName(), account.getAmount().subtract(amount));
                accountRepository.compareAndSet(account.getId(), account, newAccount);
            } else  {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public void transfer(String sourceAccountId, String targetAccountId, BigDecimal amount) {
        withdraw(sourceAccountId, amount);
        deposit(targetAccountId, amount);
    }

}
