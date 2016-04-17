package Task1;

/**
 * Created by Elizaveta on 17.04.2016.
 */
public class NotEnoughMoneyInAccount extends RuntimeException {
    private String massege;
    public NotEnoughMoneyInAccount(Account from, Account to, int amount) {
        massege="Недостаточно средств у "+from.getName()+ " для перевода "+ amount;
    }

    public String getMassege() {
        return massege;
    }
}
