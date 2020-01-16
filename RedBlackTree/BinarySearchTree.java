/****************************************************************
 *      file: BinarySearchTree.java
 *      author: Adam VanRiper
 *      class: CS 2400 - Data Structures and Algorithms
 *
 *      assignment: Program 4
 *      date last modified: 11/11/19
 *
 *      purpose: This program shows how to implement a Binary Search Tree
 *      and how to manipulate the Binary Search Tree using various methods.
 ****************************************************************/

public class BinarySearchTree<T extends Comparable<? super T>>
        extends BinaryNode<T>
        implements SearchTreeInterface<T>
{
    //Declarations
    BinaryNode<T> rootNode;
    static int scrs;
    static int pdcr;

    //Constructors
    public BinarySearchTree(){
        super();
        rootNode= null;
    }
    public BinarySearchTree(T rootEntry){
        super();
        rootNode = new BinaryNode<>(rootEntry);
    }

    //Methods
    /**
     Method: getRootNode
     Purpose: Identifies the root node
     @return The root node */
    @Override
    public BinaryNode<T> getRootNode() {
        return rootNode;
    }

    /**
     Method: display
     Purpose: Displays the binary root tree
     @param root given
     @return null */
    @Override
    public void display(BinaryNode root) {
        if (root != null) {
            display(root.left);
            System.out.print(" " + root.data);
            display(root.right);
        }
    }

    /**
     Method: add
     Purpose: Add a new entry to the tree, if it doesn't match object
     already in tree. If it does exist, replace it.
     @param data An object to be added to tree
     @return Null if newEntry wasn't in tree or the existing entry if
     it is already there. */
    @Override
    public BinaryNode<T> add(BinaryNode<T> active, T data) {
        int passed =Integer.parseInt(String.valueOf(data));
        if (active == null) {
            return new BinaryNode(data);
        }

        int currentData =Integer.parseInt(String.valueOf(active.data));

        if (passed < currentData) {
            active.left = add(active.left, data);

        } else if (passed > currentData) {
            active.right = add(active.right, data);
        } else {
            while(passed != 1) {
                System.out.println(passed + " already exists, ignore.");
                break;
            }
            return active;
        }

        return active;

    }

    /**
     Method: remove
     Purpose: Removes a specific entry from tree.
     @param data An object to be removed.
     @return Object that was removed or null if not in tree. */
    @Override
    public BinaryNode<T> remove(BinaryNode<T> active, T data) {
        //T generic into int
        int passed = Integer.parseInt(String.valueOf(data));
        if (null == active) {
            System.out.println("Value not in binary search tree");
            return null;
        }
        //T generic into int to compare values
        int currentData = Integer.parseInt(String.valueOf(active.data));
        if (passed < currentData) {
            active.left = remove(active.left, data);

        } else if (passed > currentData) {
            active.right = remove(active.right, data);
        } else {

            if (active.left != null && active.right != null) {

                //Using helper method below to convert object into T data type
                Object test = findMin(active.right);
                T rightMin = objectToT(test);
                active.data = rightMin;
                active.right = remove(active.right, rightMin);
            } else {

                if (active.left == null && active.right == null) {
                    active = null;
                } else {
                    BinaryNode nodeD = active;
                    if (active.left != null)
                        active = active.left;
                    else active = active.right;
                    nodeD = null;
                }
            }
        }
        return active;
    }

    /**
     Method: findNode
     Purpose: Retrieves a specific entry in this tree.
     @param dataToFind & rootNode
     @return The object to be found or null if not there. */
    @Override
    public BinaryNode<T> findNode(int dataToFind, BinaryNode<T> root){

        //Convert root data to int
        int passed =Integer.parseInt(String.valueOf(root.getData()));

        if (root==null || passed==dataToFind)
            return root;

        else if(passed>dataToFind)

            return findNode(dataToFind, root.getLeftChild());
        else
            return findNode(dataToFind, root.getRightChild());
    }

    /**
     Method: predecessSuccess
     Purpose: Finds the predecessor or successor of a given value
     @param val given
     @return null because successor/ predecessor ints are initialized in BST */
    @Override
    public void predecessSuccess(BinaryNode root, int val) {
        //Convert root data to int
        int passed =Integer.parseInt(String.valueOf(root.getData()));
        if (root != null) {
            if (passed == val) {

                if (root.left != null) {
                    BinaryNode temp = root.left;
                    while (temp.right != null) {
                        temp = temp.right;
                    }
                    //set integer value for predecessor using node data
                    pdcr = Integer.parseInt(String.valueOf(temp.data));
                }
                if (root.right != null) {

                    BinaryNode temp2 = root.right;
                    while (temp2.left != null) {
                        temp2 = temp2.left;
                    }
                    //set integer value for successor using node data
                    scrs = Integer.parseInt(String.valueOf(temp2.data));
                }
            } else if (passed > val) {

                //set integer value for successor using node data
                scrs = Integer.parseInt(String.valueOf(rootNode.data));
                predecessSuccess(root.left, val);
            } else if (passed < val) {

                //set integer value for predecessor using node data
                pdcr = Integer.parseInt(String.valueOf(rootNode.data));
                predecessSuccess(root.right, val);
            }
        }
    }

    //Helper Methods
    /**
     Method: findMax
     Purpose: Retrieves the max entry in tree.
     @param rtNode
     @return The max object to be found. */
    @Override
    public BinaryNode<T> findMax(BinaryNode<T> rtNode) {
        while (rtNode.right != null) {
            rtNode = rtNode.right;
        }
        return rtNode;
    }

    /**
     Method: findMin
     Purpose: Retrieves the min entry in tree.
     @param rtNode
     @return The min object to be found. */
    @Override
    public T findMin(BinaryNode rtNode) {
        if (rtNode.left == null) {
            T value = objectToT(rtNode.data);

            return value;
        }
        return findMin(rtNode.left);
    }

    /**
     (Static method needs body in interface)
     Method: objectToT
     Purpose: Converts object node to T data type
     @param passed
     @return T value */
    public static <T> T objectToT(Object passed) {
        try {
            return (T) passed;
        } catch (ClassCastException e) {
            return null;
        }
    }

    //Traversal Methods:
    /**
     Method: preOrderTrav
     Purpose: Traverses and prints the tree in preOrder method.
     @param rtNode
     @return null */
    @Override
    public void preOrderTrav(BinaryNode<T> rtNode) {
        if (rtNode != null) {
            System.out.print(" " + rtNode.data);
            preOrderTrav(rtNode.left);
            preOrderTrav(rtNode.right);
        }
    }

    /**
     Method: inOrderTrav
     Purpose: Traverses and prints the tree in inOrder method.
     @param rtNode
     @return null */
    @Override
    public void inOrderTrav(BinaryNode<T> rtNode) {
        if (rtNode != null) {
            inOrderTrav(rtNode.left);
            System.out.print(" " + rtNode.data);
            inOrderTrav(rtNode.right);
        }
    }

    /**
     Method: postOrderTrav
     Purpose: Traverses and prints the tree in postOrder method.
     @param rtNode
     @return null */
    @Override
    public void postOrderTrav(BinaryNode<T> rtNode) {
        if (rtNode != null) {
            postOrderTrav(rtNode.left);
            postOrderTrav(rtNode.right);
            System.out.print(" " + rtNode.data);
        }
    }



}



