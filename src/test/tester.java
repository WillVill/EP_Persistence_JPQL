/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Student;
import facade.facade;
import java.util.List;

/**
 *
 * @author bechw
 */
public class tester {
 
    public static void main(String[] args) {
        facade f = new facade();
        
//        System.out.println(f.findByLastName("Olsen"));
//        System.out.println(f.findByName("jan"));
//        System.out.println(f.getAllStudents());
        System.out.println(f.sumById(1));
//        System.out.println(f.sumOfAll());
//        List<Student> list = f.highestSum();
//        List<Student> list1 = f.lowestSum();
//        
//        for (Student l : list1) {
//            System.out.println(l.getFirstname());
//        }
//        
//        for (Student l : list) {
//            System.out.println(l.getFirstname());
//        }
//        f.addStudent("fname", "lname");
//        f.addStudyPointToStudent(1);
    }
}
