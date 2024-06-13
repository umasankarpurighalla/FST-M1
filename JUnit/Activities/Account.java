package Activities;

public class Account {

    private Integer balance;

    public BankAccount(Integer initialBalance) {
        balance = initialBalance;
    }

    // Add method to calculate
// balance amount after withdrawal
    public Integer withdraw(Integer amount) {
        if (balance < amount) {
            throw new NotEnoughFundsException(amount, balance);
        }
        balance -= amount;
        return balance;
    }

}
