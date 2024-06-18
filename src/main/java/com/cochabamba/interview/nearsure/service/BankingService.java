package com.cochabamba.interview.nearsure.service;

//package com.codesignal.service;

import java.math.BigDecimal;

public interface BankingService {

    /**
     * Deposits the money to the account.
     *
     * @param accountId id of the account, should not be null.
     * @param amount    amount of money to deposit, should be a positive number.
     * @throws IllegalArgumentException if account does not exist or the amount is invalid.
     */
    void deposit(String accountId, BigDecimal amount);

    /**
     * Withdraws the money from the account.
     *
     * @param accountId id of the account, should not be null.
     * @param amount    amount of money to withdraw, should be a positive number.
     * @throws IllegalArgumentException if account does not exist, the amount is invalid or funds are unsufficient.
     */
    void withdraw(String accountId, BigDecimal amount);

    /**
     * Transfers the money from one account to another.
     *
     * @param sourceAccountId id of the source account, should not be null.
     * @param targetAccountId id of the target account, should not be null.
     * @param amount          amount of money to transfer, should be a positive number.
     * @throws IllegalArgumentException if any of the accounts doesn't exist, the amount is invalid or funds on the source are unsufficient.
     */
    void transfer(String sourceAccountId, String targetAccountId, BigDecimal amount);
}
