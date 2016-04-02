package Task1;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Elizaveta on 24.03.2016.
 */

public class CrazyLogger implements Closeable{ //Почему-то ругается на AutoClosable -пишет, что не доступно на этом уровне языка. стоит Java 8 JDK последний
    private StringBuffer log;
    private final File file;
    private final int capacity;
    private int i;
    private Writer out;
    private SimpleDateFormat format;

    public CrazyLogger(File file, int capacity){
        assert (capacity>0);
        this.file=file;
        log= new StringBuffer();
        this.capacity=capacity;
        i=0;
        try {
            out =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.file, true),"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        format=new SimpleDateFormat("dd-MM- yyyy : hh-mm");
    }

    public void fatal(String message){
        logger("FATAL", message);
    }
    public void error(String message){
        logger("ERROR", message);
    }
    public void warning(String message){
        logger("WARNING", message);
    }
    public void info(String message){
        logger("INFO", message);
    }
        private void logger( String level, String message){

        Date date= new Date();
        log.append(format.format(date)+ " ["+level+"] - "+message+"\n");
        if (i==capacity-1){
            i=0;
            push();
        }
        else i++;
    }

    private  void push(){
        try {
            out.write(log.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.setLength(0);
    }

    public void close() throws IOException {
        push();
        out.close();
    }
}
