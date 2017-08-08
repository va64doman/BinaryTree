/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytreeapp;

/**
 *
 * @author Van Do
 */

public class BinaryTree {
    // The root of the binary tree
    private BinaryNode root;
    // The number of nodes in binary tree
    private int noOfNodes;
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
    public BinaryNode getReplacementNode(BinaryNode replacing)
    {
        // The replacement parent node, replacement node and current node
        BinaryNode replaceParent, replace, current;
        // Both replaceParent and replace are the parameter from this method
        replaceParent = replacing;
        replace = replacing;
        // The current node is the replacing node's right child
        current = replacing.getRight();
        // While there are no more children node
        while(current != null){
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
        if(replace != replacing.getRight()){
            // Set replacing parent's left child as replace's right child
            replaceParent.setLeft(replace.getRight());
            // Set replace's right child as parameter's right child
            replace.setRight(replacing.getRight());
            
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
        if(root == null){
            temp = new BinaryNode(key, data);
            root = temp;
            noOfNodes++;
        }else{
            // If tree is not empty, compare the parent node if greater or less than from this node
            temp = new BinaryNode(key, data);
            // Set current node as root node to initialise comparing
            current = root;
            // Loop never ends
            while(true){
                // Set parent node as current node to compare the parent
                parent = current;
                // If the input key is less than parent, go left of the tree
                if(key < parent.getKey()){
                    // Set current to the left node of the previous node
                    current = current.getLeft();
                    // If this node is null, set the parent node's left child
                    // as the new node for temp and increment noOfNodes by 1
                    if(current == null){
                        parent.setLeft(temp);
                        noOfNodes++;
                        // Escape the loop
                        return;
                    }
                }else{
                    // If input key is greater than parent, go right of the tree
                    // Set current to the right node of the previous node
                    current = current.getRight();
                    // Same as left except insert as right child of parent node
                    if(current == null){
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
        while(current.getKey() != key){
            // Parent node is equal to current node
            parent = current;
            // If key is less than current key, check the left child node
            if(key < current.getKey()){
                isLeft = true;
                current = current.getLeft();
            }else{
                // Else, check the right child node
                isLeft = false;
                current = current.getRight();
            }
            // If current node is empty, return failed to delete as non-existed
            if(current == null){
                return false;
            }
        }
        // If no children delete node
        if(current.getLeft() == null && current.getRight() == null){
            // If current is root node, make left child root node
            if(current == root){
                root = current.getLeft();
            }else{
                // Else, check if key is left of parent node
                // Check if key is left
                if(isLeft){
                    // Set parent's left node as current's right child node
                    parent.setLeft(current.getRight());
                }else{
                    // Otherwise, set parent's right node as current's right child node
                    parent.setRight(current.getRight());
                }
            }
        }else if(current.getRight() == null){
            // If no right child replaced with left subtree
            // If current is root node, set root as current's right child node
                if(current == root){
                    root = current.getRight();
                }else{
                    // Else, check if key is left of parent node
                    // Check if key is left
                    if(isLeft){
                        // Set parent's left node as current's left child node
                        parent.setLeft(current.getLeft());
                    }else{
                        // Otherwise, set parent's right node as current's left child node
                        parent.setRight(current.getLeft());
                    }
                }
        }else if(current.getLeft() == null){
            // If no left child replaced with right subtree
            // If current is root node, set root as current's right child node
            if(current == root){
                root = current.getLeft();
            }else{
                // Else, check if key is left of parent node
                // Check if key is left
                if(isLeft){
                    // Set parent's left node as current's right child node
                    parent.setLeft(current.getRight());
                }else{
                    // Otherwise, set parent's right node as current's right child node
                    parent.setRight(current.getRight());
                }
            }
        }else{
            // If the current node has two children, replace the node instead
            // Set replacement as the replacement of the current node
            BinaryNode replacement = getReplacementNode(current);
            // If current node is root node, make the replacement as root
            if(current == root){
                root = replacement;
            }else if(isLeft){
                // Else if the node is marked as left child, replace parent's left child
                parent.setLeft(replacement);
            }else{
                // If right child, replace parent's right child as replacement node
                parent.setRight(replacement);
                // Set replacement's left child as current's left child
                replacement.setLeft(current.getLeft());
            }
        }
        // Decrement number of nodes by 1
        noOfNodes--;
        // Return true
        return true;
        
    }
}
