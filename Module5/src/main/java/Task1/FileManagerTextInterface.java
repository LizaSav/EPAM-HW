package Task1;

import java.io.File;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

/**
 * Created by Elizaveta on 09.04.2016.
 */
/*
  для записи и дозаписи доступны только .txt и .java, добавить форматы можно в классе FileManager  в массив textFormat
 */
public class FileManagerTextInterface {
    public static void start(){
        FileManager filem = new FileManager();
        File file = filem.getCurrent();
        System.out.println(getCurrentInfo(file));
      //  System.out.println(getCommandInfo());
        Scanner sc = new Scanner(System.in);
        String string="";
        string = sc.next();
        while (!string.equals("exit")){
            switch (string){
                case "cd":{
                    System.out.println("Введите абсолютный путь:\n");
                    String path =sc.next();
                    try {
                        filem.toFile(path);
                        System.out.println(getCurrentInfo(filem.getCurrent()));
                        string=sc.next();
                    } catch (FileDoesNotExistException e) {
                        System.out.println("Файла с таким путём не существует");
                        System.out.println(getCurrentInfo(filem.getCurrent()));
                        string=sc.next();
                    }
                    break;
                }
                case "delete":{
                    try {
                        filem.delete();
                    } catch (AttemptToDeleteDirectoryException e) {
                        System.out.println("Удаление каталога запрещено");
                    } catch (NotTextFileException e) {
                        System.out.println("Удаление не текстовых файлов запрещено ");
                    } finally {
                        System.out.println(getCurrentInfo(filem.getCurrent()));
                        string=sc.next();
                    }
                    break;
                }
                case "createfile":{
                    System.out.println("Введите название создаваемого файла");
                    String name =sc.next();
                    try {
                        filem.createFile(name);
                    } catch (FileAlreadyExistsException e) {
                        System.out.println("Файл с таким именем уже существует");
                    } catch (WriteToDirectoryException e) {
                        System.out.println("Добавление файла не в дирректорию не возможна");
                    }
                    finally {
                        System.out.println(getCurrentInfo(filem.getCurrent()));
                        string=sc.next();
                    }
                    break;
                }
                case "createdir":{
                    System.out.println("Введите название создаваемой дирректории");
                    String name =sc.next();
                    try {
                        filem.createDir(name);
                    } catch (FileAlreadyExistsException e) {
                        System.out.println("Дирректория с таким именем уже существует");
                    } catch (WriteToDirectoryException e) {
                        System.out.println("Добавление файла не в дирректорию не возможна");
                    }
                    finally {
                        System.out.println(getCurrentInfo(filem.getCurrent()));
                        string=sc.next();
                    }
                    break;
                }
                case "parent":{
                    try {
                        filem.toPreviousDirectory();
                    } catch (RootDirectoryParentException e) {
                        System.out.println("Вы находитесь в корневой дирректории");
                    }
                    finally {
                        System.out.println(getCurrentInfo(filem.getCurrent()));
                        string=sc.next();
                    }
                    break;
                }
                case "getch":{
                    System.out.println("Список дочерних дирректорий");
                    for (File ch:filem.getCurrent().listFiles()){
                        System.out.println(ch.getName());
                    }
                    System.out.println("Введите название файла из списка");
                    String name = sc.next();
                    try {
                        filem.toChildDirectory(name);
                    } catch (FileDoesNotExistException e) {
                        System.out.println("Файла с таким именем нет в текущей дирректории");
                    } finally {
                        System.out.println(getCurrentInfo(filem.getCurrent()));
                        string=sc.next();
                    }
                    break;
                }
                case "append":{
                    System.out.println("Введите текст для добавления в текущий файл");
                    String text = sc.next();
                    try {
                        filem.append(text);
                    } catch (WriteToDirectoryException e) {
                        System.out.println("Дозапись возможна только в файл");
                    } catch (NotTextFileException e) {
                        System.out.println("Дозапись возможна только в текстовый файл");
                    } catch (CanNotWriteToFileException e) {
                        System.out.println("Редактирование текущего файла запрещено");
                    } finally {
                        System.out.println(getCurrentInfo(filem.getCurrent()));
                        string=sc.next();
                    }
                    break;
                }
                case "rewrite":{
                    System.out.println("Введите текст для записи в текущий файл");
                    String text = sc.next();
                    try {
                        filem.rewrite(text);
                    } catch (WriteToDirectoryException e) {
                        System.out.println("Запись возможна только в файл");
                    } catch (NotTextFileException e) {
                        System.out.println("Запись возможна только в текстовый файл");
                    } catch (CanNotWriteToFileException e) {
                        System.out.println("Редактирование текущего файла запрещено");
                    } finally {
                        System.out.println(getCurrentInfo(filem.getCurrent()));
                        string=sc.next();
                    }
                    break;
                }
                case "info":{
                    System.out.println(getCommandInfo());
                    System.out.println(getCurrentInfo(filem.getCurrent()));
                    string=sc.next();
                }
                default:{
                    System.out.println("Не верная команда");
                    System.out.println(getCurrentInfo(filem.getCurrent()));
                    string=sc.next();
                }
            }
        }
        sc.close();
    }

    private static String getCurrentInfo(File f){
        if (f.isFile()){
            return ("Текущий файл: "+f.getAbsolutePath()+"\nдля получения списка команд введите - info");
        }
        else return ("Текущий каталог: "+f.getAbsolutePath()+"\nдля получения списка команд введите - info");



    }

    private static String getCommandInfo(){
       return "для перехода по абсолютному пути - cd \nдля удаления текущего файла - delete\nдля дозаписи в текущий файл - append\n"+
                "для перезаписи текущего файла - rewrite\nдля перехода в дочерний каталог текущего файла - getch \n" +
                "для перехода в родительский каталог - parent \nдля созадния папки в текущей - createdir \n" +
                "для создания файла в текущей папке -createfile \nдля выхода из программы  - exit";
    }

    public static void main(String[] args) {
        FileManagerTextInterface.start();
    }
}
