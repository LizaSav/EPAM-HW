package Task1;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Elizaveta on 07.04.2016.
 */
public class JavaParser {/*fff/* kkk*/
    private static int comments=0; // при встрече /*  или */ увеличивается или уменьшается
    private static int quotes=0; // при встрече " увеличивается если они в начале слова или уменьшается если в конце
    private static final String[] keywords = {"abstract", "continue", "for", "new", "switch",
            "assert", "default", "goto", "package", "synchronized",
            "boolean", "do", "if", "private", "this",
            "break", "double", "implements", "protected", "throw",
            "byte", "else", "import", "public", "throws",
            "case", "enum", "instanceof", "return", "transient",
            "catch", "extends", "int", "short", "try",
            "char", "final", "interface", "static", "void",
            "class", "finally", "long", "strictfp", "volatile",
            "const", "float", "native", "super", "while"};
    public static void parse(File fin, File fout) throws IOException {
        HashMap <String, KeywordCounter> words = new HashMap<>();
        FileInputStream in =new FileInputStream(fin);
        byte[] bytes=new byte[in.available()];
        in.read(bytes); //плохо читать всё сразу
        in.close();
        String[] strings=(new String(bytes, Charset.forName("UTF-8" ))).split("\n");
        for(int i=0; i<strings.length; i++){
            // сначала отделим //, /*, */,  пробелами от слов, а затем разобьём строку по пробельным символам = , ( ) ;
            String[] word =strings[i].replaceAll("\\/\\/"," // ").replaceAll("\\/\\*"," /* ").
                    replaceAll("\\*\\/"," */ ").split("[\\s|\\(|=|,|\\)|;]");
            if(word.length>0) {
                for (int j = 0; j < word.length; j++) {
                    if (word[j].contains("//")) break; // дальше в строке только коментарии
                    if (word[j].length() > 0) {
                        if ((quotes > 0) || (comments > 0)) {
                            if (comments > 0) {
                                commentsCounter(word[j]);
                            } else {
                                if (word[j].length()>1) {
                                    if ((word[j].charAt(word[j].length() - 1) == '"')&&(word[j].charAt(word[j].length() - 2)!='\\')) quotes--;
                                }
                                else  if (word[j].charAt(word[j].length() - 1) == '"') quotes--;
                            }
                        } else {
                            if (word[j].contains("/*")) {
                                commentsCounter(word[j]);
                            } else {
                                if (word[j].charAt(0) == '"') {
                                    quotes++;
                                    if ((word[j].length()>1)&&(word[j].charAt(word[j].length() - 1)=='"')) quotes--;
                                }
                                else {
                                    for (String keyword : keywords) {
                                        if (keyword.equals(word[j])) {
                                            if (words.containsKey(keyword)) words.get(keyword).incCount();
                                            else words.put(keyword, new KeywordCounter());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        StringBuffer stringBuffer = new StringBuffer(words.size());
        for(String key:words.keySet()){
            stringBuffer.append(key+" = "+words.get(key).getCount()+"\n");
        }
        FileOutputStream out = new FileOutputStream(fout);
        bytes=stringBuffer.toString().getBytes();
        out.write(bytes);
        out.close();
    }
    private static void commentsCounter(String s){
       comments++;
       if (s.contains("*/")) comments=0;
    }
}
