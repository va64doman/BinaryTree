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

// Assuming every employees work in the same high-standard business company
// This class holds the employee's record for node
public class Employee 
{
    // Employee's name
    private String name;
    // Employee's email
    private String email;
    // Employee's gender
    private String gender;
    // Employee's age
    private int age;
    // Employee's rank of employee, such as Boss, Manager, Assistant
    private String rank;
    // Null constructor
    public Employee()
    {
        name = null;
        email = null;
        gender = null;
        age = 0;
        rank = null;
    }
    // Parameterised constructor to add details to employee's node
    public Employee(String eName, String eEmail, String eGender, int eAge, String eRank)
    {
        name = eName;
        email = eEmail;
        gender = eGender;
        age = eAge;
        rank = eRank;
    }
    // Getters
    // Return employee's name
    public String getName()
    {
        return name;
    }
    // Return employee's email
    public String getEmail()
    {
        return email;
    }
    // Return employee's gender
    public String getGender()
    {
        return gender;
    }
    // Return employee's age
    public int getAge()
    {
        return age;
    }
    // Return employee's rank of employment
    public String getRank()
    {
        return rank;
    }
    // Setters
    // Set new name from this employee if changed lawfully or change position
    public void setName(String eName)
    {
        name = eName;
    }
    // Set new email if employee's change default email or change position
    public void setEmail(String eEmail)
    {
        email = eEmail;
    }
    // Set employee's gender for changing details legally or change position
    public void setGender(String eGender)
    {
        gender = eGender;
    }
    // Set new age for changing details legally or progressively
    public void setAge(int eAge)
    {
        age = eAge;
    }
    // Set new rank if promote or demote
    public void setRank(String eRank)
    {
        rank = eRank;
    }
    // Print details
    public void printDetails()
    {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Gender: " + gender);
        System.out.println("Age: " + age);
        System.out.println("Employee Status: " + rank);
        System.out.println();
    }
}