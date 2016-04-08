package Task3;

import java.io.*;

/**
 * Created by Elizaveta on 08.04.2016.
 */
public class FromUNF8ToUTF16 {
    public static void changeEncoding(File input, File output) throws IOException {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(input), "utf8"));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output), "utf16"))){
            while (in.ready()){
                out.write(in.readLine());
                out.newLine();
            }
        }
    }
}
