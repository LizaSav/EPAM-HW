package Task1_2;

import java.util.concurrent.locks.Lock;

/**
 * Created by Elizaveta on 17.04.2016.
 */
public class Account extends Task1.Account {

    public Lock lock;

    public Account(int balanse, String name) {
        super(balanse, name);
    }
}
