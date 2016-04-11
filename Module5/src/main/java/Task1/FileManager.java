package Task1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

/**
 * Created by Elizaveta on 09.04.2016.
 */
public class FileManager {
    private File current;
    private static String[] textFormat={"txt", "java"};
    public FileManager()  {
        current = File.listRoots()[0];
    }


    public void toFile(String path) throws FileDoesNotExistException {
        File nfile= new File(path);
        if (!nfile.exists()) throw new FileDoesNotExistException();
        else current=nfile;

    }
    public File getCurrent(){
        return current;
    }

    public void toPreviousDirectory() throws RootDirectoryParentException {
        if (current.getParentFile()==null) throw new RootDirectoryParentException();
        else current=current.getParentFile();
    }

    public void toChildDirectory(String child) throws FileDoesNotExistException {
        File nfile= new File(current, child);
        if (!nfile.exists()) throw new FileDoesNotExistException();
        else current=nfile;
    }

    public void append(String text) throws WriteToDirectoryException, NotTextFileException, CanNotWriteToFileException {
        if (current.isFile()) {
            if (!accept()) {
                throw new NotTextFileException();
            } else {
                if (!current.canWrite()) throw new CanNotWriteToFileException();
                else {
                    try (FileWriter out = new FileWriter(current, true)) {
                        out.write(text);
                    } catch (IOException e) {
                        System.err.println("Запись не удалась");
                    }
                }
            }
        }
        else throw new WriteToDirectoryException();
    }

    public  void rewrite(String text) throws WriteToDirectoryException, NotTextFileException, CanNotWriteToFileException {
        if (current.isFile()) {
            if (!accept()) {
                throw new NotTextFileException();
            } else {
                if (!current.canWrite()) throw new CanNotWriteToFileException();
                else {
                    try (FileWriter out = new FileWriter(current)) {
                        out.write(text);
                    } catch (IOException e) {
                        System.err.println("Дозапись не удалась");
                    }
                }
            }
        }
        else throw new WriteToDirectoryException();
    }

    public void createDir(String name) throws WriteToDirectoryException, FileAlreadyExistsException {
        if(current.isDirectory()) {
            String[] children = current.list();
            for (String child : children) {
                if (child.equals(name)) throw new FileAlreadyExistsException(name);
            }
            File file = new File(current, name);
            boolean created  = file.mkdir();
            if (!created) System.err.println("Не удалось создать файл");
        }else throw new WriteToDirectoryException();
    }


    public void createFile(String name) throws FileAlreadyExistsException, WriteToDirectoryException {
        if(current.isDirectory()) {
            String[] children = current.list();
            for (String child : children) {
                if (child.equals(name)) throw new FileAlreadyExistsException(name);
            }
            File file = new File(current, name);
            boolean created = false;
            try {
                created = file.createNewFile();
            } catch (IOException e) {
                System.err.println("Не удалось создать файл");
            }
            if (!created) System.err.println("Не удалось создать файл");
        }else throw new WriteToDirectoryException();
    }

    public void delete() throws AttemptToDeleteDirectoryException, NotTextFileException {
        if(current.isFile()){
            File nfile= current.getParentFile();
            if(accept()){
                if(current.delete())current=nfile;
                else System.err.println("Не удалось удалить файл");
            }else throw new NotTextFileException();
        }
        else throw  new AttemptToDeleteDirectoryException();
    }
    private boolean accept() {
        String filename = current.getPath();
        int i = filename.lastIndexOf('.');
        if ( i>0 && i<filename.length()-1 ) {
            String extension=filename.substring(i+1).toLowerCase();
             for (String ext:textFormat) {
                 if (ext.equals(extension))return true;
            }
        }
        return false;
    }
}
