public class Account {
    private String accountNumber;
    private double saldo;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.saldo = 100;
    }
    public void Add(double amount){
        saldo += amount;
    };
    public void Withdraw (double amount){
        saldo -= amount;
    }
    public boolean Transfer(double amount, Account targetAccount) {
        if (amount > 0 && amount <= saldo) {
            this.Withdraw(amount);
            targetAccount.Add(amount);
            return true;
        } else {
            return false;
        }
    }
    public double ShowCurrentAmount(){
        return saldo;
    }

}
