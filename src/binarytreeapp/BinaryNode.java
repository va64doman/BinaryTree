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

public class BinaryNode 
{
    // The employee's key identification
    private int keyID;
    // This node's employee records
    private Employee data;
    // Child nodes are represent the responsibility of of parent node
    // Left child node of this node (lower rank of this node)
    private BinaryNode left;
    // Right child node of this node (lower rank of this node)
    private BinaryNode right;
    // Null constructor
    public BinaryNode()
    {
        keyID = 0;
        data = null;
        left = null;
        right = null;
    }
    // Parameterised constructor for adding data to node
    public BinaryNode(int key, Employee employee)
    {
        keyID = key;
        data = employee;
        left = null;
        right = null;
    }
    // Getters
    // Return binary node's key
    public int getKey()
    {
        return keyID;
    }
    // Return employee's object
    public Employee getEmployee()
    {
        return data;
    }
    // Return left child node
    public BinaryNode getLeft()
    {
        return left;
    }
    // Return right child node
    public BinaryNode getRight()
    {
        return right;
    }
    // Setters
    // Set new key
    public void setKey(int key)
    {
        keyID = key;
    }
    // Set new employee's details
    public void setEmployee(Employee employee)
    {
        data = employee;
    }
    // Set new left child
    public void setLeft(BinaryNode leftChild)
    {
        left = leftChild;
    }
    // Set new right child
    public void setRight(BinaryNode rightChild)
    {
        right = rightChild;
    }
}