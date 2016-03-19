package Task3;

import javax.xml.soap.SOAPPart;

/**
 * Created by Elizaveta on 19.03.2016.
 */
public class FunctionTable {
    private double [][] table;

    public FunctionTable(double a, double b, double h){
        table=new double[(int)Math.floor((b-a)/h)+1][2];
        createTable(a,b,h);
    }

    public static void printTable(double a, double b, double h){
        new FunctionTable(a, b, h).printTable();
    }
    private static double  f(double x){
        return Math.tan(2.0*x)-3;
    }

    private void createTable(double a, double b, double h){
        for(int i=0; i<(int)Math.floor((b-a)/h)+1;i++){
            table[i][0]=a+i*h;
            table[i][1]=f(table[i][0]);
        }
    }

    private void printTable(){
        System.out.println("  x           f(x)");
        for(int i=0; i<table.length;i++){
            System.out.printf("%.5f     % .5f\n", table[i][0], table[i][1]);
        }
        System.out.println();
    }




}
