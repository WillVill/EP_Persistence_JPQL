/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Student;
import entity.Studypoint;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author bechw
 */
public class facade {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    
    public List<Student> getAllStudents(){
        EntityManager em = emf.createEntityManager();      
        Query q = em.createNamedQuery("Student.findAll",Student.class);
        return q.getResultList();
    }
    
    public List<Student> findByName(String name){
        EntityManager em = emf.createEntityManager();        
        Query q = em.createNamedQuery("Student.findByFirstname",Student.class);
        return q.setParameter("firstname", name).getResultList();
    }
    
    public List<Student> findByLastName(String name){
        EntityManager em = emf.createEntityManager();      
        Query q = em.createNamedQuery("Student.findByLastname",Student.class);
        return q.setParameter("lastname", name).getResultList();
    }
    
    public Object sumById(int id){
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("Select Sum(e.score) From Studypoint e where e.studentId.id =:id", Studypoint.class);  
        Object result = q.setParameter("id", id).getSingleResult();
        return result;
    }
    
    public Object sumOfAll(){
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT SUM(s.score) FROM Studypoint s",Studypoint.class);
        Object sum = q.getSingleResult();
        return sum;
    }
    
    public List<Student> highestSum(){
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT s FROM Student s WHERE (SELECT count(p.score) FROM Studypoint p)=(SELECT MAX(SELECT count(sss.score) FROM Studypoint sss) FROM Studypoint ss)");
        return q.getResultList();
        
    }
    
    public List<Student> lowestSum(){
        
    }
    
    public void addStudent(String firstName, String lastName){
        EntityManager em = emf.createEntityManager();
        Student s = new Student(firstName, lastName);
        
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
    }
    
    public void addStudyPointToStudent(int id){
        EntityManager em = emf.createEntityManager();
        Student s = em.find(Student.class, id);
        Studypoint sp = new Studypoint("description", 5, 4, s);
        
        em.getTransaction().begin();
        em.persist(sp);
        em.getTransaction().commit();
        em.close();
    }
}
