public class Queue<T extends Comparable<? super T>> {
    private final T[] arr;
    private int front;
    private int rear;
    private final int size;
    private int count;

    public Queue(int size) {
        arr = (T[])new Comparable[size];
        this.size = size;
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    public void enqueue(T val) {
        if (isFull()) {
            System.out.println("the queue is full");
        } else {
            System.out.println("inserted " + val + " value");
            rear = (rear + 1) % size;
            arr[rear] = val;
            count++;
        }
    }
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("the queue is empty");
            return null;
        }
        System.out.println("removed " + peek() + " value");
        T x = arr[front];
        front = (front + 1) % size;
        count--;
        return x;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        if (isFull()) {
            return arr[size - 1];
        }
        return arr[front];
    }

    public boolean isEmpty() {
        return (size() == 0);
    }

    public boolean isFull() {
        return (size() == size);
    }

    public int size() {
        return count;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("the queue is empty");
        } else {
            for (int i = 0 ;i < count ;i++) {
                System.out.println(arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<Integer>(6);
        boolean f = q.isEmpty();
        System.out.println(f);
        q.dequeue();
        q.enqueue(4);
        q.enqueue(4);
        q.enqueue(4);
        q.enqueue(4);
        q.enqueue(4);
        q.enqueue(4);
        q.printQueue();
        q.enqueue(4);
        q.dequeue();
        f = q.isFull();
        System.out.println(f);
        q.printQueue();
        int l = q.size();
        System.out.println(l);
    }
}