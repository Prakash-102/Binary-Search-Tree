
//Search in a BST:-
import java.util.*;

public class SearchBST {

    static class Node {
        int data;
        Node Left;
        Node right;
        public SearchBST.Node left;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            // left subtree
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean Search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return Search(root.Left, key);
        } else {
            return Search(root.right, key);
        }
    }

    public static void main(String[] args) {
        int value[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;

        for (int i = 0; i < value.length; i++) {
            root = insert(root, value[i]);
        }
        inorder(root);
        System.out.println();
        if (Search(root, 7)) {
            System.out.println("found");
        } else {
            System.out.println("no found");
        }
    }
}

/*
 * Output:-
 * 1 2 3 4 5 7
 * found
 */
