package bai9DSA.baitap2;

public class MyLinkedList2<E> {

//    private Object data;

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    private Node head;
    private int numNodes;

    public MyLinkedList2(Object data) {
        head = new Node(data);
    }

    ;

    public void add(int index, E element) {
        Node temp = head;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        Node holder;
        holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(E e) {
        Node temp = head;
        head = new Node(e);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E e) {
        numNodes++;
        this.add(numNodes, e);
    }

    public E remove(int index) {
        Node temp = null;
        if (index >= 0 && index < numNodes ) {
            temp = head;
            for (int i = 0; i < index - 1 && temp.next != null; i++) {
                temp = temp.next;
            }
            if(index==numNodes-1){
                temp.next = null;
                numNodes--;
            }
            else {
                temp.next = temp.next.next;
                numNodes--;
            }
        }
        return (E) "No index found";
    }

    public void removeO(Object e) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp == e) {
                temp.next = temp.next.next;
                temp = temp.next;
                continue;
            } else if (temp.next == e) {
                temp.next = temp.next.next;
                temp = temp.next;
                continue;
            }
            temp = temp.next;
        }
    }

    public void getSize() {
        System.out.println(this.numNodes);
    }

    public boolean contains(E o) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            temp = temp.next;
            if (temp == o) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        Node temp = head;
        int index = -1;
        for (int i = 0; i < numNodes; i++) {
            if (temp == o) {
                index = i;
                break;
            }
            temp = temp.next;
        }
        return index;
    }
//    public boolean add(E e){
//
//    }
//    public void ensureCapacity(int minCapacity){
//
//    }
    public E get(int i) {
        Node temp = head;
        for (int k = 0; k < numNodes; k++) {
            if (k == i) {
                System.out.println(temp);
                break;
            }
            temp = temp.next;
        }
        final String s = "No index found";
        return (E) s;
    }
    public E getFirst(){
        return (E) this.head;
    }
    public E getLast(){
        Node temp = head;
        for(int i = 0; i<numNodes;i++){
            temp = temp.next;
        }
        return (E) temp;
    }
//    public void clear(){
//
//    }
    public void printList() {
    Node temp = head;
    while(temp != null) {
        System.out.println(temp.data);
        temp = temp.next;
        }
    }
}
