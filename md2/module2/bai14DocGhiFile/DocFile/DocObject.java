package bai14DocGhiFile.DocFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DocObject {
    public static final String blank = "";
    public static void main(String[] args) {
        String path = "bai14DocGhiFile/DocFile/list";
       readObjectFromFile(path).forEach(System.out::println);
    }

    public static List<Nation> readObjectFromFile(String path) {
        List<Nation> list = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = "";
            while ((line = br.readLine()) != null){

                if(line.trim().equals(blank)){
                    continue;
                }
                //Chia mảng Nation thành nhiều mảng con khi gặp dấu ','
                String[] subArray = line.split(",");
                Nation nation = new Nation(subArray);
                list.add(nation);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }
}
