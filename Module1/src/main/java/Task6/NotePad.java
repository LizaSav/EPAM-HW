package Task6;

import java.util.LinkedList;

/**
 * Created by Elizaveta on 20.03.2016.
 */
public class NotePad {
    private LinkedList<Note> notepad;
    public NotePad(){
        notepad=new LinkedList<Note>();
    }
    public void addNote(String name, String text){
        notepad.add(new Note(name,text));
    }

    public Note deleteNote(String name){
        Note deleted=null;
        int i=0;
        for(Note n:notepad){
            if(n.getName().equals(name)){
                deleted=n;
                i++;
            }
        }
        if ((deleted==null)||(i>1)) throw new RuntimeException();
        else notepad.remove(deleted);
        return deleted;
    }

    public Note editNote(String name, String text){
        Note edited=null;
        int i=0;
        for(Note n:notepad){
            if(n.getName().equals(name)){
                edited=n;
                i++;
            }
        }
        if ((edited==null)||(i>1)) throw new RuntimeException();
        else {
            edited.setText(text);
            return edited;
        }
    }

    public void printNotePad(){
        if(notepad.isEmpty()) {
            System.out.println("NotePad is empty");
            return;
        }
        for(Note n:notepad){
            System.out.println(n);
        }
        System.out.println();
    }

}
