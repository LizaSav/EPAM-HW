package Task3;


/**
 * Created by Elizaveta on 22.03.2016.
 */
public class Stationery {

    public String getName(){
        String[] s=this.getClass().getName().split("@");
        return s[0];
    }
    public String toString(){
        return getName();
    }

}
