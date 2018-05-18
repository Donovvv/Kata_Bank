package com.plgrnds.tests.bank;

import java.util.Set;

public class Bank {

	private final AccountRepository accountRepository;

	public Bank(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public Set<Account> getCustomerAccounts(Customer customer) {
		return accountRepository.getAccountsForCustomer(customer);
	}
	
	public void deposit(Customer customer, Account account, BigDecimal depositAmount) {
        checkOperationNotAllowed(customer, account, ERROR_MESSAGE_DEPOSIT);
        account.deposit(depositAmount);
    }

        public void withdraw(Customer customer, Account account, BigDecimal withdrawAmount) {
        checkOperationNotAllowed(customer, account, ERROR_MESSAGE_WITHDRAW);
        account.withdraw(withdrawAmount);
    }
	public void transfer(Account firstAccount, Account secoundAccount, double transferAmount) {
		firstAccount.setBalance(); = firstAccount.getBalance(); - transferAmount;
		secoundAccount.setBalance(); = secoundAccount.getBalance(); + transferAmount;
	}
	
	
        private void checkOperationNotAllowed(Customer customer, Account account, String message) {
        if (!getAccountsForCustomer(customer).contains(account)) {
            throw new RuntimeException(message);
        }
    }

  	public Set<Deposit> getDepositsForCustomer(Customer customer) {
        return bankProductsRepository.findDepositsForCustomer(customer);
    }

        public Deposit openDeposit (Customer customer, Account account, BigDecimal depositBalance, DepositType depositType){
        checkOperationNotAllowed(customer, account, ERROR_MESSAGE_OPEN_DEPOSIT);
        return new Deposit(account, depositBalance, depositType);
    }

}
