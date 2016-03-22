package Task2;

import Task1.Pen;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Elizaveta on 21.03.2016.
 */
public class Employee {
    private String name;
    private String surname;
    private String phonenumber;

    private LinkedList<Pen>  pens;
    private LinkedList<Notebook> notebooks;
    private Clips clips;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public Employee(String name, String surname, String phonenumber) {
        this.name=name;
        this.surname=surname;
        this.phonenumber=phonenumber;
        this.pens = new LinkedList<Pen>();
        this.notebooks = new LinkedList<Notebook>();
        this.clips = new Clips(0);
    }

    public Employee(String name, String surname, String phonenumber, LinkedList<Pen> pens, LinkedList<Notebook> notebooks,Clips clips) {
        this(name,surname,phonenumber);
        this.pens = pens;
        this.notebooks = notebooks;
        this.clips = clips;
    }

    public int getFullCost(){
        int fullCost=0;
        for(Pen pen: pens){
            fullCost+=pen.getCost();
        }
        for(Notebook notebook: notebooks){
            fullCost+=notebook.getCost();
        }
            fullCost+=clips.getCost();
        return fullCost;

    }

    public Employee addPen(Pen pen){
        pens.add(pen);
        return this;
    }

    public Employee addNotebook(Notebook notebook){
        notebooks.add(notebook);
        return this;
    }

    public Employee addClips(int inkr){
        clips.inkr(inkr);
        return this;
    }

    public Employee removePen(Pen pen){
        ListIterator<Pen> iterator=pens.listIterator();
        while (iterator.hasNext()){
            Pen mypen =iterator.next();
            if(mypen.equals(pen)) {
                pens.remove(mypen);
                return this;
            }
        }
        return this;
    }

    public Employee removeNotebook(Notebook notebook){
        ListIterator<Notebook> iterator=notebooks.listIterator();
        while (iterator.hasNext()){
            Notebook mynotebook =iterator.next();
            if(mynotebook.equals(notebook)) {
                pens.remove(mynotebook);
                return this;
            }
        }
        return this;
    }

    public Employee removeClips(int dekr){
        clips.inkr(-dekr);
        return this;
    }

}
