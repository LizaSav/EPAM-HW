package Task1;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;

/**
 * Created by Elizaveta on 17.04.2016.
 */
public class TransactionTest2 {
    @Test
    public void makeTransactionTest() throws IOException, InterruptedException {
        Map<String, Account> accounts = new HashMap<>();
        accounts.put("1", new Account(100, "1"));
        accounts.put("2", new Account(200, "2"));
        accounts.put("3", new Account(300, "3"));

        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(e.getMessage());
            }
        });
        BufferedReader in = new BufferedReader(new FileReader("src/main/resources/transactions"));
        ExecutorService ex = Executors.newCachedThreadPool();
        while (in.ready()) {
            String[] strings = in.readLine().split(" ");
            ex.execute(new Transaction(accounts.get(strings[0]), accounts.get(strings[1]), Integer.parseInt(strings[2])));
        }
        Thread.sleep(1000);
        assertEquals(210, accounts.get("1").getBalanse());
    }
}
