package bai14DocGhiFile.DocFile;

import java.io.Serializable;

public class Nation implements Serializable {
    private static final long serialVersionUID = 1L;
    public int STT;
    public String shortName;
    public String name;
    public Nation(){}
    public Nation(int STT, String shortName, String name){
        this.STT = STT;
        this.shortName = shortName;
        this.name = name;
    }
    public Nation(String[] data){
        this.STT = Integer.parseInt(data[0]);
        this.shortName = data[1];
        this.name = data[2];
    }
    @Override
    public String toString() {
        return "Nation{" +
                "STT=" + STT +
                ", shortName='" + shortName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
