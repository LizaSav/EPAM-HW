package Task2;

import java.io.*;
import java.util.HashMap;


/**
 * Created by Elizaveta on 17.04.2016.
 */
public class PropertyReader {
    File file;
    public PropertyReader(File file){
        this.file=file;
    }
    public  HashMap<String,String> getProperties() throws NotPropertiesFileException, FileDoesNotExistException {
        if(isProperties()) {
            if (file.exists()) {
                synchronized (file) {
                    try (BufferedReader in = new BufferedReader(new FileReader(file))) {
                        HashMap<String, String> properties = new HashMap<>();
                        while (in.ready()) {
                            String[] strings = in.readLine().split("=");
                            if (strings.length != 1) {
                                assert strings.length == 2;
                                properties.put(strings[0].trim(), strings[1].trim());
                            }
                        }
                        return properties;
                    } catch (FileNotFoundException e) {
                        System.err.println("Файл не найден");
                    } catch (IOException e) {
                        System.err.println("Не удалось прочитать файл");
                    }
                }
            }else throw new FileDoesNotExistException();
        } else throw new NotPropertiesFileException();
        return null;
    }

    private  boolean isProperties(){
        String filename = file.getName();
        int i = filename.lastIndexOf('.');
        if (i > 0 && i < filename.length() - 1) {
            String extension = filename.substring(i + 1).toLowerCase();
            if (extension.equals("properties")) return true;
            else return false;
        }return false;
    }

    public  String getProperty(String key){
        try {
            HashMap<String,String> properties=getProperties();
            if (properties.containsKey(key)){
                return properties.get(key);
            }else System.err.println("Ключа "+key+" нет в property файле");
        } catch (NotPropertiesFileException e) {
            System.err.println("Файл не является property  файлом");
        } catch (FileDoesNotExistException e) {
            System.err.println("Файла с таким путём не существует");
        }
        return null;
    }
}
