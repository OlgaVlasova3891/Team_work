package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreditAccountTest {

    @Test
    public void getBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        Assertions.assertEquals(0, account.getBalance());
    }
    @Test
    public void getRate() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        Assertions.assertEquals(15, account.getRate());
    }
    @Test
    public void shouldSetRate() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.setRate(10);
        Assertions.assertEquals(10, account.getRate());
    }
    @Test
    public void getCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        Assertions.assertEquals(5_000, account.getCreditLimit());
    }

    @Test
    public void shouldAddPositiveAmountToPositiveBalance() {
        //balance = 0, amount > 0
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }
    @Test
    public void shouldAddNegativeAmountToPositiveBalance() {
        //balance = 0, amount < 0
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(-3_000);

        Assertions.assertEquals(0, account.getBalance());
    }
    @Test
    public void shouldAddAPositiveAmountToPositiveBalance() {
        //balance > 0, amount > 0
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(4_000, account.getBalance());
    }
    @Test
    //balance > 0, amount > 0
    public void shouldAddPositiveAmountToNegativeBalance() {
        //balance < 0, amount > 0
        CreditAccount account = new CreditAccount(
                -1_000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }
    @Test
    public void shouldPayPositiveAmount() {
        // balance > 0, amount > 0
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );
    assertTrue(account.pay(500));
    Assertions.assertEquals(500, account.getBalance());
    }
    @Test
    public void shouldPayZeroAmount() {
        // balance > 0, amount = 0
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );
        assertFalse(account.pay(0));
        Assertions.assertEquals(1_000, account.getBalance());
    }
    @Test
    public void shouldPayNegativeAmount() {
        // balance > 0, amount < 0
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );
        assertFalse(account.pay(-500));
        Assertions.assertEquals(1_000, account.getBalance());
    }
    @Test
    public void shouldPayAmountAboveCreditLimit() {
        // balance > 0, amount > (creditLimit + balance)
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );
        assertFalse(account.pay(6_001));
        Assertions.assertEquals(1_000, account.getBalance());
    }
    @Test
    public void testYearChangeIfBalanceIsPositive() {
      // balance > 0
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );
        Assertions.assertEquals(0, account.yearChange());
    }
    @Test
    public void testYearChangeIfBalanceIsNegative() {
        // balance < 0
        CreditAccount account = new CreditAccount(
                -1_000,
                5_000,
                15
        );
        Assertions.assertEquals(-150, account.yearChange());
    }
    @Test
    public void testYearChangeIfBalanceIsZero() {
        // balance = 0
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        Assertions.assertEquals(0, account.yearChange());
    }
    @Test

    public void testExceptionIfRateIsNegative() {
        // rate < 0;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(2_000, 5_000,-15);
        });
        }
    @Test
    public void testExceptionIfBalanceIsNegative() {
        // initialBalance < 0;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(-2_000, 5_000, 15);
        });
    }
    @Test
    public void testExceptionIfCreditLimitIsNegative() {
        // creditLimit < 0;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(2_000, -5_000, 15);});
    }
   }

