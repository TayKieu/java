package bai10StackandQueue.Queue;

public class LinkedListQueue {
    public Node front;
    public Node rear;
    public LinkedListQueue(){
        this.front = null;
        this.rear = null;
    }
    public void enqueue(int data){
        Node temp = new Node(data);
        if(this.rear == null){
            this.front = this.rear = temp;
            return;
        }
        else {
            this.rear = temp;
            this.rear.link = temp;
        }
    }
    public Node dequeue(){
        if(this.front == null){
            return null;
        }
        Node temp = this.front;
        this.front = this.front.link;
        if(this.front == null){
            this.rear = null;
        }
        return temp;
    }
}
