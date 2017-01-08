package Lection5_6.Task9;

public class Transaction extends Thread{

    private Account account;
    private int amount;

    public Transaction(Account account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(System.currentTimeMillis() % 50);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        account.withdraw(amount);
    }
}
