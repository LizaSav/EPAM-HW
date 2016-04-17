package Task1;

/**
 * Created by Elizaveta on 17.04.2016.
 */
public class Account {
    private String name;
    private int balanse;

    public int getBalanse() {
        return balanse;
    }
    public void debit(int amount){
        balanse-=amount;
    }
    public void credit(int amount){
        balanse+=amount;
    }

    public String getName() {

        return name;
    }

    public Account(int balanse, String name) {

        this.balanse = balanse;
        this.name = name;
    }
}
