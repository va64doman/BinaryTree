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

// The main class contains modular programming view and the scenario
// is storing student details in one class from one course in one campus.
// This means, assumingly, one course has one class. One class has many students.
// The reference is used from the colleagues and internet, however it is not reliable
// It does not give clear indication of the coding standard and function.
// Therefore, I would modify this code for the better and ergonomic approach
public class BinaryTreeApp 
{
    public static void main(String[] args) 
    {
        // Display the application from Modular class
        System.out.println("Employee Binary Tree");
        Modular module = new Modular();
        module.selectOption();
    } 
}