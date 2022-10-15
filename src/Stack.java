public class Stack<T extends Comparable<? super T>> {
    private final T[] arr;
    private final int size;
    private int count;

    public Stack(int size) {
        arr = (T[])new Comparable[size];
        this.size = size;
        this.count = 0;
    }

    public void push(T val) {
        if (isFull()) {
            System.out.println("the stack is full");
        } else {
            System.out.println("inserted " + val + " value");
            arr[count] = val;
            count++;
        }
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("the stack is empty");
            return null;
        }
        System.out.println("removed " + peek() + " value");
        count--;
        return arr[count];
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        if (isFull()) {
            return arr[size - 1];
        }
        return arr[count - 1];
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

    public void printStack() {
        if (isEmpty()) {
            System.out.println("the stack is empty");
        } else {
            for (int i = 0 ;i < count ;i++) {
                System.out.println(arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>(6);
        boolean f = s.isEmpty();
        System.out.println(f);
        s.pop();
        s.push(4);
        s.push(4);
        s.push(4);
        s.push(4);
        s.push(4);
        s.push(4);
        s.printStack();
        s.push(4);
        s.pop();
        f = s.isFull();
        System.out.println(f);
        s.printStack();
        int l = s.size();
        System.out.println(l);
    }
}