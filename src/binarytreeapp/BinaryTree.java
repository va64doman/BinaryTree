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

public class BinaryTree 
{
    // The root of the binary tree
    private BinaryNode root;
    // The number of nodes in binary tree
    private int noOfNodes;
    // Input and scan are used for changing employee's details
    private int input;
    private Scanner scan;
    // Null constructor
    public BinaryTree()
    {
        root = null;
        noOfNodes = 0;
    }
    // Check if tree is empty
    public boolean isEmpty()
    {
        return root == null;
    }
    // Return root of binary tree
    public BinaryNode getRoot()
    {
        return root;
    }
    // Return number of nodes
    public int count()
    {
        return noOfNodes;
    }
    // Return replacing node
    public BinaryNode getReplacementNode(BinaryNode node)
    {
        // The replacement parent node, replacement node and current node
        BinaryNode replaceParent, replace, current;
        // Both replaceParent and replace are the parameter from this method
        replaceParent = node;
        replace = node;
        // The current node is the replacing node's right child
        current = node.getRight();
        // While there are no more children node
        while(current != null)
        {
            // Set the replacement parent as replace child
            replaceParent = replace;
            // Set replace child as current node
            replace = current;
            // Set current as current's left child
            current = current.getLeft();
        }
        // If replace isn't right child, move replacement into the parents
        // Left child slot and move the replaced nodes
        // Right child into the replacement node's right child
        if(replace != node.getRight())
        {
            // Set replacing parent's left child as replace's right child
            replaceParent.setLeft(replace.getRight());
            // Set replace's right child as parameter's right child
            replace.setRight(node.getRight());
        }
        // Return replacing node
        return replace;
    }
    // Insert employee's data and key id to node
    public void insert(int key, Employee data)
    {
        // Temporarily node is the new node
        // Current node is the comparing node
        // Parent node is the node to check if greater or less than by key
        BinaryNode temp, current, parent;
        // If tree is empty, set as root and increment number of nodes by 1
        if(root == null)
        {
            temp = new BinaryNode(key, data);
            root = temp;
            noOfNodes++;
        }
        else
        {
            // If tree is not empty, compare the parent node if greater or less than from this node
            temp = new BinaryNode(key, data);
            // Set current node as root node to initialise comparing
            current = root;
            // Loop never ends
            while(true)
            {
                // Set parent node as current node to compare the parent
                parent = current;
                // If the input key is less than parent, go left of the tree
                if(key < parent.getKey())
                {
                    // Set current to the left node of the previous node
                    current = current.getLeft();
                    // If this node is null, set the parent node's left child
                    // as the new node for temp and increment noOfNodes by 1
                    if(current == null)
                    {
                        parent.setLeft(temp);
                        noOfNodes++;
                        // Escape the loop
                        return;
                    }
                }
                else
                {
                    // If input key is greater than parent, go right of the tree
                    // Set current to the right node of the previous node
                    current = current.getRight();
                    // Same as left except insert as right child of parent node
                    if(current == null)
                    {
                        parent.setRight(temp);
                        noOfNodes++;
                        // Escape the loop
                        return;
                    }
                }
            }
        }        
    }
    // Delete node
    public boolean delete(int key)
    {
        // Current node is the comparing node
        // Parent node is the node to check if greater or less than by key
        BinaryNode current, parent;
        // Check if the key is less than parent node
        boolean isLeft = true;
        // Set both current and parent as root node
        current = root;
        parent = root;
        // Continue loop until the current key was matched by user's key
        while(current.getKey() != key)
        {
            // Parent node is equal to current node
            parent = current;
            // If key is less than current key, check the left child node
            if(key < current.getKey())
            {
                isLeft = true;
                current = current.getLeft();
            }
            else
            {
                // Else, check the right child node
                isLeft = false;
                current = current.getRight();
            }
            // If current node is empty, return failed to delete as non-existed
            if(current == null)
            {
                return false;
            }
        }
        // If no children delete node
        if(current.getLeft() == null && current.getRight() == null)
        {
            // If current is root node, make left child root node
            if(current == root)
            {
                root = null;
            }
            else if(isLeft)
            {
                // Else, check if key is left of parent node
                // Check if key is left
                // Set parent's left node as current's right child node
                parent.setLeft(null);
            }
            else
            {
                // Otherwise, set parent's right node as current's right child node
                parent.setRight(null);
            }
        }
        else if(current.getRight() == null)
        {
            // If no right child replaced with left subtree
            // If current is root node, set root as current's left child node
            if(current == root)
            {
                root = current.getLeft();
            }
            else if(isLeft)
            {
                // Else, check if key is left of parent node
                // Check if key is left
                // Set parent's left node as current's left child node
                parent.setLeft(current.getLeft());
            }
            else
            {
                // Otherwise, set parent's right node as current's left child node
                parent.setRight(current.getLeft());
            }
        }
        else if(current.getLeft() == null)
        {
            // If no left child replaced with right subtree
            // If current is root node, set root as current's right child node
            if(current == root)
            {
                root = current.getRight();
            }
            else if(isLeft)
            {
                // Else, check if key is left of parent node
                // Check if key is left
                // Set parent's left node as current's right child node
                parent.setLeft(current.getRight());
            }
            else
            {
                // Otherwise, set parent's right node as current's right child node
                parent.setRight(current.getRight());
            }
        }
        else
        {
            // If the current node has two children, replace the node instead
            // Set replacement as the replacement of the current node
            BinaryNode replacement = getReplacementNode(current);
            // If current node is root node, make the replacement as root
            if(current == root)
            {
                root = replacement;
            }
            else if(isLeft)
            {
                // Else if the node is marked as left child, replace parent's left child
                parent.setLeft(replacement);
            }
            else
            {
                // If right child, replace parent's right child as replacement node
                parent.setRight(replacement);
            }
            // Set replacement's left child as current's left child
            replacement.setLeft(current.getLeft());
        }
        // Decrement number of nodes by 1
        noOfNodes--;
        // Return true
        return true;
    }
    // Find node in tree
    public BinaryNode find(int key)
    {
        // Initialise current node as null to check empty tree before search
        BinaryNode current = null;
        // Check if tree is not empty
        if(!isEmpty())
        {
            // Set current node as root node
            current = root;
            // Continue loop if key is not found yet
            while(current.getKey() != key)
            {
                // If key is less than current's key, go left
                if(key < current.getKey())
                {
                    current = current.getLeft();
                }
                else
                {
                    // If key is greater, go right
                    current = current.getRight();
                }
                // If last child node is null, return null
                if(current == null)
                {
                    return null;
                }
            }
        }
        // Return current node
        return current;
    }
    // Display all nodes from root, then left and then right 
    public void preOrder(BinaryNode node)
    {
        if(node != null)
        {
            System.out.println("Key ID: " + node.getKey());
            node.getEmployee().printDetails();
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }
    // Display all nodes from left, then root and then right
    public void inOrder(BinaryNode node)
    {
        if(node != null)
        {
            inOrder(node.getLeft());
            System.out.println("Key ID: " + node.getKey());
            node.getEmployee().printDetails();
            inOrder(node.getRight());
        }
    }
    // Display all nodes from left, then right and then root
    public void postOrder(BinaryNode node)
    {
        if(node != null)
        {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.println("Key ID: " + node.getKey());
            node.getEmployee().printDetails();
        }
    }
    // Change employee's details
    public void changeEmployeeDetails(BinaryNode node)
    {
        scan = new Scanner(System.in).useDelimiter("[\r\n]");
        // Continue loop until being selected
        boolean selected = false;
        do
        {
            System.out.println(displayOption());
            input = handleInt();
            switch(input)
            {
                // If 0, cancel changes
                case 0:
                    System.out.println("Cancelling change.");
                    selected = true;
                    break;
                // If 1, change name
                case 1:
                    System.out.println("Enter new name for this node.");
                    String name = scan.next();
                    node.getEmployee().setName(name);
                    System.out.println();
                    node.getEmployee().printDetails();
                    selected = true;
                    break;
                // If 2, change email
                case 2:
                    System.out.println("Enter new email for this node.");
                    String email = scan.next();
                    node.getEmployee().setEmail(email);
                    System.out.println();
                    node.getEmployee().printDetails();
                    selected = true;
                    break;
                // If 3, change gender
                case 3:
                    int gender;
                    String genderChoice = null;
                    boolean hasGender = false;
                    // Continue while user has not select gender
                    do
                    {
                        System.out.println("Enter new employee's gender for this node.");
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
                    node.getEmployee().setGender(genderChoice);
                    System.out.println();
                    node.getEmployee().printDetails();
                    selected = true;
                    break;
                // If 4, change age
                case 4:
                    // Continue loop while age is less than 16
                    int age;
                    do
                    {
                        System.out.println("Enter new employee's age for this node.");
                        age = handleInt();
                        if(age < 16)
                        {
                            System.out.println("Invalid age. Must be 16 or over.");
                        }
                    }
                    while(age < 16);
                    node.getEmployee().setAge(age);
                    System.out.println();
                    node.getEmployee().printDetails();
                    selected = true;
                    break;
                // If 5, change employee's status
                case 5:
                    System.out.println("Enter new status for this node.");
                    String status = scan.next();
                    node.getEmployee().setRank(status);
                    System.out.println();
                    node.getEmployee().printDetails();
                    selected = true;
                    break;
                // If 6, change all except id because ID is permanent
                case 6:
                    // Edit new employee's details
                    System.out.println("Enter new employee's name.");
                    String newName = scan.next();
                    System.out.println();
                    System.out.println("Enter new employee's email.");
                    String newEmail = scan.next();
                    System.out.println();
                    int newGender;
                    String newGenderChoice = null;
                    boolean hasNewGender = false;
                    // Continue while user has not select gender
                    do
                    {
                        System.out.println("Enter new employee's gender.");
                        System.out.println("Male (1)");
                        System.out.println("Female (2)");
                        newGender = handleInt();
                        switch(newGender){
                            case 1:
                                newGenderChoice = "Male";
                                hasNewGender = true;
                                break;
                            case 2:
                                newGenderChoice = "Female";
                                hasNewGender = true;
                                break;
                            default:
                                System.out.println("Invalid option.");
                                break;
                        }
                    }
                    while(!hasNewGender);
                    // Continue loop while age is less than 16
                    int newAge;
                    do
                    {
                        System.out.println("Enter new employee's age.");
                        newAge = handleInt();
                        if(newAge < 16)
                        {
                            System.out.println("Invalid age. Must be 16 or over.");
                        }
                    }
                    while(newAge < 16);
                    System.out.println("Enter new employee's status.");
                    String newRank = scan.next();
                    // Change all details and display new details
                    node.getEmployee().setName(newName);
                    node.getEmployee().setEmail(newEmail);
                    node.getEmployee().setGender(newGenderChoice);
                    node.getEmployee().setAge(newAge);
                    node.getEmployee().setRank(newRank);
                    System.out.println();
                    System.out.println("Key ID: " + node.getKey());
                    node.getEmployee().printDetails();
                    selected = true;
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }
        while(!selected);
    }
    // Display all options
    public String displayOption()
    {
        // Build up the option easily without typing string in lengthy line
        StringBuilder option = new StringBuilder();
        // Append all string into one
        option.append("Select options.").append("\n");
        option.append("0. Cancel changes.").append("\n");
        option.append("1. Change employee's name.").append("\n");
        option.append("2. Change employee's email.").append("\n");
        option.append("3. Change employee's gender.").append("\n");
        option.append("4. Change employee's age.").append("\n");
        option.append("5. Change employee's status.").append("\n");
        option.append("6. Change all employee's details.");
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