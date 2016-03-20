package Task6;

import java.util.LinkedList;

/**
 * Created by Elizaveta on 20.03.2016.
 */

/**Блокнот.
 *
 * Состоит из записей
 * @see Note
 *
 */
public class NotePad {
    private LinkedList<Note> notepad;
    public NotePad(){
        notepad=new LinkedList<Note>();
    }

    /**Добавляет к блокноту запись.
     *
     * @param name
     * @param text
     */
    public void addNote(String name, String text){
        notepad.add(new Note(name,text));
    }

    /** Удаляет запись с заданным именем
     *
     * @throws RuntimeException Если такого имени не встречается или оно встречается несколько раз
     * @param name
     * @return Возвращает удалённую запись
     */
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

    /**Изменяет текст записи с заданным именем
     *
     * @throws RuntimeException Если такого имени не встречается или оно встречается несколько раз
     * @param name
     * @param text Новый текст который будет записан вместо старого
     * @return Возвращает удалённую запись
     */
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

    /**Выводит на в консоль список всех записей.*/
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
