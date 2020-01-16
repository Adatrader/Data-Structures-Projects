import java.util.ArrayList;

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
public class RBTree extends Node{

    //Declarations
    ArrayList<Integer> numbersInts = new ArrayList<>();
    ArrayList<Integer> aToBInts = new ArrayList<>();
    public Node root;
    public Node EmptyTree;

    //Constructor
    public RBTree(){

        EmptyTree = new Node();
        EmptyTree.color = 0;
        EmptyTree.left = null;
        EmptyTree.right = null;
        root = EmptyTree;
    }

    //Copy Pasted!!!!!!!!
    //

    private void preOrderTraverse(Node node) {
        if (node != EmptyTree) {
            System.out.print(node.value + " ");
            preOrderTraverse(node.left);
            preOrderTraverse(node.right);
        }
    }

    private void inOrderTraverse(Node node) {
        if (node != EmptyTree) {
            inOrderTraverse(node.left);
            System.out.print(node.value + " ");
            inOrderTraverse(node.right);
        }
    }

    private void postOrderTraverse(Node node) {
        if (node != EmptyTree) {
            postOrderTraverse(node.left);
            postOrderTraverse(node.right);
            System.out.print(node.value + " ");
        }
    }


    // fix the rb tree modified by the delete operation
    private void fixDelete(Node x) {
        Node s;
        while (x != root && x.color == 0) {
            if (x == x.parent.left) {
                s = x.parent.right;
                if (s.color == 1) {
                    // case 3.1
                    s.color = 0;
                    x.parent.color = 1;
                    leftRotate(x.parent);
                    s = x.parent.right;
                }

                if (s.left.color == 0 && s.right.color == 0) {
                    // case 3.2
                    s.color = 1;
                    x = x.parent;
                } else {
                    if (s.right.color == 0) {
                        // case 3.3
                        s.left.color = 0;
                        s.color = 1;
                        rightRotate(s);
                        s = x.parent.right;
                    }

                    // case 3.4
                    s.color = x.parent.color;
                    x.parent.color = 0;
                    s.right.color = 0;
                    leftRotate(x.parent);
                    x = root;
                }
            } else {
                s = x.parent.left;
                if (s.color == 1) {
                    // case 3.1
                    s.color = 0;
                    x.parent.color = 1;
                    rightRotate(x.parent);
                    s = x.parent.left;
                }

                if (s.right.color == 0 && s.right.color == 0) {
                    // case 3.2
                    s.color = 1;
                    x = x.parent;
                } else {
                    if (s.left.color == 0) {
                        // case 3.3
                        s.right.color = 0;
                        s.color = 1;
                        leftRotate(s);
                        s = x.parent.left;
                    }

                    // case 3.4
                    s.color = x.parent.color;
                    x.parent.color = 0;
                    s.left.color = 0;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
        x.color = 0;
    }


    private void rbTransplant(Node u, Node v){
        if (u.parent == null) {
            root = v;
        } else if (u == u.parent.left){
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }

    private void deleteNode(Node node, int key) {
        // find the node containing key
        Node z = EmptyTree;
        Node x, y;
        while (node != EmptyTree){
            if (node.value == key) {
                z = node;
            }

            if (node.value <= key) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        if (z == EmptyTree) {
            System.out.println("Couldn't find key in the tree");
            return;
        }

        y = z;
        int yOriginalColor = y.color;
        if (z.left == EmptyTree) {
            x = z.right;
            rbTransplant(z, z.right);
        } else if (z.right == EmptyTree) {
            x = z.left;
            rbTransplant(z, z.left);
        } else {
            y = minimum(z.right);
            yOriginalColor = y.color;
            x = y.right;
            if (y.parent == z) {
                x.parent = y;
            } else {
                rbTransplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }

            rbTransplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        if (yOriginalColor == 0){
            fixDelete(x);
        }
    }

    // fix the red-black tree
    private void fixInsert(Node k){
        Node u;
        while (k.parent.color == 1) {
            if (k.parent == k.parent.parent.right) {
                u = k.parent.parent.left; // uncle
                if (u.color == 1) {
                    // case 3.1
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        // case 3.2.2
                        k = k.parent;
                        rightRotate(k);
                    }
                    // case 3.2.1
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    leftRotate(k.parent.parent);
                }
            } else {
                u = k.parent.parent.right; // uncle

                if (u.color == 1) {
                    // mirror case 3.1
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        // mirror case 3.2.2
                        k = k.parent;
                        leftRotate(k);
                    }
                    // mirror case 3.2.1
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    rightRotate(k.parent.parent);
                }
            }
            if (k == root) {
                break;
            }
        }
        root.color = 0;
    }




    // rotate left at node x
    public void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != EmptyTree) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    // rotate right at node x
    public void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != EmptyTree) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    // insert the key to the tree in its appropriate position
    // and fix the tree
    public void insert(int key) {
        // Ordinary Binary Search Insertion
        Node node = new Node();
        node.parent = null;
        node.value = key;
        node.left = EmptyTree;
        node.right = EmptyTree;
        node.color = 1; // new node must be red

        Node y = null;
        Node x = this.root;

        while (x != EmptyTree) {
            y = x;
            if (node.value < x.value) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        // y is parent of x
        node.parent = y;
        if (y == null) {
            root = node;
        } else if (node.value < y.value) {
            y.left = node;
        } else {
            y.right = node;
        }

        // if new node is a root node, simply return
        if (node.parent == null){
            node.color = 0;
            return;
        }

        // if the grandparent is null, simply return
        if (node.parent.parent == null) {
            return;
        }

        // Fix the tree
        fixInsert(node);
    }


    // find the node with the minimum key
    public Node minimum(Node node) {
        while (node.left != EmptyTree) {
            node = node.left;
        }
        return node;
    }



    public void removeTwenty(Node cNode) {

        preOrderTraverseTreeCustom(root);
        for (int j = 0; j < 20; j++) {
            deleteNode(root ,numbersInts.get(j));
        }
//        int newCount = countLeaf(cNode);
//        System.out.println("\n" + newCount);

        preOrderTraverse(cNode);

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
}
