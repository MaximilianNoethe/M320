public class Test {
    public static void main(String[] args) {
        Account account1 = new Account("1", 12345);
        Account account2 = new Account("2", 67890);

        account1.Add(100);
        account1.Withdraw(50);
        account1.Transfer(200, account2);

        System.out.println("Account 1 balance: " + account1.ShowCurrentAmount());
        System.out.println("Account 2 balance: " + account2.ShowCurrentAmount());
    }
}