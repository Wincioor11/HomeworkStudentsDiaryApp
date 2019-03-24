/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeworkapp;

/**
 *
 * @author Michał, Janek, Wojtek
 */
public interface IStudent extends Comparable<Student> {
    String getName();
    void setName(String name);
    float getGrade();
    void setGrade(float grade);
    void evaluate();
}
