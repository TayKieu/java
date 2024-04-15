package bai14DocGhiFile.CopyFileText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Copy {
    public static void main(String[] args) {
        ArrayList<String> str = readFromFile("bai14DocGhiFile/CopyFileText/Nguon.txt");
        writeToFile("bai14DocGhiFile/CopyFileText/Dich.txt",str);

    }
    public static ArrayList<String> readFromFile (String path){
        ArrayList<String> list = new ArrayList<>();
        try{
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true){
                    line = br.readLine();
                    if(line == null){
                        break;
                    }
                    list.add(line);
                System.out.println(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public static void writeToFile(String path, ArrayList<String> strings){
            try{
                FileWriter fw = new FileWriter(path);
                BufferedWriter bw = new BufferedWriter(fw);
                for(String str :strings) {
                    bw.write(str);
                    bw.write("\n");
                }
                bw.flush();
            }
            catch (Exception e){
                e.printStackTrace();
            }
    }
}

