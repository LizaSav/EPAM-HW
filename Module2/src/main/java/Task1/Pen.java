package Task1;

import java.awt.*;

/**
 * Created by Elizaveta on 20.03.2016.
 */

public class Pen {
    private PenType type;
    private Color color;
    private double fineness;


    public Pen(PenType type, Color color, double fineness) {
        this.type = type;
        this.color = color;
        this.fineness = fineness;
    }

    public int getCost(){
        return type.getCost();
    }

    @Override
    public String toString(){
        return type.name()+ " Pen : Color= "+color.toString()+"  finenss= "+fineness+"mm";
    }

    @Override
    public int hashCode(){
        return 7*type.getCost()*(int)fineness+color.hashCode();
    }

    @Override
    public boolean equals(Object ob){
        if(this==ob) return true;
        if (ob==null) return false;
        if(getClass()!=ob.getClass()) return false;

        Pen p=(Pen)ob;
        if (p.hashCode()!=this.hashCode()) return false;
        if (type!=p.type) return false;
        if (color!=p.color) return false;
        return true; //тонкость можно не проверять так как hashCode совпал
    }


}
