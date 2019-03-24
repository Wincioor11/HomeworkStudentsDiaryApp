/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeworkapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Michał, Janek, Wojtek
 */
public class SimpleGUI extends JFrame implements ActionListener {

    private Group group;

    JButton bLoad, bEvaluateAll, bEvaluateStudentBN, bEvaluateStudentBI, bEvaluateSelected;
    JButton bAddStudent, bRemoveStudent;
    JLabel lIndex, lName, lGrade, lGroupSize;
    JTextArea t1;
    JTextField tfEvaluateBN, tfEvaluateBI, tfAdd, tfRemove;
    JToolTip tip;

    public SimpleGUI() {
        setTitle("Simple GUI for group of students");
        setLayout(null);
        setSize(1000, 800);
        setLocation(400, 100);
        group = new Group();

        lIndex = new JLabel("Index:");
        lIndex.setBounds(50, 10, 50, 20);
        add(lIndex);

        lName = new JLabel("Name:");
        lName.setBounds(140, 10, 50, 20);
        add(lName);

        lGrade = new JLabel("Grade:");
        lGrade.setBounds(315, 10, 50, 20);
        add(lGrade);

        t1 = new JTextArea();
        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(50, 30, 350, 600);
        add(sp);

        bLoad = new JButton("Load group");
        bLoad.setBounds(400, 30, 100, 20);
        bLoad.addActionListener(this);
        add(bLoad);

        bEvaluateStudentBN = new JButton("Evaluate student by name:");
        bEvaluateStudentBN.setBounds(400, 80, 200, 20);
        bEvaluateStudentBN.addActionListener(this);
        add(bEvaluateStudentBN);

        tfEvaluateBN = new JTextField();
        tfEvaluateBN.setBounds(610, 80, 200, 20);
        tfEvaluateBN.setToolTipText("Write student's full name");
        add(tfEvaluateBN);

        bEvaluateAll = new JButton("Evaluate all");
        bEvaluateAll.setBounds(520, 30, 100, 20);
        bEvaluateAll.addActionListener(this);
        add(bEvaluateAll);

        bEvaluateStudentBI = new JButton("Evaluate student by index:");
        bEvaluateStudentBI.setBounds(400, 120, 200, 20);
        bEvaluateStudentBI.addActionListener(this);
        add(bEvaluateStudentBI);

        tfEvaluateBI = new JTextField(10);
        tfEvaluateBI.setBounds(610, 120, 200, 20);
        tfEvaluateBI.setToolTipText("Write student's index");
        add(tfEvaluateBI);

        bAddStudent = new JButton("Add student:");
        bAddStudent.setBounds(400, 170, 200, 20);
        bAddStudent.addActionListener(this);
        add(bAddStudent);

        tfAdd = new JTextField(10);
        tfAdd.setBounds(610, 170, 200, 20);
        tfAdd.setToolTipText("Write student's full name");
        add(tfAdd);

        bRemoveStudent = new JButton("Remove Student:");
        bRemoveStudent.setBounds(400, 210, 200, 20);
        bRemoveStudent.setToolTipText("You have to press 'Load group' "
                + "button after removing any student");
        bRemoveStudent.addActionListener(this);
        add(bRemoveStudent);

        tfRemove = new JTextField(10);
        tfRemove.setBounds(610, 210, 200, 20);
        tfRemove.setToolTipText("Write student's full name");
        add(tfRemove);

        lGroupSize = new JLabel("Group size: ");
        lGroupSize.setBounds(400, 300, 200, 20);
        add(lGroupSize);

    }

    public void loadGroup() {
        t1.setText(null);

        for (Student s : group.getList()) {
            t1.append(group.indexOf(s) + " : \t" + s + "\n");

        }
        lGroupSize.setText("Group size: " + group.getGroupSize());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source.equals(bLoad)) {
            loadGroup();
        }
        if (source.equals(bEvaluateAll)) {
            group.evaluateAll();
            loadGroup();
        }
        if (source.equals(bEvaluateStudentBN)) {
            String name = tfEvaluateBN.getText();
            tfEvaluateBN.setText(null);

            for (Student s : group.getList()) {
                if (name.equals(s.getName())) {
                    s.evaluate();
                }
            }

            loadGroup();
        }
        if (source.equals(bEvaluateStudentBI)) {
            String indexString = tfEvaluateBI.getText();
            int indexInt = Integer.parseInt(indexString);
            tfEvaluateBI.setText(null);

            for (Student s : group.getList()) {
                if (indexInt == group.indexOf(s)) {
                    s.evaluate();
                }
            }

            loadGroup();

        }
        if (source.equals(bAddStudent)) {
            String name = tfAdd.getText();
            tfAdd.setText(null);
            group.addStudent(new Student(name));
            loadGroup();
        }
        if (source.equals(bRemoveStudent)) {
            String name = tfRemove.getText();
            tfRemove.setText(null);
            for (Student s : group.getList()) {

                if (s.getName().equals(name)) {
                    group.removeStudent(s);
                }

            }
            //loadGroup();
        }

    }
}
