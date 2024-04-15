package bai9DSA.baitap2;

public class MyLinkedListTest2 {
    public static void main(String[] args) {
        MyLinkedList2<Integer> llInt = new MyLinkedList2<Integer>(1);
        llInt.add(1,2);
        llInt.add(1,2);
        llInt.add(3,4);
        llInt.add(4,5);
        llInt.printList();
        System.out.println("===========");
        llInt.addFirst(0);
        llInt.addLast(6);
        llInt.printList();
        System.out.println("===========");
        llInt.contains(2);
        llInt.contains(4);
        llInt.getSize();
        llInt.indexOf(4);
        System.out.println("===========");
        llInt.removeO(5);
        llInt.remove(1);
        llInt.printList();
    }
}
