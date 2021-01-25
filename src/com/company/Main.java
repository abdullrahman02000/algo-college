package com.company;

import java.util.Scanner;

public class Main {
    public static Scanner stdin = new Scanner(System.in);

    /*
    Linear Search function
     */

    public static int linearSearch(int[] arr, int value) {
        // Check if the array is valid
        if (arr==null || arr.length==0) return -1;
        // Loop through elements
        try {
            int i = 0;
            while (true) {
                // If you found the value, return the index
                if (arr[i]==value) return i;
                i++;
            }
        } catch (IndexOutOfBoundsException e) {}
        return -1;
    }

    /*
    binary search function
     */

    public static int binarySearch(int[] arr, int val, int begin, int end) {
        // Check if the array is valid
        if (arr==null || arr.length==0) return -1;
        // Check if the begin is valid
        if (begin<0) begin=0;
        // Check if the end is valid
        if (end>arr.length) end=arr.length;
        // Loop
        while (true) {
            // return -1 when the begin or end are out of bound
            try {
                // Calculate the mid point
                int mid = (begin + end) / 2;
                // If the value is greater than the value at mid point then it is on the right side
                if (val > arr[mid]) {
                    // Continue the loop with changing the begin
                    begin = mid + 1;
                    continue;
                } // If the value is lesser than the value at mid point then it is on the left side
                else if (val < arr[mid]) {
                    // Continue the loop with changing the end
                    end = mid - 1;
                    continue;
                } // If it is not on the left nor right then it is at mid point so return mid
                else return mid;
            } catch (IndexOutOfBoundsException e) { return -1; }
        }
    }

    /*
    Create the Binary Node class
     */

    public static class BNode {
        public char data;
        public BNode left;
        public BNode right;
        BNode(char data) { this.data = data; };
        BNode() {};
    }

    /*
    Insert binary search tree node function
     */
    public static void insert_bst(char value, BNode root) {
        try {
            if (value >= root.data) {
                if (root.right==null) {
                    root.right = new BNode(value);
                }
                else insert_bst(value, root.right);
            } else {
                if (root.left==null) {
                    root.left = new BNode(value);
                }
                else insert_bst(value, root.left);
            }
        } catch (NullPointerException e) {}
    }

    /*
    deleting node from binary search tree
     */
    public static BNode cloneNode(BNode node) {
        BNode ret;
        if (node!=null) {
            ret = new BNode(node.data);
            ret.left = cloneNode(node.left);
            ret.right = cloneNode(node.right);
            return ret;
        } else return null;
    }
    public static BNode deleteNode(char key, BNode root) {
        if (root==null) return null;
        BNode current = root;
        BNode parent = root;
        boolean isLeftChild = true;
        if (root.data!=key) {
            try {
                while (current.data != key) {
                    parent = current;
                    if (key >= current.data) {
                        isLeftChild = false;
                        current = current.right;
                    } else {
                        isLeftChild = true;
                        current = current.left;
                    }
                }
            } catch (NullPointerException e) {
                return null;
            }
        }
        if (root.data==key) {
            if (root.left==null && root.right==null) root=null;
            else if (root.left==null && root.right!=null) {
                root = root.right;
            } else if (root.right==null && root.left!=null) {
                root = root.left;
            } else if (root.right!=null && root.left!=null) {
                BNode successor = root.right;
                BNode parentSuccessor = root.right;
                try {
                    if (successor.left!=null)
                        successor = successor.left;
                    else throw new NullPointerException();
                    while (successor.left!=null) {
                        successor = successor.left;
                        parentSuccessor = parentSuccessor.left;
                    }
                } catch (NullPointerException e) { }
                if (successor!=parentSuccessor) {
                    parentSuccessor.left = successor.right;
                    successor.right = root.right;
                    successor.left = root.left;
                    root = successor;
                } else {
                    successor.left = root.left;
                    root = successor;
                }
            }
            return root;
        }
        else if (current.left==null && current.right==null) {
            if (isLeftChild) parent.left = null;
            else parent.right = null;
        } else if (current.left!=null && current.right==null) {
            if (isLeftChild) parent.left = current.left;
            else parent.right = current.left;
        } else if (current.right!=null && current.left==null) {
            if (isLeftChild) parent.right = current.right;
            else parent.left = current.right;
        } else if (isLeftChild) {
            BNode successor = current.right;
            BNode parentSuccessor = current.right;
            try {
                if (successor.left != null)
                    successor = successor.left;
                else throw  new NullPointerException();
                while (true) {
                    successor = successor.left;
                    parentSuccessor = parentSuccessor.left;
                }
            } catch (NullPointerException e) {}
            if (successor!=parentSuccessor) {
                parentSuccessor.left = successor.right;
                successor.left = current.left;
                successor.right = current.right;
                parent.left = successor;
            } else {
                successor.left = current.left;
                parent.left = successor;
            }
        } else {
            BNode predecessor = current.left;
            BNode parentPredecessor = current.left;
            try {
                if (predecessor.right!=null)
                predecessor = predecessor.right;
                else throw new NullPointerException();
                while (true) {
                    predecessor = predecessor.right;
                    parentPredecessor = parentPredecessor.right;
                }
            } catch (NullPointerException e) { }
            if (predecessor!=parentPredecessor) {
                parentPredecessor.right = predecessor.left;
                predecessor.left = current.left;
                predecessor.right = current.right;
                parent.right = predecessor;
            } else {
                predecessor.right = current.right;
                parent.right = predecessor;
            }
        }
        return root;
    }

    public static void main(String[] args) throws Exception {
        String str = Ops.inputString("some text");
        BNode root = new BNode(str.charAt(0));
        try {
            int i = 1;
            while (true) {
                insert_bst(str.charAt(i), root);
                i++;
            }
        } catch (IndexOutOfBoundsException e) {}
        Ops.printObject(root, "The resulted tree");
        // Input the deleted characrter
        char dc = Ops.inputChar("some character");
        root = deleteNode(dc, root);
        Ops.printObject(root,"tree after deleting node");
    }
}
