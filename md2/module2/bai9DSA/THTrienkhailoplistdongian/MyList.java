package bai9DSA.THTrienkhailoplistdongian;

import java.util.Arrays;

public class MyList <E>{
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList(){
        elements = new Object[DEFAULT_CAPACITY];
    }
    public void add(E e){
        if(size == elements.length){
            ensureCapa();
        }
        elements[size++]= e;
    }
    public void ensureCapa(){
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements,newSize);
    }
    public E get(int i){
        if(i < 0 || i>=size){
            System.out.println("Out of elements");
        }
        return (E) elements[i];
    }

}
