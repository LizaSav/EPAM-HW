package Task5;

/**
 * Created by Elizaveta on 20.03.2016.
 */
public class Matrix {
    public Matrix(int n){
        matrix=new boolean[n][n];
        for(int i=0; i<n; i++ ){
            matrix[i][i]=matrix[i][n-1-i]=true;
        }
    }

    public static void getMatrix(int n){
        new Matrix(n).getMatrix();
    }

    private  void getMatrix(){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length;j++ ){
                System.out.print(((matrix[i][j])?'1':'0')+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean[][] matrix;
}
