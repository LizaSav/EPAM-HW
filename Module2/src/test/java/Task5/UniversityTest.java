package Task5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Elizaveta on 22.03.2016.
 */
public class UniversityTest {
    @Test
    public void getGroupsTest(){
        Student a=new Student("a","a");
        Student b=new Student("b", "b");
        Student c=new Student("c", "c");
        Student d=new Student("d","d");

        Group g1=new Group(Subjects.Algebra);
        Group g2=new Group(Subjects.Geom);
        Group g3=new Group(Subjects.Calculus);

        University university = new University();
        university.addGroupp(g1).addGroupp(g2).addGroupp(g3);

        g1.addStudent(a).addStudent(b).addStudent(c);
        g2.addStudent(a).addStudent(d);
        g3.addStudent(a).addStudent(b);

        g1.addMarks(a,new Number[]{2.0}).addMarks(b, new Number[]{5.2});
        g2.addMarks(a,new Number[]{10}).addMarks(d,new Number[]{5});
        g3.addMarks(a,new Number[]{11}).addMarks(b,new Number[]{3});

        university.printAllMarks(a);
        System.out.println();

        university.printAllMarks(c);
        System.out.println();

        assertEquals(3, university.getGroups(a).size());
        assertEquals(2,university.getGroups(b).size());

    }
}
