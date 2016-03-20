package Task6;

/**
 * Created by Elizaveta on 20.03.2016.
 */

/** Запись в блокноте.*/
public class Note {
    public Note( String name, String text){
        this.name=name;
        this.text=text;
    }

    @Override
    public  String toString(){
        return"Name: "+name+"  Text:  "+text;
    }

    public String getName() {
        return name;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    private String name;
    private String text;

}
