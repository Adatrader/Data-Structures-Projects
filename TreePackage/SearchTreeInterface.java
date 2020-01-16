/****************************************************************
 *      file: SearchTreeInterface.java
 *      author: Adam VanRiper
 *      class: CS 2400 - Data Structures and Algorithms
 *
 *      assignment: Program 4
 *      date last modified: 11/11/19
 *
 *      purpose: This program shows how to implement a Binary Search Tree
 *      and how to manipulate the Binary Search Tree using various methods.
 ****************************************************************/

public interface SearchTreeInterface<T extends Comparable<? super T>>{


    /**
     Method: getRootNode
     Purpose: Identifies the root node
     @return The root node */
    BinaryNode<T> getRootNode();

    /**
     Method: display
     Purpose: Displays the binary root tree
     @param root given
     @return null */
    void display(BinaryNode root);

    /**
     Method: findNode
     Purpose: Retrieves a specific entry in this tree.
     @param dataToFind & rootNode
     @return The object to be found or null if not there. */
    BinaryNode<T> findNode(int dataToFind, BinaryNode<T> root);

    /**
     Method: add
     Purpose: Add a new entry to the tree, if it doesn't match object
     already in tree. If it does exist, replace it.
     @param data An object to be added to tree
     @return Null if newEntry wasn't in tree or the existing entry if
     it is already there. */
    BinaryNode<T> add(BinaryNode<T> active, T data);

    /**
     Method: remove
     Purpose: Removes a specific entry from tree.
     @param data An object to be removed.
     @return Object that was removed or null if not in tree. */
    BinaryNode<T> remove(BinaryNode<T> current, T data);

    /**
     Method: predecessSuccess
     Purpose: Finds the predecessor or successor of a given value
     @param val given
     @return null because successor/ predecessor ints are initialized in BST */
    void predecessSuccess(BinaryNode root, int val);

    /**
     Method: findMax
     Purpose: Retrieves the max entry in tree.
     @param rtNode
     @return The max object to be found. */
    BinaryNode<T> findMax(BinaryNode<T> rtNode);

    /**
     Method: findMin
     Purpose: Retrieves the min entry in tree.
     @param rtNode
     @return The min object to be found. */
    T findMin(BinaryNode rtNode);

    /**
     Method: preOrderTrav
     Purpose: Traverses and prints the tree in preOrder method.
     @param rtNode
     @return null */
    void preOrderTrav(BinaryNode<T> rtNode);

    /**
     Method: inOrderTrav
     Purpose: Traverses and prints the tree in inOrder method.
     @param rtNode
     @return null */
    void inOrderTrav(BinaryNode<T> rtNode);

    /**
     Method: postOrderTrav
     Purpose: Traverses and prints the tree in postOrder method.
     @param rtNode
     @return null */
    void postOrderTrav(BinaryNode<T> rtNode);

    /**
     (Static method needs body in interface)
     Method: objectToT
     Purpose: Converts object node to T data type
     @param passed
     @return T value */
    static <T> T objectToT(Object passed){
            try {
        return (T) passed;
    } catch (ClassCastException e) {
        return null;
    }



}
}
