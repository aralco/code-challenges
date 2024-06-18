package com.cochabamba.interview.nearsure;

//package com.codesignal;

import com.cochabamba.interview.nearsure.model.Account;

import java.math.BigDecimal;

import com.cochabamba.interview.nearsure.repository.AtomicRepository;
import com.cochabamba.interview.nearsure.repository.InMemoryAccountRepository;
import com.cochabamba.interview.nearsure.service.BankingServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BankingServiceImplTest {

    private AtomicRepository<String, Account> accountRepository;

    private BankingServiceImpl subject;

    @BeforeEach
    public void setUp() {
        accountRepository = new InMemoryAccountRepository();
        subject = new BankingServiceImpl(accountRepository);
    }

    @Nested
    @DisplayName("Deposit method")
    class Deposit {

        @Test
        public void shouldDepositSuccessfullyWhenAmountIsValidAndAccountExists() {
            // given
            Account initialAccount = accountRepository.save(new Account("John", "Doe", new BigDecimal("2500.00")));

            // when
            subject.deposit(initialAccount.getId(), new BigDecimal("239.30"));

            // then
            Account updatedAccount = accountRepository.findById(initialAccount.getId()).orElseThrow(AssertionError::new);
            Assertions.assertEquals(initialAccount.getFirstName(), updatedAccount.getFirstName());
            Assertions.assertEquals(initialAccount.getLastName(), updatedAccount.getLastName());
            Assertions.assertEquals(new BigDecimal("2739.30"), updatedAccount.getAmount());
        }

        @Test
        public void shouldThrowIllegalArgumentExceptionOnDepositWhenAccountDoesNotExist() {
            // given
            String nonExistingAccountId = "nonExistingAccountId";

            // when
            Assertions.assertThrows(IllegalArgumentException.class, () -> subject.deposit(nonExistingAccountId, new BigDecimal("239.30")));
        }

        @Test
        public void shouldThrowIllegalArgumentExceptionOnDepositWhenAmountIsInvalid() {
            // given
            Account initialAccount = accountRepository.save(new Account("John", "Doe", new BigDecimal("2500.00")));

            // expect
            Assertions.assertThrows(IllegalArgumentException.class, () -> subject.deposit(initialAccount.getId(), new BigDecimal("-239.30")));
        }
    }

    @Nested
    @DisplayName("Withdraw method")
    class Withdraw {

        @Test
        public void shouldWithdrawSuccessfullyWhenAmountIsValidAndAccountExists() {
            // given
            Account initialAccount = accountRepository.save(new Account("John", "Doe", new BigDecimal("2500.00")));

            // when
            subject.withdraw(initialAccount.getId(), new BigDecimal("239.30"));

            // then
            Account updatedAccount = accountRepository.findById(initialAccount.getId()).orElseThrow(AssertionError::new);
            Assertions.assertEquals(initialAccount.getFirstName(), updatedAccount.getFirstName());
            Assertions.assertEquals(initialAccount.getLastName(), updatedAccount.getLastName());
            Assertions.assertEquals(new BigDecimal("2260.70"), updatedAccount.getAmount());
        }

        @Test
        public void shouldThrowIllegalArgumentExceptionOnWithdrawalWhenAccountDoesNotExist() {
            // given
            String nonExistingAccountId = "nonExistingAccountId";

            // expect
            Assertions.assertThrows(IllegalArgumentException.class, () -> subject.withdraw(nonExistingAccountId, new BigDecimal("239.30")));
        }

        @Test
        public void shouldThrowIllegalArgumentExceptionOnWithdrawalWhenAmountIsInvalid() {
            // given
            Account initialAccount = accountRepository.save(new Account("John", "Doe", new BigDecimal("2500.00")));

            // expect
            Assertions.assertThrows(IllegalArgumentException.class, () -> subject.withdraw(initialAccount.getId(), new BigDecimal("-239.30")));
        }

        @Test
        public void shouldThrowIllegalArgumentExceptionOnWithdrawalWhenFundsInsufficient() {
            // given
            Account initialAccount = accountRepository.save(new Account("John", "Doe", new BigDecimal("30.00")));

            // expect
            Assertions.assertThrows(IllegalArgumentException.class, () -> subject.withdraw(initialAccount.getId(), new BigDecimal("239.30")));
        }
    }

    @Nested
    @DisplayName("Transfer method")
    class Transfer {

        @Test
        public void shouldTransferSuccessfullyWhenAmountIsValidAndBothAccountsExist() {
            // given
            Account sourceAccount = accountRepository.save(new Account("John", "Doe", new BigDecimal("2500.00")));
            Account targetAccount = accountRepository.save(new Account("Sid", "Fisher", new BigDecimal("1200.00")));

            // when
            subject.transfer(sourceAccount.getId(), targetAccount.getId(), new BigDecimal("239.30"));

            // then
            Account sourceAccountUpdated = accountRepository.findById(sourceAccount.getId()).orElseThrow(AssertionError::new);
            Assertions.assertEquals(sourceAccount.getFirstName(), sourceAccountUpdated.getFirstName());
            Assertions.assertEquals(sourceAccount.getLastName(), sourceAccountUpdated.getLastName());
            Assertions.assertEquals(new BigDecimal("2260.70"), sourceAccountUpdated.getAmount());

            Account targetAccountUpdated = accountRepository.findById(targetAccount.getId()).orElseThrow(AssertionError::new);
            Assertions.assertEquals(targetAccount.getFirstName(), targetAccountUpdated.getFirstName());
            Assertions.assertEquals(targetAccount.getLastName(), targetAccountUpdated.getLastName());
            Assertions.assertEquals(new BigDecimal("1439.30"), targetAccountUpdated.getAmount());
        }

        @Test
        public void shouldThrowIllegalArgumentExceptionOnTransferWhenSourceAccountDoesNotExist() {
            // given
            String nonExistingSourceAccountId = "nonExistingSourceAccountId";
            Account targetAccount = accountRepository.save(new Account("Sid", "Fisher", new BigDecimal("1200.00")));

            // expect
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> subject.transfer(nonExistingSourceAccountId, targetAccount.getId(), new BigDecimal("239.30")));
        }

        @Test
        public void shouldThrowIllegalArgumentExceptionOnTransferWhenTargetAccountDoesNotExist() {
            // given
            Account sourceAccount = accountRepository.save(new Account("John", "Doe", new BigDecimal("2500.00")));
            String nonExistingTargetAccountId = "nonExistingTargetAccountId";

            // when
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> subject.transfer(sourceAccount.getId(), nonExistingTargetAccountId, new BigDecimal("239.30")));
        }

        @Test
        public void shouldThrowIllegalArgumentExceptionOnTransferWhenAmountIsInvalid() {
            // given
            String sourceAccountId = "sourceAccountId";
            String targetAccountId = "targetAccountId";

            // expect
            Assertions.assertThrows(IllegalArgumentException.class, () -> subject.transfer(sourceAccountId, targetAccountId, new BigDecimal("-15.30")));
        }

        @Test
        public void shouldThrowIllegalArgumentExceptionOnTransferWhenFundsInsufficient() {
            // given
            Account sourceAccount = accountRepository.save(new Account("John", "Doe", new BigDecimal("2500.00")));
            Account targetAccount = accountRepository.save(new Account("Sid", "Fisher", new BigDecimal("1200.00")));

            // when
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> subject.transfer(sourceAccount.getId(), targetAccount.getId(), new BigDecimal("3000.00")));
        }
    }

}
