public class LinkedList<T extends Comparable<? super T>> {
    private Node<T> head;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean findElement(T data) {
        Node<T> cur = head;
        while (cur != null) {
            if (cur.data == data) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public T getElement(int index) {
        int count = 0;
        Node<T> cur = head;
        while (cur != null) {
            if (count == index) {
                return cur.data;
            }
            cur = cur.next;
            count++;
        }
        return null;
    }

    public void setElement(int index, T data) {
        int count = 0;
        Node<T> cur = head;
        while (cur != null) {
            if (count == index) {
                cur.data = data;
                break;
            }
            cur = cur.next;
            count++;
        }
    }

    public void insertNode(T data) {
        Node<T> new_node = new Node<T>(data);
        if (head == null) {
            head = new_node;
        } else {
            Node<T> tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = new_node;
        }
    }

    public void deleteNode(T data) {
        Node<T> cur = head, prev = null;
        if (cur != null && cur.data == data) {
            head = cur.next;
            return;
        }
        while (cur != null && cur.data != data) {
            prev = cur;
            cur = cur.next;
        }
        if (cur == null) {
            return;
        }
        prev.next = cur.next;
    }

    public void sortList() {
        Node<T> cur_i = head;
        while (cur_i != null) {
            Node<T> cur_j = cur_i.next;
            while (cur_j != null) {
                if (cur_i.data.compareTo(cur_j.data) > 0) {
                    T temp = cur_i.data;
                    cur_i.data = cur_j.data;
                    cur_j.data = temp;
                }
                cur_j = cur_j.next;
            }
            cur_i = cur_i.next;
        }
    }

    public void printList() {
        Node<T> cur = head;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.insertNode(5);
        l.insertNode(3);
        l.insertNode(4);
        l.insertNode(2);
        l.insertNode(7);
        l.insertNode(1);
        l.insertNode(6);
        l.sortList();
        l.printList();
        l.setElement(2,8);
        l.printList();
    }
}
