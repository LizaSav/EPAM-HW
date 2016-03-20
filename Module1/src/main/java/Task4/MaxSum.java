package Task4;

/**
 * Created by Elizaveta on 20.03.2016.
 */
public class MaxSum {
    public MaxSum(double[] a){
        this.a=a;
    }
    public static double getMaxSum(double[] a){
        return new MaxSum(a).getMaxSum();
    }
    private double[] a;

    private double getMaxSum(){
        if (a.length==1)return a[0];
        double max=a[0]+a[1];
        double max1;
        for(int i=1; i<a.length-1; i++){
            max1=a[i]+a[i+1];
            if(max1>max)max=max1;
        }
        return max;
    }
}
