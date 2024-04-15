package bai10StackandQueue.Optional.DecimalBinaryHexadecimal;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyStack {
    private LinkedList stack;
    public MyStack(){
        stack = new LinkedList<>();
    }
    public void push(int element){
        stack.addFirst(element);
    }
    public void pop(){
        if(stack.isEmpty()){
            throw new EmptyStackException();
        }
        stack.removeFirst();
    }
    public boolean isEmpty(){
        if(stack.size() == 0){
            return true;
        }
        return false;
    }

}
