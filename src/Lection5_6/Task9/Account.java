package Lection5_6.Task9;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    private int money;
    private Lock lock = new ReentrantLock();

    public Account(int money) {
        this.money = money;
    }

    public int get() {
        return money;
    }

    public void withdraw(int amount) {
        lock.lock();
        try {
            if (money >= amount) {
                money -= amount;
            }
        } finally {
            lock.unlock();
        }
    }
}
