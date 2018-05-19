package com.plgrnds.tests.bank;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Account {

    private final UUID id;
    private final Customer owner;
    private BigDecimal balance;

    public Account(Customer owner) {
        id = UUID.randomUUID();
        this.owner = owner;
        this.balance = balance;
    }

    public Customer getOwner() {
        return owner;
    }
    
    public bigDecinal getBalance() {
        return this.balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
 public double getBalance() {
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
public void withdraw(BigDecimal amount) throws IllegalArgumentException {
        checkValidAmount(amount);
        if (amount.compareTo(this.balance) > 0) {
            throw new IllegalArgumentException("The amount to withdraw is greater than account balance.");
        }
        this.balance = this.balance.subtract(amount);
    }

    public void deposit(BigDecimal amount) {
        checkValidAmount(amount);
        this.balance = this.balance.add(amount);
    }

    private void checkValidAmount(BigDecimal amount) {
        if (amount == null || amount.signum() <= 0) {
            throw new IllegalArgumentException("Incorrect amount to process: "
                    + (amount == null ? null : amount.toString()));
        }
    }

    public void transfer(Account targetAccount, BigDecimal bigDecimal) {
        if (targetAccount == null) {
            throw new RuntimeException("Target account cannot be null.");
        }
        this.withdraw(bigDecimal);
        targetAccount.deposit(bigDecimal);
    }
       public void CashIn(double amount){
        this.balance = setBalance(getBalance()+ amount);
    }
    public void CashOut(double amount){
        this.balance = setBalance(getBalance()- amount);
    }


}
