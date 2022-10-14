import org.w3c.dom.Node;

public class main {
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
