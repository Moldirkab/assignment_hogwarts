package com.hogwarts;

import java.util.ArrayList;

public class Student extends Person {
    private static int id_gen=1;
    private int studentID;
    private ArrayList<Integer> grades;


    public Student(String name, String surname, int age, boolean gender){
        super(name,surname,age,gender);
        studentID=id_gen++;
        grades=new ArrayList<>();
    }

    public int getStudentID(){
        return studentID;
    }

    public void addGrade(int grade){
        this.grades.add(grade);
    }

    public double calculateGpa() {
        int totalGrades=0;
        int totalCredits=0;
        for (Integer grade: grades) {
            totalGrades+=getGPA(grade);
            totalCredits ++;
        }
        return (double)totalGrades/totalCredits;
    }
  public double getGPA(int grade) {
      int[] percentage = {95, 90, 85, 80, 75, 70, 65, 60, 55, 50};
      double[] gpaEquivalence = {4.0, 3.67, 3.33, 3.0, 2.67, 2.33, 2.0, 1.67, 1.33, 1.0};
      for (int i = 0; i < percentage.length; i++) {
          if (percentage[i] >= grade) {
              return gpaEquivalence[i];
          }
      }
      return 0.0;
  }

    @Override
    public String toString() {
        return super.toString()+" "+ "I am a student with ID "+ studentID+".";
    }
}
