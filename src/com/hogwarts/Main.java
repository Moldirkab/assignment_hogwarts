package com.hogwarts;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;
        public class Main {
            public static void main(String[] args) throws FileNotFoundException {
                File fileStudents =new File("students.txt");
                File fileTeachers =new File("teachers.txt");
                Scanner scanner=new Scanner(fileStudents);
                Scanner scanner2=new Scanner(fileTeachers);
                School school=new School();


                while (scanner.hasNextLine()) {
                    String name = scanner.next();
                    String surname = scanner.next();
                    int age = Integer.parseInt(scanner.next());
                    String gender = scanner.next();
                    boolean genderBool;
                    genderBool = gender.equals("Male");
                    Student student = new Student(name, surname, age, genderBool);
                    while (scanner.hasNextInt()) {
                        student.addGrade(Integer.parseInt(scanner.next()));
                    }
                    school.addMember(student);
                }

                while (scanner2.hasNextLine()) {
                    String name = scanner2.next();
                    String surname = scanner2.next();
                    int age = Integer.parseInt(scanner2.next());
                    String gender = scanner2.next();
                    String subject = scanner2.next();
                    int yearsOfExperience = Integer.parseInt(scanner2.next());
                    int salary = Integer.parseInt(scanner2.next());
                    boolean genderBool;
                    genderBool = gender.equals("Male");
                    Teacher teacher = new Teacher(name, surname, age, genderBool, subject, yearsOfExperience, salary);
                    school.addMember(teacher);
                }


                for(Person person: school.getMembers()){
                    if(person instanceof Student student){
                        if (student.getName().equals("Luna")){
                            System.out.println(student.getName()+"'s GPA: " +String.format(Locale.US,"%.2f",student.calculateGpa()));
                        }
                    }
                    if(person instanceof Teacher teacher){
                        if(teacher.getYearsOfExperience()>10){
                            System.out.println( teacher.getName()+"'s salary before rise: "+ teacher.getSalary()+ "."+"After the rise: "+teacher.giveRaise(15));
                        }
                    }
                }


                school.sortMembers();
                System.out.println("\n\tWelcome to Hogwarts com.hogwarts.School of Witchcraft and Wizardry!");
                school.print();
            }
        }