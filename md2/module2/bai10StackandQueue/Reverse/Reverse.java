package bai10StackandQueue.Reverse;

public class Reverse {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        int array [] = {1,2,3,4,5};
        for(int i =0; i<array.length;i++){
            stack.push(array[i]);
        }
        for(int i = 0; i< array.length;i++){
            array[i] = stack.pop();
        }
        for (int i =0; i< array.length;i++){
            System.out.println(array[i]);
        }
    }
}
