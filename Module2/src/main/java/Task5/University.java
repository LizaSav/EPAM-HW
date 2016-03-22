package Task5;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Elizaveta on 22.03.2016.
 */
public class University {
    private Set<Group> groups;

    public University(){
        groups=new HashSet<Group>();
    }
    public University addGroupp(Group g){
        groups.add(g);
        return this;
    }
    public Set<Group> getGroups(Student student){
        Set<Group> result = new HashSet<Group>();
        for(Group g:groups){
            if(g.getStudents().contains(student))  result.add(g);
        }
        return result;
    }

    public void printAllMarks(Student student){
        Set<Group> groups= getGroups(student);
        for (Group g:groups) {
            if(g.getSubject().type){
                double[] d=new double[g.getMarks(student).length];
                        for(int i=0; i<d.length; i++) {
                            d[i]=(Double) g.getMarks(student)[i];
                        }
                System.out.print(g.getSubject() + " : " );
                for(int i=0; i<d.length; i++){
                    System.out.print(d[i]+" ");
                }
                System.out.println();
            }
            if(!g.getSubject().type){
                int[] d=new int[g.getMarks(student).length];
                for(int i=0; i<d.length; i++) {
                    d[i]=(Integer) g.getMarks(student)[i];
                }
                System.out.print(g.getSubject() + " : " );
                for(int i=0; i<d.length; i++){
                    System.out.print(d[i]+" ");
                }
                System.out.println();
            }
        }
    }

}
