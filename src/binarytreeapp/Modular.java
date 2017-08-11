/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytreeapp;

import java.util.*;

/**
 *
 * @author Van Do
 */

public class Modular 
{
    // All methods must include scanner to allow user to input data
    private Scanner scan;
    // Initialise this object to access the methods from BinaryTree class
    private BinaryTree tree;
    // Initialise this object to access BinaryNode class
    private BinaryNode node;
    // Initialise this object to access Employee class
    private Employee data;
    // Initialise choice to enable to choose to keep running application
    private int choice;
    // This is for handling integer input error
    private int input;
    // Display options to edit binary tree
    public void selectOption()
    {
        // Initialise both scanner and binary tree objects
        // Delimit new line character to set string as the whole line input
        scan = new Scanner(System.in).useDelimiter("[\r\n]");
        tree = new BinaryTree();
        // Do this function while the user wants to keep using this app
        do
        {
            // Print out all options and choose options
            System.out.println(displayOption());
            int option = handleInt();
            // Use switch case to choose multiple options
            switch(option)
            {
                // If option 1, insert node
                case 1:
                    // Continue loop until find this id is not existed
                    int id = 0;
                    do
                    {
                        // Enter new employee's details
                        System.out.println("Enter new employee's ID.");
                        id = handleInt();
                        if(tree.find(id) != null)
                        {
                            System.out.println("ID is already exist.");
                        }
                    }
                    while(tree.find(id) != null);
                    System.out.println("Enter new employee's name.");
                    String name = scan.next();
                    System.out.println();
                    System.out.println("Enter new employee's email.");
                    String email = scan.next();
                    System.out.println();
                    int gender;
                    String genderChoice = null;
                    boolean hasGender = false;
                    // Continue while user has not select gender
                    do
                    {
                        System.out.println("Enter new employee's gender.");
                        System.out.println("Male (1)");
                        System.out.println("Female (2)");
                        gender = handleInt();
                        switch(gender)
                        {
                            case 1:
                                genderChoice = "Male";
                                hasGender = true;
                                break;
                            case 2:
                                genderChoice = "Female";
                                hasGender = true;
                                break;
                            default:
                                System.out.println("Invalid option.");
                                break;
                        }
                    }
                    while(!hasGender);
                    // Continue loop while age is less than 16
                    int age;
                    do
                    {
                        System.out.println("Enter new employee's age.");
                        age = handleInt();
                        if(age < 16)
                        {
                            System.out.println("Invalid age. Must be 16 or over.");
                        }
                    }
                    while(age < 16);
                    System.out.println("Enter new employee's status.");
                    String rank = scan.next();
                    System.out.println();
                    data = new Employee(name, email, genderChoice, age, rank);
                    tree.insert(id, data);
                    // Display details
                    System.out.println("Key ID: " + tree.find(id).getKey());
                    tree.find(id).getEmployee().printDetails();
                    break;
                // If option 2, delete node
                case 2:
                    System.out.println("Enter employee's key you want to delete.");
                    int key = handleInt();
                    // If enable to delete node, display message and tree as in preorder
                    if(tree.delete(key))
                    {
                        System.out.println("Employee ID: " + key + " has been removed.");
                        tree.preOrder(tree.getRoot());
                    }
                    else
                    {
                        // Else, display message that needs to check
                        System.out.println("Employee ID: " + key + " is not existed.");
                    }
                    break;
                // If option 3, display tree with nodes
                case 3:
                    // Select the choice to different view of details in different order
                    int chooseDisplay;
                    boolean hasSelected = false;
                    // Continue loop until selected
                    do
                    {
                        System.out.println("Choose the type of traversals for tree.");
                        System.out.println("1. Preorder");
                        System.out.println("2. Inorder");
                        System.out.println("3. Postorder");
                        chooseDisplay = handleInt();
                        switch(chooseDisplay)
                        {
                            case 1:
                                // Display preorder traversals
                                tree.preOrder(tree.getRoot());
                                hasSelected = true;
                                break;
                            case 2:
                                // Display inorder traversals
                                tree.inOrder(tree.getRoot());
                                hasSelected = true;
                                break;
                            case 3:
                                // Display postorder traversals
                                tree.postOrder(tree.getRoot());
                                hasSelected = true;
                                break;
                            default:
                                System.out.println("Invalid input");
                                break;
                        }
                    }
                    while(!hasSelected);
                    break;
                // If option 4, search for the node and display the details
                case 4:
                    System.out.println("Enter employee's key you want to view.");
                    int keyID = handleInt();
                    node = tree.find(keyID);
                    if(node != null)
                    {
                        // Display this node's details
                        System.out.println("Key " + keyID + " has been found.");
                        node.getEmployee().printDetails();
                    }
                    else
                    {
                        System.out.println("Key " + keyID + " is not existed.");
                    }
                    break;
                // If option 5, search for the node and change details
                case 5:
                    System.out.println("Enter employee's key you want to change.");
                    int keyChange = handleInt();
                    node = tree.find(keyChange);
                    if(node != null)
                    {
                        System.out.println("Key " + keyChange + " has been found.");
                        node.getEmployee().printDetails();
                        tree.changeEmployeeDetails(node);
                    }
                    else
                    {
                        System.out.println("Key " + keyChange + " is not existed.");
                    }
                    break;
                // Check the root of the tree
                case 6:
                    System.out.println("The root of the tree is Key " + tree.getRoot().getKey());
                    tree.getRoot().getEmployee().printDetails();
                    break;
                // Check the number of nodes in the tree
                case 7:
                    System.out.println("There are " + tree.count() + " employees now.");
                    break;
                // Else, display invalid input
                default:
                    System.out.println("Invalid input.");
                    break;
            }
            // Display this message if wanted to continue this app
            System.out.println("Do you want to continue? Yes (1) or No (Any number)");
            choice = handleInt();
        }
        while(choice == 1);
    }
    // Display all options
    public String displayOption()
    {
        // Build up the option easily without typing string in lengthy line
        StringBuilder option = new StringBuilder();
        // Append all string into one
        option.append("Select options.").append("\n");
        option.append("1. Insert Employee.").append("\n");
        option.append("2. Delete Employee.").append("\n");
        option.append("3. Display Tree.").append("\n");
        option.append("4. Search and Display Employee's Details.").append("\n");
        option.append("5. Search and Change Employee's Details.").append("\n");
        option.append("6. Check the Root of the Tree.").append("\n");
        option.append("7. Check Number of Employees.");
        // Display options
        return option.toString();
    }
    // Handle integer inputs
    public int handleInt()
    {
        // Assuming this continue in a loop until the user has entered the integer
        boolean loop = true;
        // Continue this loop until the user has entered the input correctly
        while(loop)
        {
            // Try and catch error if the user has not entered the integer
            try
            {
                input = scan.nextInt();
                System.out.println();
                loop = false;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Try again. Wrong input.");
                scan.nextLine();
            }
        }
        return input;
    }
}