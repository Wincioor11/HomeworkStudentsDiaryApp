/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeworkapp;

import java.util.Random;

/**
 *
 * @author Michał, Janek, Wojtek
 */
public class Student implements IStudent {

    private String name;
    private float grade;
    
    public Student(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public float getGrade() {
        return grade;
    }

    @Override
    public void setGrade(float grade) {
        this.grade = grade;
    }

    @Override
    public void evaluate() {
        Random random = new Random();
        float fGrade;

        //losowanie ocen zgodnie z rozkladem Gaussa
        do {
            fGrade = (float) (random.nextGaussian() * 0.5 + 3.5);
        } while (fGrade < 2.0 || fGrade > 5.0);

        //nasz algorytm, zaokraglajacy oceny do polowek zgodnie z matemtyka
        int iGrade = (int) fGrade;
        if (fGrade - (float) iGrade < 0.25) {
            fGrade = (float) iGrade;
        } else if (fGrade - (float) iGrade >= 0.75) {
            fGrade = (float) (iGrade + 1);
        } else {
            fGrade = (float) iGrade;
            fGrade += 0.5;
        }
        
        //nie chcemy takich ocen jak 2.5, wiec zmieniamy wszystkie 2.5 na 2.0
        if(fGrade==2.5)
            fGrade-=0.5;
        
        grade = fGrade;
    }

    @Override
    public int compareTo(Student s) {
        return name.compareTo(s.getName());
    }
    
    //toString na potrzeby GUI
    @Override
    public String toString() {
        return name + " :          \t" + grade;
    }

}
