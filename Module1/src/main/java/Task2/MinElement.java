package Task2;

/**
 * Created by Elizaveta on 19.03.2016.
 */
public class MinElement {
    public MinElement(double eps){
        this.eps=eps;
    }

    public static int getMinElement(double eps ){
       return  new MinElement(eps).getMinElement();
    }
    private double eps;

    private double getA(int n){
        return 1.0/Math.pow((n+1),2);
    }

    private int getMinElement(){
        int n=1;
        double a=getA(n);
        while(a>=eps){
            System.out.print(a+" ");
            n++;
            a=getA(n);
        }
        System.out.println(a);
        return n;
    }


}
