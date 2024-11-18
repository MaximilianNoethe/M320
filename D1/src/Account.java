public class Account {
    private String accountNumber;
    private double saldo;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.saldo = 100;
    }
    public void Add(double amount){
        setSaldo(getSaldo() + amount);
    };
    public void Withdraw (double amount){
        setSaldo(getSaldo() - amount);
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
