/****************************************************************
 *      file: Driver.java
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
public class Driver {

    public static void main(String[] args) {
        Scanner scrn = new Scanner(System.in);
        BST BST = new BST();
        RBTree RB = new RBTree();
        long totalRBTrav = 0, totalBSTTrav = 0, totalBSTAdd = 0, totalRBAdd = 0, totalBSTBetween = 0, totalRBCount = 0;
        long totalRBDelete = 0, totalBSTDelete =0, totalBSTRmTwenty = 0, totalRBRmTwenty = 0, totalBSTCount = 0;
        long endBSTBetween = 0, startBSTBetween = 0, startRBBetween = 0, endRBBetween = 0, totalRBBetween = 0;

        //Create random numbers and add them to arrayList
        ArrayList<Integer> randNums = new ArrayList<>();
        for (int f = 1; f < 501; f++) {
            randNums.add(f);
        }
        Collections.shuffle(randNums);

        //Convert to int array
        int[] intNums = new int[100];
        for (int p = 0; p < intNums.length; p++) {
            intNums[p] = randNums.get(p);
        }
        for (int i = 0; i < intNums.length; i++) {
            BST.add(intNums[i]);
            RB.add(intNums[i]);
        }

        //Menu with try catch statements to verify correct inputs from user
        //Executes required methods in BinarySearchTree class
        boolean startLoop = true;
        while (startLoop) {
            System.out.println("\nP Print Trees (inOrderTraverse)\nI Insert a value \nD Delete a value\nC Count of the leaves" +
                    "\nL Listing of all the values between a to b\nR Remove first 20 values in tree\nM Display menu\nA Efficiency Check\nE Exit the program\n");
            System.out.print("Enter your selection: ");
            char input = scrn.next().charAt(0);
            switch (input) {
                case 'P':
                    long startRBTrav = System.nanoTime();

                    System.out.println("Red Black Tree:");
                    RB.inOrderTraverse(RB.root);
                    long endRBTrav = System.nanoTime();
                    totalRBTrav = (endRBTrav-startRBTrav);

                    long startBSTTrav = System.nanoTime();
                    System.out.println("\nBinary Search Tree:");
                    BST.inOrderTraverseTree(BST.root);
                    long endBSTTrav = System.nanoTime();
                    totalBSTTrav = (endBSTTrav-startBSTTrav);
                    System.out.println("");
                    break;
                case 'M':
                    break;

                case 'I':
                    try {
                        System.out.println("Enter a value to add:");
                        int temp = scrn.nextInt();
                        long startBSTAdd = System.nanoTime();
                        BST.add(temp);
                        long endBSTAdd = System.nanoTime();
                        totalBSTAdd = (endBSTAdd-startBSTAdd);

                        long startRBAdd = System.nanoTime();
                        RB.insertCheck(temp);
                        long endRBAdd = System.nanoTime();
                        totalRBAdd = (endRBAdd-startRBAdd);
                    } catch (InputMismatchException e) {
                        System.out.println("Not a correct value.");
                    }
                    break;

                case 'D':
                    try {
                        System.out.println("Enter a value to remove:");
                        int temp = scrn.nextInt();
                        long startBSTDelete = System.nanoTime();
                        BST.deleteCheck(temp);
                        long endBSTDelete = System.nanoTime();
                        totalBSTDelete = (endBSTDelete-startBSTDelete);

                        long startRBDelete = System.nanoTime();
                        RB.remove(RB.root, temp);
                        long endRBDelete = System.nanoTime();
                        totalRBDelete = (endRBDelete-startRBDelete);
                    } catch (InputMismatchException e) {
                        System.out.println("Not a correct value.");
                    }
                    break;

                case 'R':
                    System.out.println("\nRemoving First 20 values from trees");
                    System.out.println("----------------------------------");
                    System.out.println("Binary Search Tree:");

                    long startBSTRmTwenty = System.nanoTime();
                    BST.removeTwenty(BST.root);
                    System.out.print("\nLeaves after removal: ");
                    System.out.println(BST.countLeaf(BST.root));
                    System.out.print("Height after removal: ");
                    System.out.println(BST.heightMethod(BST.root));
                    long endBSTRmTwenty = System.nanoTime();
                    totalBSTRmTwenty = (endBSTRmTwenty-startBSTRmTwenty);
                    System.out.println("\nRed Black Tree:");

                    long startRBRmTwenty = System.nanoTime();
                    RB.removeTwenty(RB.root);
                    System.out.print("\nLeaves after removal: ");
                    RB.getLeafCount(RB.root);
                    System.out.println(RB.countLeaf/2+2);
                    System.out.print("Height after removal: ");
                    RB.height(RB.root);
                    RB.countLeaf = 0;
                    long endRBRmTwenty = System.nanoTime();
                    totalRBRmTwenty = (endRBRmTwenty-startRBRmTwenty);
                    System.out.println(RB.counterHeight);
                    RB.counterHeight = 0;
                    break;

                case 'C':
                    System.out.print("\nCount of the Binary Search Tree Leaves: ");
                    long startBSTCount = System.nanoTime();
                    System.out.print(BST.countLeaf(BST.root));
                    long endBSTCount = System.nanoTime();
                    totalBSTCount = (endBSTCount-startBSTCount);

                    System.out.print("\nCount of the Red Black Tree Leaves: ");
                    long startRBCount = System.nanoTime();
                    RB.getLeafCount(RB.root);
                    System.out.println(RB.countLeaf/2+2);
                    long endRBCount = System.nanoTime();
                    totalRBCount = (endRBCount-startRBCount);
                    RB.countLeaf =0;
                    break;

                case 'L':
                    System.out.print("\nBinary Search Tree:\n");
                    BST.inOrderTraverseTree(BST.root);
                    System.out.print("\nRed Black Tree:\n");
                    RB.inOrderTraverse(RB.root);
                    System.out.println("\n---------------------------------");
                    System.out.println("Pick two values from above to find the range between them: (Printed using inOrderTraversal)");
                    System.out.print("Lower Bound Selection = ");
                    int a = scrn.nextInt();
                    System.out.print("Upper Bound Selection = ");
                    int b = scrn.nextInt();
                    if (a > b) {
                        System.out.println("\nSwapping, bounds are backwards!");
                        int temp = b;
                        b = a;
                        a = temp;
                        System.out.print("\nPrinting both using inOrderTraversal:");
                        System.out.println("\nBinary Search Tree from " + a + " to " + b + ":");
                        startBSTBetween = System.nanoTime();
                        BST.aToB(a, b);
                        endBSTBetween = System.nanoTime();
                        totalBSTBetween = (endBSTBetween-startBSTBetween);

                        System.out.println("\nRed Black Tree from " + a + " to " + b + ":");
                        startRBBetween = System.nanoTime();
                        RB.aToB(a, b);
                        endRBBetween = System.nanoTime();
                        totalRBBetween = (endRBBetween-startRBBetween);

                        System.out.println(" ");
                    } else {
                        System.out.println("\nPrinting both using inOrderTraversal");
                        System.out.println("Binary Search Tree from " + a + " to " + b + ":");
                        startBSTBetween = System.nanoTime();
                        BST.aToB(a, b);
                        endBSTBetween = System.nanoTime();
                        totalBSTBetween = (endBSTBetween-startBSTBetween);
                        System.out.println("\nRed Black Tree from " + a + " to " + b + ":");
                        startRBBetween = System.nanoTime();
                        RB.aToB(a, b);
                        endRBBetween = System.nanoTime();
                        totalRBBetween = (endRBBetween-startRBBetween);
                        System.out.println(" ");

                    }
                    break;

                case 'E':
                    startLoop = false;
                    break;

                case 'A':
                    System.out.println("\nEfficiency Check (in nanoseconds)");
                    System.out.println("-----------------");
                    System.out.println("If values are 0, execute corresponding method and try again.");

                    System.out.println("\nTraversals:");
                    System.out.println("BST Time Elasped: " + totalBSTTrav);
                    System.out.println("RBTree Time Elasped: " + totalRBTrav +"\n");

                    System.out.println("Adding Values:");
                    System.out.println("BST Time Elasped: " + totalBSTAdd);
                    System.out.println("RBTree Time Elasped: " + totalRBAdd + "\n");

                    System.out.println("Count:");
                    System.out.println("BST Time Elasped: " + totalBSTCount);
                    System.out.println("RBTree Time Elasped: " + totalRBCount +"\n");

                    System.out.println("Deleting Values:");
                    System.out.println("BST Time Elasped: " + totalBSTDelete);
                    System.out.println("RBTree Time Elasped: " + totalRBDelete +"\n");

                    System.out.println("Remove Twenty:");
                    System.out.println("BST Time Elasped: " + totalBSTRmTwenty);
                    System.out.println("RBTree Time Elasped: " + totalRBRmTwenty +"\n");

                    System.out.println("Between two Values:");
                    System.out.println("BST Time Elasped: " + totalBSTBetween);
                    System.out.println("RBTree Time Elasped: " + totalRBBetween +"\n");

                    break;

                default:
                    System.out.println("Incorrect value, try again:");
            }

        }
    }
}