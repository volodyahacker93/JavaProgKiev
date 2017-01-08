package Lection5_6.Task9;

public class Main {

    public static void main(String[] args) {
        Account acc = new Account(1000);
        Transaction[] transactions = {
                new Transaction(acc, 200),
                new Transaction(acc, 100),
                new Transaction(acc, 150),
                new Transaction(acc, 50),
                new Transaction(acc, 100),
                new Transaction(acc, 400)
        };

        for (Transaction t : transactions) {
            t.start();
        }

        for (Transaction t : transactions) {
            try {
                t.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Total: " + acc.get());
    }
}
