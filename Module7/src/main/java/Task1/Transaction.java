package Task1;

/**
 * Created by Elizaveta on 17.04.2016.
 */
public class Transaction implements Runnable {
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
     private void  makeTransaction() throws NotEnoughMoneyInAccount {
         if(to.getName().hashCode()>from.getName().hashCode()){
            synchronized (to){
                synchronized (from){
                    if (from.getBalanse()<amount) throw new NotEnoughMoneyInAccount(from, to, amount);
                    else {
                        from.debit(amount);
                        to.credit(amount);
                        System.out.println(from.getName() + " " + to.getName() + " " + amount);
                    }
                }
            }
         }
         else{ synchronized (from){
             synchronized (to){
                 if (from.getBalanse()<amount) throw new NotEnoughMoneyInAccount(from, to, amount);
                 else {
                     from.debit(amount);
                     to.credit(amount);
                     System.out.println(from.getName() + " " + to.getName() + " " + amount);
                 }
             }
             }
         }
     }
}
