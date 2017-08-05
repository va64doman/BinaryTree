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

// The Student's class contains all student's details
public final class Student 
{
    // Student's name
    private String name;
    // Student's email
    private String email;
    // Student's gender
    private String gender;
    // Student's date of birth
    private String date;
    // Student's average result for this course
    private double average;
    // Null constructor
    public Student()
    {
        name = null;
        email = null;
        gender = null;
        date = null;
        average = 0;
    }
    // Parameterised constructor to add details to student's node
    public Student(String sName, String sEmail, int sGender, String sDate, double sAverage)
    {
        name = sName;
        email = sEmail;
        setGender(sGender);
        date = sDate;
        average = sAverage;
    }
    // Getters
    // Return student's name
    public String getName()
    {
        return name;
    }
    // Return student's email
    public String getEmail()
    {
        return email;
    }
    // Return student's gender
    public String getGender()
    {
        return gender;
    }
    // Return student's date of birth
    public String getDate()
    {
        return date;
    }
    // Return student's average result
    public double getAverage()
    {
        return average;
    }
    // Setters
    // Set new name from this student if changed lawfully
    public void setName(String sName)
    {
        name = sName;
    }
    // Set new email if student's change default email
    public void setEmail(String sEmail)
    {
        email = sEmail;
    }
    // Set student's gender for changing details legally
    public void setGender(int sGender)
    {
        switch(sGender)
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
    public void setDate(String sDate)
    {
        date = sDate;
    }
    // Set new average as the week of learning progressing
    public void setAverage(double sAverage)
    {
        average = sAverage;
    }
}
