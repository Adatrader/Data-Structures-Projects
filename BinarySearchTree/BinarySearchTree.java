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
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
public class BinarySearchTree {

    public static void main(String[] args) {
Scanner scrn = new Scanner(System.in);
         BST BST = new BST();
         RBTree RBTree = new RBTree();

            //Create random numbers and add them to arrayList
            ArrayList<Integer> randNums = new ArrayList<>();
            for (int f = 1; f < 101; f++) {
                randNums.add(f);
            }
            Collections.shuffle(randNums);

        //Convert to int array
        int[] intNums = new int[100];
        for (int p = 0; p < intNums.length; p++) {
            intNums[p] = randNums.get(p);
        }
        for (int i = 0; i<intNums.length; i++){
            BST.add(intNums[i]);

        }
        //Menu with try catch statements to verify correct inputs from user
        //Executes required methods in BinarySearchTree class
        boolean startLoop = true;
        while (startLoop) {
            System.out.println("\nI Insert a value \nD Delete a value\nC Count of the leaves" +
                    "\nL Listing of all the values between a to b\nR Remove first 20 values in tree\nM Display menu\nE Exit the program\n");
            System.out.print("Enter your selection: ");
            char input = scrn.next().charAt(0);
            switch (input) {
                case 'M':
                    break;

                case 'I':
                    try {
                        System.out.println("Enter a value to add:");
                        int temp = scrn.nextInt();
                        BST.add(temp);
                        BST.inOrderTraverseTree(BST.root);
                        System.out.println("");
                    } catch (InputMismatchException e) {
                        System.out.println("Not a correct value.");
                    }
                    break;

                case 'D':
                    try {
                        System.out.println("Enter a value to remove:");
                        int temp = scrn.nextInt();
                        BST.delete(temp);
                        BST.inOrderTraverseTree(BST.root);
                    } catch (InputMismatchException e) {
                        System.out.println("Not a correct value.");
                    }
                    break;

                case 'R':
                    System.out.println("\nRemoving First 20 values from trees");
                    System.out.println("----------------------------------");
                    System.out.println("Binary Search Tree:");
                    BST.removeTwenty(BST.root);
                    System.out.print("\nLeaves after removal: ");
                    System.out.println(BST.countLeaf(BST.root));
                    System.out.print("Height after removal: ");
                    System.out.println(BST.heightMethod(BST.root));
                    System.out.println("\nRed Black Tree:");
                    RBTree.removeTwenty(RBTree.root);
//                    System.out.print("Leaves after removal: ");
//                    System.out.println(RBTree.countLeaf(RBTree.root));
//                    System.out.print("Height after removal: ");
//                    System.out.println(BST.heightMethod(RBTree.root));
                    break;

                case 'C':
                    System.out.print("\nCount of the Binary Search Tree Leaves: ");
                    System.out.print(BST.countLeaf(BST.root));
                    System.out.println("\nCount of the Red Black Tree Leaves: ");
//                    System.out.print(RBTree.countLeaf(RBTree.root));
                    break;

                case 'L':
                    System.out.println("Please enter the two numbers to find the range of values between them: ");
                    System.out.print("Lower Bound = ");
                    int a = scrn.nextInt();
                    System.out.print("Upper Bound = ");
                    int b = scrn.nextInt();
                    if(a>b){
                        System.out.println("Swapping, bounds are backwards!");
                        int temp = b;
                        b = a;
                        a = temp;
                        System.out.println("Binary Search Tree from " + a + " to " + b + ":");
                        BST.aToB(a, b);
                        System.out.println("Red Black Tree from " + a + " to " + b + ":");
                        RBTree.aToB(a,b);
                    }
                    else {
                        BST.aToB(a, b);
                        RBTree.aToB(a,b);
                    }
                    break;

                case 'E':
                    startLoop = false;
                    break;

                default:
                    System.out.println("Incorrect value, try again:");
            }

        }
    }
}
