import br.com.mariojp.solid.lspaccounts.BankService;
import br.com.mariojp.solid.lspaccounts.CheckingAccount;
import br.com.mariojp.solid.lspaccounts.SavingsAccount;

public class Main {
    public static void main(String[] args) {
        CheckingAccount checking = new CheckingAccount();
        checking.deposit(100);
        new BankService().processWithdrawal(checking, 30);
        System.out.println("Checking balance: " + checking.getBalance()); // 70.0

        SavingsAccount savings = new SavingsAccount();
        savings.deposit(100);
        // Estado inicial: irá lançar UnsupportedOperationException (ilustra o problema LSP).
        new BankService().processWithdrawal(savings, 30);
        System.out.println("Savings balance: " + savings.getBalance());
    }
}

//Refatore para que o contrato seja respeitado sem exceções em fluxo normal:
//
//    Somente contas que suportam saque devem ser usadas para saque.
//    O saque não deve ser tentado em contas de depósito apenas.
//
//Caminhos possíveis (você escolhe)
//
//    Introduzir interface Withdrawable { void withdraw(double amount); } e 
//	fazer CheckingAccount implementá-la.
//    SavingsAccount não implementa.
//    BankService deixa de aceitar Account e passa a aceitar Withdrawable para 
//saques, ou faz uma checagem segura e ignora SavingsAccount.
//    Ou separar hierarquia (WithdrawableAccount vs DepositOnlyAccount).
