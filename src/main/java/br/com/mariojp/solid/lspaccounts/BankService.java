package br.com.mariojp.solid.lspaccounts;

public class BankService {
    public void processWithdrawal(Account acc, double amount){
    	if (acc instanceof SavingsAccount){
    		System.out.println("Esse tipo de conta não possui permissão para saque.");
    	} else {
    		acc.withdraw(amount);
    	}
    }
}