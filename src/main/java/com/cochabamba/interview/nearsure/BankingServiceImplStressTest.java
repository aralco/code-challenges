package com.cochabamba.interview.nearsure;

//package com.codesignal.service;


//import com.codesignal.model.Account;
//import com.codesignal.repository.AtomicRepository;
//import com.codesignal.repository.InMemoryAccountRepository;
import com.cochabamba.interview.nearsure.model.Account;
import com.cochabamba.interview.nearsure.repository.AtomicRepository;
import com.cochabamba.interview.nearsure.repository.InMemoryAccountRepository;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.cochabamba.interview.nearsure.service.BankingService;
import com.cochabamba.interview.nearsure.service.BankingServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankingServiceImplStressTest {

    private AtomicRepository<String, Account> accountRepository;

    private BankingService subject;

    private Account sourceAccount;
    private Account targetAccount;

    @BeforeEach
    public void setUp() {
        accountRepository = new InMemoryAccountRepository();
        subject = new BankingServiceImpl(accountRepository);

        sourceAccount = accountRepository.save(new Account("John", "Doe", new BigDecimal(1000)));
        targetAccount = accountRepository.save(new Account("Sid", "Fisher", new BigDecimal(1000)));
    }

    @Test
    public void shouldPerformAllOperationsConcurrentlyOnASingleAccount() throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);

        List<Callable<Void>> tasks = Stream.concat(
                Stream.concat(
                        IntStream.range(0, 100).mapToObj(i -> new DepositTask(subject, sourceAccount.getId(), new BigDecimal(5))),
                        IntStream.range(0, 100).mapToObj(i -> new WithdrawTask(subject, sourceAccount.getId(), new BigDecimal(6)))
                ),
                IntStream.range(0, 100).mapToObj(i -> new TransferTask(subject, sourceAccount.getId(), targetAccount.getId(), new BigDecimal(4)))
        ).collect(Collectors.toList());
        Collections.shuffle(tasks);

        es.invokeAll(tasks);

        Account sourceAccountUpdated = accountRepository.findById(sourceAccount.getId()).orElseThrow(AssertionError::new);
        Account targetAccountUpdated = accountRepository.findById(targetAccount.getId()).orElseThrow(AssertionError::new);
        Assertions.assertEquals(new BigDecimal(500), sourceAccountUpdated.getAmount());
        Assertions.assertEquals(new BigDecimal(1400), targetAccountUpdated.getAmount());
    }

    @Test
    public void shouldAvoidDeadLock() throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);

        List<Callable<Void>> tasks = Stream.concat(
                IntStream.range(0, 100).mapToObj(i -> new TransferTask(subject, sourceAccount.getId(), targetAccount.getId(), new BigDecimal(5))),
                IntStream.range(0, 100).mapToObj(i -> new TransferTask(subject, targetAccount.getId(), sourceAccount.getId(), new BigDecimal(4)))
        ).collect(Collectors.toList());

        Collections.shuffle(tasks);

        es.invokeAll(tasks);

        Account sourceAccountUpdated = accountRepository.findById(sourceAccount.getId()).orElseThrow(AssertionError::new);
        Account targetAccountUpdated = accountRepository.findById(targetAccount.getId()).orElseThrow(AssertionError::new);
        Assertions.assertEquals(new BigDecimal(900), sourceAccountUpdated.getAmount());
        Assertions.assertEquals(new BigDecimal(1100), targetAccountUpdated.getAmount());
    }

}

class DepositTask implements Callable<Void> {

    private BankingService bankingService;
    private String accountId;
    private BigDecimal amount;

    public DepositTask(BankingService bankingService, String accountId, BigDecimal amount) {
        this.bankingService = bankingService;
        this.accountId = accountId;
        this.amount = amount;
    }

    @Override
    public Void call() {
        bankingService.deposit(accountId, amount);
        return null;
    }
}

class WithdrawTask implements Callable<Void> {

    private BankingService bankingService;
    private String accountId;
    private BigDecimal amount;

    public WithdrawTask(BankingService bankingService, String accountId, BigDecimal amount) {
        this.bankingService = bankingService;
        this.accountId = accountId;
        this.amount = amount;
    }

    @Override
    public Void call() {
        bankingService.withdraw(accountId, amount);
        return null;
    }
}


class TransferTask implements Callable<Void> {

    private BankingService bankingService;
    private String sourceAccountId;
    private String targetAccountId;
    private BigDecimal amount;

    public TransferTask(BankingService bankingService, String sourceAccountId, String targetAccountId, BigDecimal amount) {
        this.bankingService = bankingService;
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.amount = amount;
    }

    @Override
    public Void call() {
        bankingService.transfer(sourceAccountId, targetAccountId, amount);
        return null;
    }
}
