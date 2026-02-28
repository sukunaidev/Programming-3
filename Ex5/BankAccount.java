public class BankAccount implements Runnable {

    int balance = 1000;

    public void run() {
        withdraw(700);
    }

    public synchronized void withdraw(int amount) {
        if (amount <= balance) {
            balance = balance - amount;
        }

        System.out.println("Balance:" + balance);

    }
}
