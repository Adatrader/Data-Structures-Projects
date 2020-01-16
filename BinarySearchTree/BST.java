/****************************************************************
 *      file: BinarySearchTree.java
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

    public class BST extends Node{
    Node root;
    static int successor, predecessor;
    ArrayList<Integer> numbersInts = new ArrayList<>();
    ArrayList<Integer> aToBInts = new ArrayList<>();


    //method: insert
    //purpose: this method goes through the process of adding
    // a value to our tree recursively.
    private int insert(Node cNode, int value) {
        assert cNode != null;
        int result = 0;
        if (value == cNode.value) {
            result = cNode.value;
            cNode.setNode(value);
        } else if (value < cNode.value) {
            if (cNode.left != null) {
                result = insert(cNode.left, value);
            } else {
                cNode.setLeft(new Node(value));
            }
        } else {
            assert value > cNode.value;
            if (cNode.right != null) {
                result = insert(cNode.right, value);
            } else {
                cNode.setRight(new Node(value));
            }
        }
        return result;
    }

    //method: add
    //purpose: this is the method that the user's input goes
    //to first. Gives a node to the value given and the sends
    //both to the insert method
    public int add(int value) {
        Node nNode = new Node(value);
        int result = 0;
        if (root == null) {
            root = (new Node(value));
        } else {
            result = insert(root, value);
        }
        if (value == result) {
            System.out.println(value + " already exists, ignore");
        }
        return result;
    }

    //method: deleteEntry
    //purpose: this method deletes a value and its node through
    // a recursive process. 
    private Node deleteEntry(Node current, int value) {
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
    private int findSmallest(Node root) {
        return root.left == null ? root.value : findSmallest(root.left);
    }

    //method: delete
    //purpose: this is the method that the user's input goes
    //to first. sets the focused node as root and
    //sends it and the value to the deleteEntry method
    public void delete(int value) {
        root = deleteEntry(root, value);
    }

    //method: predecessorAndSuccessor
    //purpose: this method finds the predecessor and successor
    //to a value an in-order transversal. Static ints up top recieve
    //the values.
    public void predecessorAndSuccessor(Node root, int value) {
        if (root != null) {
            if (root.value == value) {
                if (root.left != null) {
                    Node temp = root.left;
                    while (temp.right != null) {
                        temp = temp.right;
                    }
                    predecessor = temp.value;
                }
                if (root.right != null) {
                    Node temp = root.right;
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
    public void preOrderTraverseTree(Node cNode) {
        if (cNode != null) {
            System.out.print(" " + cNode.value);
            preOrderTraverseTree(cNode.left);
            preOrderTraverseTree(cNode.right);
        }
    }

    //method: inOrderTraverseTree
    //purpose: to traverse the tree through an in-order fashion
    public void inOrderTraverseTree(Node cNode) {
        if (cNode != null) {
            inOrderTraverseTree(cNode.left);
            System.out.print(" " + cNode.value);
            inOrderTraverseTree(cNode.right);
        }
    }

    //method: postOrderTraverseTree
    //purpose: to traverse the tree through a post-order fashion
    public void postOrderTraverse(Node cNode) {
        if (cNode != null) {
            postOrderTraverse(cNode.left);
            postOrderTraverse(cNode.right);
            System.out.print(" " + cNode.value);
        }
    }

    public int countLeaf(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        } else {
            return countLeaf(node.left) + countLeaf(node.right);
        }
    }


    public void removeTwenty(Node cNode) {

        preOrderTraverseTreeCustom(root);
        for (int j = 0; j < 20; j++) {
            delete(numbersInts.get(j));
        }
        int newCount = countLeaf(cNode);
//        System.out.println("\n" + newCount);

        preOrderTraverseTree(cNode);

    }


    public void preOrderTraverseTreeCustom(Node cNode) {
        if (cNode != null) {
            numbersInts.add(cNode.value);
            preOrderTraverseTreeCustom(cNode.left);
            preOrderTraverseTreeCustom(cNode.right);
        }
    }

    public void inOrderTraverseTreeCustom(Node cNode) {
        if (cNode != null) {
            inOrderTraverseTreeCustom(cNode.left);
            aToBInts.add(cNode.value);
            inOrderTraverseTreeCustom(cNode.right);
        }
    }

    public void aToB(int aValue, int bValue){
        inOrderTraverseTreeCustom(root);

        int indexOfA, indexOfB;
        indexOfA = aToBInts.indexOf(aValue);
        indexOfB = aToBInts.indexOf(bValue);
        if(indexOfA == -1 || indexOfB == -1){
            System.out.print("Values out of range, start over!");
        }
        for(int i = indexOfA; i<= indexOfB; i++){
            System.out.print(" " + aToBInts.get(i));
        }
    }

        int heightMethod(Node passed) {
            if (passed == null) {
                return -1; }
            int lt = heightMethod(passed.left);
            int rt = heightMethod(passed.right);

            if (lt > rt) {
                return lt + 1;
            } else {
                return rt + 1;
            }
        }

}