/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeworkapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 *
 * @author Michał, Janek, Wojtek
 */
public class Group implements IGroup {

    private List<Student> list;

    //konstruktor ktory inicjalizuje liste studentow
    public Group() {
        list =new ArrayList<>();

        Scanner scanner;
        try {
            //wczytywanie imion i nazwisk studentow z pliku names
            scanner = new Scanner(new File("names"));

            while (scanner.hasNextLine()) {
                list.add(new Student(scanner.nextLine()));
            }

            scanner.close();

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        //sortowanie listy studentow
        Collections.sort(list);

    }
    
    public Group(List<Student> list){
        this.list=list;
        Collections.sort(list);
    }

    @Override
    public int getGroupSize() {
        return list.size();
    }
    
    //geter ktory zwraca liste studentow ( na potrzeby GUI)
    public List<Student> getList() {
        return list;
    }

    @Override
    public boolean addStudent(Student s) {
        return list.add(s);

    }

    @Override
    public boolean removeStudent(Student s) {
        return list.remove(s);
    }

    @Override
    public int indexOf(Student s) {
        return list.indexOf(s);
    }

    @Override
    public Student studentAt(int index) {
        return list.get(index);
    }

    @Override
    public boolean isMember(Student s) {
        return list.contains(s);
    }

    @Override
    public void evaluateStudent(Student s) {
        s.evaluate();
    }

    @Override
    public void evaluateStudent(int index) {
        list.get(index).evaluate();
    }

    @Override
    public void evaluateAll() {
        for (Student s : list) {
            s.evaluate();
        }
    }

}
