package com.cochabamba.interview.nearsure.repository;

//package com.codesignal.repository;

import com.cochabamba.interview.nearsure.model.Account;

import java.time.Instant;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryAccountRepository implements AtomicRepository<String, Account> {

    private Map<String, Account> accounts = new ConcurrentHashMap<>();

    @Override
    public Account save(Account account) {
        while (true) {
            account.setId(generateId());
            if (accounts.putIfAbsent(account.getId(), account) == null) {
                return account;
            }
        }
    }

    @Override
    public Optional<Account> findById(String id) {
        return Optional.ofNullable(accounts.get(id));
    }

    @Override
    public boolean compareAndSet(String id, Account oldValue, Account value) {
        return accounts.replace(id, oldValue, value);
    }

    private String generateId() {
        return String.valueOf(Instant.now().toEpochMilli());
    }
}
