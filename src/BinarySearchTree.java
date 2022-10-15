public class BinarySearchTree<T extends Comparable<? super T>> {
    public Node<T> root;
    public static class Node<T> {
        public T data;
        public Node<T> left;
        public Node<T> right;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public boolean searchElement(T data) {
        Node<T> cur = root;
        while (cur != null) {
            if (data.compareTo(cur.data) > 0) {
                cur = cur.right;
            } else if (data.compareTo(cur.data) < 0) {
                cur = cur.left;
            } else {
                return true;
            }
        }
        return false;
    }

    public Node<T> getSubTree(T data) {
        Node<T> cur = root;
        while (cur != null) {
            if (data.compareTo(cur.data) > 0) {
                cur = cur.right;
            } else if (data.compareTo(cur.data) < 0) {
                cur = cur.left;
            } else {
                return cur;
            }
        }
        return null;
    }

    // incomplete
    public void setElement(T old_data, T new_data) {
        Node<T> cur = root;
        while (cur != null) {
            cur = cur.right;
        }
    }

    public void insertNode(T data) {
        if (root == null) {
            root = new Node<T>(data);
        } else {
            Node<T> cur = root;
            boolean done = false;
            while (!done) {
                if (data.compareTo(cur.data) > 0) {
                    if (cur.right == null) {
                        cur.right = new Node<T>(data);
                        done = true;
                    } else {
                        cur = cur.right;
                    }
                } else if (data.compareTo(cur.data) < 0) {
                    if (cur.left == null) {
                        cur.left = new Node<T>(data);
                        done = true;
                    } else {
                        cur = cur.left;
                    }
                }
            }
        }
    }

    public Node<T> insertNodeRec(Node<T> root, T data) {
        if (root == null) {
            root = new Node<T>(data);
            return root;
        } else {
            if (data.compareTo(root.data) < 0) {
                root.left = insertNodeRec(root.left, data);
            } else if (data.compareTo(root.data) > 0) {
                root.right = insertNodeRec(root.right, data);
            }
            return root;
        }
    }

    public void insertNodeRecCall(T data){
        root = insertNodeRec(root ,data);
    }

    public Node<T> deleteNodeRec(Node<T> root, T data) {
        if (root == null) {
            return root;
        } else {
            if (data.compareTo(root.data) < 0) {
                root.left = deleteNodeRec(root.left, data);
            } else if (data.compareTo(root.data) > 0) {
                root.right = deleteNodeRec(root.right, data);
            } else {
                if (root.right == null) {
                    return root.left;
                } else if (root.left == null) {
                    return root.right;
                }
            }
            return root;
        }
    }

    public void deleteNodeRecCall(T data){
        root = deleteNodeRec(root ,data);
    }

    public int getHeightTree(Node<T> root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeightTree(root.left),getHeightTree(root.right));
    }

    public void getHeightTreeCall() {
        System.out.println("height tree: " + getHeightTree(root));
    }

    public int getNumValues(Node<T> root) {
        if (root == null) {
            return 0;
        }
        return 1 + getNumValues(root.left) + getNumValues(root.right);
    }

    public void getNumValuesCall() {
        System.out.println("number values: " + getNumValues(root));
    }

    public void preorderPrint(Node<T> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + ", ");
        preorderPrint(root.left);
        preorderPrint(root.right);
    }

    public void preorderPrintCall() {
        System.out.print("preorder: ");
        preorderPrint(root);
        System.out.println();
    }

    public void inorderPrint(Node<T> root) {
        if (root == null) {
            return;
        }
        inorderPrint(root.left);
        System.out.print(root.data + ", ");
        inorderPrint(root.right);
    }

    public void inorderPrintCall() {
        System.out.print("inorder: ");
        inorderPrint(root);
        System.out.println();
    }

    public void postorderPrint(Node<T> root) {
        if (root == null) {
            return;
        }
        postorderPrint(root.left);
        postorderPrint(root.right);
        System.out.print(root.data + ", ");
    }

    public void postorderPrintCall() {
        System.out.print("postorder: ");
        postorderPrint(root);
        System.out.println();
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insertNodeRecCall(6);
        tree.insertNodeRecCall(3);
        tree.insertNodeRecCall(8);
        tree.insertNodeRecCall(15);
        tree.insertNodeRecCall(12);
        tree.insertNodeRecCall(2);
        tree.insertNodeRecCall(4);
        tree.inorderPrintCall();
        tree.deleteNodeRecCall(2);
        tree.deleteNodeRecCall(8);
        tree.deleteNodeRecCall(13);
        tree.inorderPrintCall();
        tree.getHeightTreeCall();
        tree.getNumValuesCall();
        boolean flag = tree.searchElement(7);
        System.out.println(flag);
    }
}
