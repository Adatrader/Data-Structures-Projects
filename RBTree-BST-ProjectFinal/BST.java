/****************************************************************
 *      file: BST.java
 *      author: Adam VanRiper, Anthony Sepulveda, Ashley Kang
 *      class: CS 2400 - Data Structures and Algorithms
 *
 *      assignment: Program 6
 *      date last modified: 12/03/19
 *
 *      purpose: This program shows how to implement a Binary Search Tree &
 *      Red Black Tree. Manipulate the BST and RBTree using various methods.
 ****************************************************************/
import java.util.ArrayList;

    public class BST extends BinaryNode{
    BinaryNode root;
    static int successor, predecessor;
    ArrayList<Integer> numbersInts = new ArrayList<>();
    ArrayList<Integer> aToBInts = new ArrayList<>();


    //method: addHelper
    //purpose: this method goes through the process of adding
    // a value to our tree recursively.
    private int addHelper(BinaryNode passedN, int value) {
        assert passedN != null;
        int result = 0;
        if (value == passedN.value) {
            result = passedN.value;
            passedN.setBinaryNode(value);
        } else if (value < passedN.value) {
            if (passedN.left != null) {
                result = addHelper(passedN.left, value);
            } else {
                passedN.setLeft(new BinaryNode(value));
            }
        } else {
            assert value > passedN.value;
            if (passedN.right != null) {
                result = addHelper(passedN.right, value);
            } else {
                passedN.setRight(new BinaryNode(value));
            }
        }
        return result;
    }
        /**
         Method: deleteCheck
         Purpose: Before deleting value from tree, this helper method
         checks if the value is in tree.
         */
    public void deleteCheck(int value){
        preOrderTraverseTreeCustom(root);
        if(numbersInts.contains(value) == false){
            System.out.println(value + " doesn't exist in Binary Search tree. ");
            return;
        }
        else{
            deleteEntry(root, value);
            System.out.println(value + " has been removed from RBTree and BST. ");
        }
        numbersInts.clear();
    }
    //method: add
    //purpose: this is the method that the user's input goes
    //to first. Gives a BinaryNode to the value given and the sends
    //both to the insert method
    public int add(int value) {
        BinaryNode nBinaryNode = new BinaryNode(value);
        int result = 0;
        if (root == null) {
            root = (new BinaryNode(value));
            
        } else {
            result = addHelper(root, value);
        }
        if (value == result) {
            System.out.println(value + " already in BinarySearchTree, ignored.");
        }
        return result;
    }

    //method: deleteEntry
    //purpose: this method deletes a value and its BinaryNode through
    // a recursive process. 
    private BinaryNode deleteEntry(BinaryNode current, int value) {


        if (current == null) {
            return null;
        }
        if (value == current.value) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }

            int smallest = findSmallest(current.right);
            current.value = smallest;
            current.right = deleteEntry(current.right, smallest);
            return current;
        }
        if (value < current.value) {
            current.left = deleteEntry(current.left, value);
            return current;
        }
        current.right = deleteEntry(current.right, value);
        return current;
    }

    //method: findSmallest
    //purpose: if the value set to delete has two children, this
    //method finds the smallest value to replace the lost parent.
    private int findSmallest(BinaryNode root) {
        return root.left == null ? root.value : findSmallest(root.left);
    }

    //method: delete
    //purpose: this is the method that the user's input goes
    //to first. sets the focused BinaryNode as root and
    //sends it and the value to the deleteEntry method
    public void delete(int value) {
        root = deleteEntry(root, value);
    }

    //method: predecessorAndSuccessor
    //purpose: this method finds the predecessor and successor
    //to a value an in-order transversal. Static ints up top recieve
    //the values.
    public void predecessorAndSuccessor(BinaryNode root, int value) {
        if (root != null) {
            if (root.value == value) {
                if (root.left != null) {
                    BinaryNode temp = root.left;
                    while (temp.right != null) {
                        temp = temp.right;
                    }
                    predecessor = temp.value;
                }
                if (root.right != null) {
                    BinaryNode temp = root.right;
                    while (temp.left != null) {
                        temp = temp.left;
                    }
                    successor = temp.value;
                }
            } else if (root.value > value) {
                successor = root.value;
                predecessorAndSuccessor(root.left, value);
            } else if (root.value < value) {
                predecessor = root.value;
                predecessorAndSuccessor(root.right, value);
            }
        }
    }

    //method: preOrderTraverseTree
    //purpose: to traverse the tree through a pre-order fashion
    public void preOrderTraverseTree(BinaryNode passedN) {
        if (passedN != null) {
            System.out.print(" " + passedN.value);
            preOrderTraverseTree(passedN.left);
            preOrderTraverseTree(passedN.right);
        }
    }

    //method: inOrderTraverseTree
    //purpose: to traverse the tree through an in-order fashion
    public void inOrderTraverseTree(BinaryNode passedN) {
        if (passedN != null) {
            inOrderTraverseTree(passedN.left);
            System.out.print(" " + passedN.value);
            inOrderTraverseTree(passedN.right);
        }
    }

    //method: postOrderTraverseTree
    //purpose: to traverse the tree through a post-order fashion
    public void postOrderTraverse(BinaryNode passedN) {
        if (passedN != null) {
            postOrderTraverse(passedN.left);
            postOrderTraverse(passedN.right);
            System.out.print(" " + passedN.value);
        }
    }

        /**
         Method: countLeaf
         Purpose: Finds the number of leaves in tree, executes
         after the twenty removal.
         */
    public int countLeaf(BinaryNode BinaryNode) {
        if (BinaryNode == null) {
            return 0;
        }
        if (BinaryNode.left == null && BinaryNode.right == null) {
            return 1;
        } else {
            return countLeaf(BinaryNode.left) + countLeaf(BinaryNode.right);
        }
    }

        /**
         Method: removeTwenty
         Purpose: Remove the first twenty nodes in tree found in
         pre order traversal.
         */
    public void removeTwenty(BinaryNode passedN) {

        preOrderTraverseTreeCustom(root);
        for (int j = 0; j < 20; j++) {
            delete(numbersInts.get(j));
        }
        preOrderTraverseTree(passedN);
        numbersInts.clear();

    }

        /**
         Method: preOrderTraverseTreeCustom
         Purpose: Helper method to traverses through tree in order to
         add values in array list for twenty removal method.
         */
    public void preOrderTraverseTreeCustom(BinaryNode passedN) {
        if (passedN != null) {
            numbersInts.add(passedN.value);
            preOrderTraverseTreeCustom(passedN.left);
            preOrderTraverseTreeCustom(passedN.right);
        }
    }

        /**
         Method: inOrderTraverseTreeCustom
         Purpose: Helper method to traverses through tree in order to
         add values in array list for aToB method.
         */
    public void inOrderTraverseTreeCustom(BinaryNode passedN) {
        if (passedN != null) {
            inOrderTraverseTreeCustom(passedN.left);
            aToBInts.add(passedN.value);
            inOrderTraverseTreeCustom(passedN.right);
        }
    }
        /**
         Method: heightMethod
         Purpose: Method to find height of binary search
         tree.
         */
    public int heightMethod(BinaryNode passedN){
        if (passedN == null){
            return 0;
        }
        else{
            int leftD = heightMethod(passedN.left);
            int rightD = heightMethod(passedN.right);

            if (leftD > rightD)
                return (leftD + 1);
            else
                return (rightD + 1);
        }
    }

        /**
         Method: aToB
         Purpose: Finds the values in tree between two values
         given by user.
         */
    public void aToB(int aValue, int bValue){
        inOrderTraverseTreeCustom(root);

        int indexOfA, indexOfB;
        indexOfA = aToBInts.indexOf(aValue);
        indexOfB = aToBInts.indexOf(bValue);
        if(indexOfA == -1 || indexOfB == -1){
            System.out.print("Values out of range, start over!");
        }
        else if(indexOfA>indexOfB){
            int temp = indexOfA;
            indexOfA = indexOfB;
            indexOfB = temp;
        }
        else{
        for(int i = indexOfA; i<= indexOfB; i++) {
            System.out.print(" " + aToBInts.get(i));
        }
        }
        aToBInts.clear();
    }

}