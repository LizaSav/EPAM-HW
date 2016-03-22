package Task5;

import java.util.*;

/**
 * Created by Elizaveta on 22.03.2016.
 */
public class Group {
    private Set<Student> students;
    private Subjects subject;
    private Map<Student,Marks> marks;


    public Group(Subjects subject){
        students=new HashSet<Student>();
        this.subject=subject;
        marks=new LinkedHashMap<Student, Marks>();
    }

    public Group addStudent(Student student){
        students.add(student);
        return this;

    }

    public Set<Student> getStudents() {
        return students;
    }

    public Subjects getSubject() {
        return subject;
    }

    public Group addMarks(Student student, Number[] mark ){
        if (students.contains(student)){
            if(subject.type) {
                Double[] mark1=new Double[mark.length];
                for(int i=0; i<mark.length; i++){
                    mark1[i]=(Double)mark[i];
                }
                marks.put(student, new Marks<Double> (mark1));

            }
            else{
                Integer[] mark1=new Integer[mark.length];
                for(int i=0; i<mark.length; i++){
                    mark1[i]=(Integer) mark[i];
                }
                marks.put(student, new Marks<Integer> (mark1));
            }
        }
        return this;
    }

    public Number[] getMarks(Student student){
        if(marks.containsKey(student)) return marks.get(student).getMarks();
        else throw new RuntimeException("Не добавлены оценки"+student.getName()+ " "+ student.getSurname());

    }

}
