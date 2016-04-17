package Task1_2;

import Task1.NotEnoughMoneyInAccount;

/**
 * Created by Elizaveta on 17.04.2016.
 */
public class Transaction {
    private Account to, from;
    int amount;

    public Transaction(Account from, Account to, int amount) {
        this.to = to;
        this.from = from;
        this.amount = amount;
    }

    public void run() {
        makeTransaction();
    }

    private void makeTransaction() throws NotEnoughMoneyInAccount {
        while (true) {
            if (from.lock.tryLock()) {
                if (to.lock.tryLock()) {
                    if (from.getBalanse() < amount) throw new NotEnoughMoneyInAccount(from, to, amount);
                    else {
                        from.debit(amount);
                        to.credit(amount);
                        System.out.println(from.getName() + " " + to.getName() + " " + amount);
                    }
                }
                else from.lock.unlock();
            }
        }
    }
}
