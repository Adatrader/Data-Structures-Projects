/****************************************************************
 *      file: RBTree.java
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
public class RBTree extends BinaryNode{

    //Declarations
    BinaryNode root;
    private BinaryNode eTree; //Null
    ArrayList<Integer> numbersInts = new ArrayList<>();
    ArrayList<Integer> aToBInts = new ArrayList<>();
    public int counterHeight = 1;
    int countLeaf = 0;

    //Constructor
    public RBTree(){

        eTree = new BinaryNode();
        eTree.color = 0;
        eTree.left = null;
        eTree.right = null;
        root = eTree;
    }

   //Traversals

    /**
     Method: preOrderTraverse
     Purpose: Traverses through tree pre order.
     */
    public void preOrderTraverse(BinaryNode passedN) {
        if (passedN != eTree) {
            System.out.print(" " + passedN.value);
            preOrderTraverse(passedN.left);
            preOrderTraverse(passedN.right);
        }
    }

    /**
     Method: inOrderTraverse
     Purpose: Traverses through tree in order.
     */
    public void inOrderTraverse(BinaryNode passedN) {
        if (passedN != eTree) {
            inOrderTraverse(passedN.left);
            System.out.print(" " + passedN.value);
            inOrderTraverse(passedN.right);
        }
    }
    /**
     Method: postOrderTraverse
     Purpose: Traverses through tree post order.
     */
    public void postOrderTraverse(BinaryNode passedN) {
        if (passedN != eTree) {
            postOrderTraverse(passedN.left);
            postOrderTraverse(passedN.right);
            System.out.print(" " + passedN.value);
        }
    }

    //Helper Traversals for remove and aToB
    /**
     Method: preOrderTraverseTreeCustom
     Purpose: Helper method to traverses through tree in order to
     add values in array list for twenty removal method.
     */
    public void preOrderTraverseTreeCustom(BinaryNode passedN) {
        if (passedN != eTree) {
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
        if (passedN != eTree) {
            inOrderTraverseTreeCustom(passedN.left);
            aToBInts.add(passedN.value);
            inOrderTraverseTreeCustom(passedN.right);
        }
    }

    //Helpers
    /**
     Method: minimum
     Purpose: Finds minimum node in tree.
     */
    public BinaryNode minimum(BinaryNode BinaryNode) {
        while (BinaryNode.left != eTree) {
            BinaryNode = BinaryNode.left;
        }
        return BinaryNode;
    }

    /**
     Method: height
     Purpose: Increases counter height to find height of tree.
     */
    public BinaryNode height(BinaryNode BinaryNode) {
        while (BinaryNode.right != eTree) {
            counterHeight++;
            BinaryNode = BinaryNode.right;
        }
        return BinaryNode;
    }

    /**
     Method: delRepair
     Purpose: Fixes the red black tree after a removal of a
     node has occurred.
     */
    public void delRepair(BinaryNode passed) {
        BinaryNode temp;
        while (passed != root && passed.color == 0) {
            if (passed == passed.parent.left) {
                temp = passed.parent.right;
                if (temp.color == 1) {
                    temp.color = 0;
                    passed.parent.color = 1;
                    rotateLeft(passed.parent);
                    temp = passed.parent.right;
                }

                if (temp.left.color == 0 && temp.right.color == 0) {
                    temp.color = 1;
                    passed = passed.parent;
                } else {
                    if (temp.right.color == 0) {
                        temp.left.color = 0;
                        temp.color = 1;
                        rotateRight(temp);
                        temp = passed.parent.right;
                    }
                    temp.color = passed.parent.color;
                    passed.parent.color = 0;
                    temp.right.color = 0;
                    rotateLeft(passed.parent);
                    passed = root;
                }
            } else {
                temp = passed.parent.left;
                if (temp.color == 1) {
                    temp.color = 0;
                    passed.parent.color = 1;
                    rotateRight(passed.parent);
                    temp = passed.parent.left;
                }
                if (temp.right.color == 0 && temp.right.color == 0) {
                    temp.color = 1;
                    passed = passed.parent;
                } else {
                    if (temp.left.color == 0) {
                        temp.right.color = 0;
                        temp.color = 1;
                        rotateLeft(temp);
                        temp = passed.parent.left;
                    }
                    temp.color = passed.parent.color;
                    passed.parent.color = 0;
                    temp.left.color = 0;
                    rotateRight(passed.parent);
                    passed = root;
                }}}
        passed.color = 0;
    }

    /**
     Method: rotateRight
     Purpose: Executes a right rotation between nodes in tree.
     */
    public void rotateRight(BinaryNode passed) {
        BinaryNode temp = passed.left;
        passed.left = temp.right;
        if (temp.right != eTree) {
            temp.right.parent = passed;
        }
        temp.parent = passed.parent;
        if (passed.parent == null) {
            this.root = temp;
        } else if (passed == passed.parent.right) {
            passed.parent.right = temp;
        } else {
            passed.parent.left = temp;
        }
        temp.right = passed;
        passed.parent = temp;
    }

    /**
     Method: rotateLeft
     Purpose: Executes a left rotation between nodes in tree.
     */
    public void rotateLeft(BinaryNode passed) {
        BinaryNode temp = passed.right;
        passed.right = temp.left;
        if (temp.left != eTree) {
            temp.left.parent = passed;
        }
        temp.parent = passed.parent;
        if (passed.parent == null) {
            this.root = temp;
        } else if (passed == passed.parent.left) {
            passed.parent.left = temp;
        } else {
            passed.parent.right = temp;
        }
        temp.left = passed;
        passed.parent = temp;
    }

    /**
     Method: addRepair
     Purpose: Fixes the red black tree after an insertion of a
     node has occurred.
     */
    public void addRepair(BinaryNode passed){
        BinaryNode temp;
        while (passed.parent.color == 1) {
            if (passed.parent == passed.parent.parent.right) {
                temp = passed.parent.parent.left;
                if (temp.color == 1) {
                    temp.color = 0;
                    passed.parent.color = 0;
                    passed.parent.parent.color = 1;
                    passed = passed.parent.parent;
                } else {
                    if (passed == passed.parent.left) {
                        passed = passed.parent;
                        rotateRight(passed);
                    }
                    passed.parent.color = 0;
                    passed.parent.parent.color = 1;
                    rotateLeft(passed.parent.parent);
                }
            } else {
                temp = passed.parent.parent.right;
                if (temp.color == 1) {
                    temp.color = 0;
                    passed.parent.color = 0;
                    passed.parent.parent.color = 1;
                    passed = passed.parent.parent;
                } else {
                    if (passed == passed.parent.right) {
                        passed = passed.parent;
                        rotateLeft(passed);
                    }
                    passed.parent.color = 0;
                    passed.parent.parent.color = 1;
                    rotateRight(passed.parent.parent);
                }}
            if (passed == root) {
                break;
            }}
        root.color = 0;
    }

    //Main Methods
    /**
     Method: RedBlackSwap
     Purpose: Swaps colors between two nodes in tree.
     */
    private void RedBlackSwap(BinaryNode first, BinaryNode second){
        if (first.parent == null) {
            root = second;
        } else if (first == first.parent.left){
            first.parent.left = second;
        } else {
            first.parent.right = second;
        }
        second.parent = first.parent;
    }

    /**
     Method: removeTwenty
     Purpose: Remove the first twenty nodes in tree found in
     pre order traversal.
     */
    public void removeTwenty(BinaryNode passedN) {

        preOrderTraverseTreeCustom(root);
        for (int j = 0; j < 20; j++) {
            remove(root ,numbersInts.get(j));
        }
        preOrderTraverse(root);
        numbersInts.clear();
    }

    /**
     Method: insertCheck
     Purpose: Before adding value to tree, this helper method
     checks if the value is already in tree.
     */
    public void insertCheck(int value){
        preOrderTraverseTreeCustom(root);
        if(numbersInts.contains(value) == true){
            System.out.println(value + " already exists in Red Black tree, ignored. ");
        }
        else{
            add(value);
            System.out.println(value + " has been added to RBTree and BST. ");
        }
    }

    /**
     Method: getLeafCount
     Purpose: Finds the number of leaves in tree, executes
     after the twenty removal.
     */
    public int getLeafCount(BinaryNode passedN)
    {
        if (passedN == null) {
            return 0;
        }
        if (passedN.left == null && passedN.right == null) {
            return 1;
        } else {
            countLeaf++;
            return getLeafCount(passedN.left) + getLeafCount(passedN.right);
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

    /**
     Method: remove
     Purpose: Removes the node from tree from the given value
     by user and executes the deletion repair method.
     */
    public void remove(BinaryNode nodePassed, int value) {
        BinaryNode temp = eTree;
        BinaryNode oneN, twoN;
        while (nodePassed != eTree){
            if (nodePassed.value == value) {
                temp = nodePassed;
            }
            if (nodePassed.value <= value) {
                nodePassed = nodePassed.right;
            } else {
                nodePassed = nodePassed.left;
            }}
        if (temp == eTree) {
            System.out.println( value + " doesn't exist in Red Black tree.");
            return;
        }
        twoN = temp;
        int ogClr = twoN.color;
        if (temp.left == eTree) {
            oneN = temp.right;
            RedBlackSwap(temp, temp.right);
        } else if (temp.right == eTree) {
            oneN = temp.left;
            RedBlackSwap(temp, temp.left);
        } else {
            twoN = minimum(temp.right);
            ogClr = twoN.color;
            oneN = twoN.right;
            if (twoN.parent == temp) {
                oneN.parent = twoN;
            } else {
                RedBlackSwap(twoN, twoN.right);
                twoN.right = temp.right;
                twoN.right.parent = twoN;
            }
            RedBlackSwap(temp, twoN);
            twoN.left = temp.left;
            twoN.left.parent = twoN;
            twoN.color = temp.color;
        }
        if (ogClr == 0){
            delRepair(oneN);
        }
    }

    /**
     Method: add
     Purpose: Adds a node from tree from the given value
     by user and executes the add repair method.
     */
    public void add(int value) {
        BinaryNode oneN = null;
        BinaryNode twoN = this.root;
        BinaryNode newN = new BinaryNode();
        newN.parent = null;
        newN.value = value;
        newN.left = eTree;
        newN.right = eTree;
        newN.color = 1;

        while (twoN != eTree) {
            oneN = twoN;
            if (newN.value < twoN.value) {
                twoN = twoN.left;
            } else {
                twoN = twoN.right;
            }
        }
        newN.parent = oneN;
        if (oneN == null) {
            root = newN;
        } else if (newN.value < oneN.value) {
            oneN.left = newN;
        } else {
            oneN.right = newN;
        }
        if (newN.parent == null){
            newN.color = 0;
            return; }
        if (newN.parent.parent == null) {
            return;
        }
        addRepair(newN);
    }
}