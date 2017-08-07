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
public class Employee {
    // Employee's name
    private String name;
    // Employee's email
    private String email;
    // Employee's gender
    private String gender;
    // Employee's date of birth
    private String date;
    // Employee's rank of employee, such as Boss, Manager, Assistant
    private String rank;
    // Null constructor
    public Employee()
    {
        name = null;
        email = null;
        gender = null;
        date = null;
        rank = null;
    }
    // Parameterised constructor to add details to employee's node
    public Employee(String eName, String eEmail, int eGender, String eDate, String eRank)
    {
        name = eName;
        email = eEmail;
        setGender(eGender);
        date = eDate;
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
    // Return employee's date of birth
    public String getDate()
    {
        return date;
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
    public final void setGender(int eGender)
    {
        switch(eGender)
        {
            case 1:
                gender = "Male";
                break;
            case 2:
                gender = "Female";
                break;
            case 3:
                gender = "Unisex";
                break;
            default:
                gender = "Unknown";
                break;
        }
    }
    // Set new date of birth for changing details legally
    public void setDate(String eDate)
    {
        date = eDate;
    }
    // Set new rank if promote or demote
    public void setRank(String eRank)
    {
        rank = eRank;
    }
}
