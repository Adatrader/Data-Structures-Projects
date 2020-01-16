/****************************************************************
 *      file: DriverProgram.java
 *      author: Adam VanRiper
 *      class: CS 2400 - Data Structures and Algorithms
 *
 *      assignment: Program 4
 *      date last modified: 11/11/19
 *
 *      purpose: This program shows how to implement a Binary Search Tree
 *      and how to manipulate the Binary Search Tree using various methods.
 ****************************************************************/

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
public class DriverClass {

    public static void main(String[] args) {
        Scanner scrn = new Scanner(System.in);
        BinarySearchTree BST = new BinarySearchTree<>(1);
        RBTree rB = new RBTree<>();

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
            BST.add(BST.rootNode, intNums[i]);

        }

        //Print using the 3 Traversal Methods
        System.out.print("PreOrder: ");
        BST.preOrderTrav(BST.rootNode);
        System.out.print("\nInOrder: ");
        BST.inOrderTrav(BST.rootNode);
        System.out.print("\nPostOrder: ");
        BST.postOrderTrav(BST.rootNode);

        //Menu with try catch statements to verify correct inputs from user
        //Executes required methods in BinarySearchTree class
        boolean startLoop = true;
        while (startLoop) {

            System.out.println("\n\nCommand? (Type H to display menu)");
            char input = scrn.next().charAt(0);
            switch (input) {
                case 'H':
                    System.out.println("I Insert a value \nD Delete a value\nP Find a predecessor" +
                            "\nS Find successor\nE Exit the program\nH Display this message");
                    break;

                case 'I':
                    try {
                        System.out.println("Enter a value to add:");
                        int temp = scrn.nextInt();
                        BST.add(BST.rootNode, temp);
                        BST.inOrderTrav(BST.rootNode);
                    } catch (InputMismatchException e) {
                        System.out.println("Not a correct value.");
                    }
                    break;

                case 'D':
                    try {
                        System.out.println("Enter a value to remove:");
                        int temp = scrn.nextInt();
                        BST.remove(BST.rootNode, temp);
                        BST.inOrderTrav(BST.rootNode);
                    } catch (InputMismatchException e) {
                        System.out.println("Not a correct value.");
                    }
                    break;

                case 'P':
                    try {
                        System.out.println("Enter a value to the predecessor of:");
                        int temp = scrn.nextInt();
                        BST.predecessSuccess(BST.rootNode, temp);
                        System.out.println(BST.pdcr);
                    } catch (InputMismatchException | NullPointerException e) {
                        System.out.println("Not a correct value.");
                    }
                    break;

                case 'S':
                    try {
                        System.out.println("Enter a value to the successor of:");
                        int temp = scrn.nextInt();
                        BST.predecessSuccess(BST.rootNode, temp);
                        System.out.println(BST.scrs);
                    } catch (InputMismatchException | NullPointerException e) {
                        System.out.println("Not a correct value.");
                    }
                    break;

                case 'E':
                    startLoop = false;
                    break;

                default:
                    System.out.println("Incorrect value, try again.");
            }

        }
    }
}