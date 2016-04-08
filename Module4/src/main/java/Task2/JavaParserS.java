package Task2;


import Task1.KeywordCounter;
import java.io.*;
import java.util.HashMap;

/**
 * Created by Elizaveta on 08.04.2016.
 */
public class JavaParserS {
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
        HashMap<String, KeywordCounter> words = new HashMap<>();
        BufferedReader in =new BufferedReader(new FileReader(fin));
        while (in.ready()){
            String string=in.readLine();
            // сначала отделим //, /*, */,  пробелами от слов, а затем разобьём строку по пробельным символам = , ( ) ;
            String[] word =string.replaceAll("\\/\\/"," // ").replaceAll("\\/\\*"," /* ").
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
                                    if ((word[j].charAt(word[j].length() - 1) == '"')&&(word[j].charAt(word[j].length() - 2)!='\\')) quotes--;}
                                else  if (word[j].charAt(word[j].length() - 1) == '"') quotes--;}
                        } else {
                            if (word[j].contains("/*")) {
                                commentsCounter(word[j]);
                            } else {
                                if (word[j].charAt(0) == '"') {
                                    quotes++;
                                    if ((word[j].length()>1)&&(word[j].charAt(word[j].length() - 1)=='"')) quotes--;}
                                else {
                                    for (String keyword : keywords) {
                                        if (keyword.equals(word[j])) {
                                            if (words.containsKey(keyword)) words.get(keyword).incCount();
                                            else words.put(keyword, new KeywordCounter());}
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
        FileWriter out = new FileWriter(fout);
        for(String key:words.keySet()){
            out.write(key+" = "+words.get(key).getCount()+"\n");
        }

        out.close();
    }
    private static void commentsCounter(String s){
        comments++;
        if (s.contains("*/")) comments=0;
    }
}