package com.cts;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
public class JpaTest {
    private static EntityManager em;
 
    public static void main(String[] args) {
 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePU");
        em = emf.createEntityManager();
      //insert 
        createEmployee(23, "Ravi", "Raj", "Textile");
        createEmployee(84, "Amit", "Raj", "IT");
        createEmployee(67, "Nitish", "Kumar", "Marketing");
        //delete
        em.getTransaction().begin();
        Employee emp1 = em.find(Employee.class, 20); //20 is id value
        em.remove(emp1);
        em.getTransaction().commit();
        //update
        em.getTransaction().begin();
        Employee emp2 = em.find(Employee.class, 30); //30 is id value
        emp2.setFirstName("XXXXXXX");
        em.getTransaction().commit();
       
       
    }
 
    private static void createEmployee(int id, String firstName,
            String lastName, String dept) {
        em.getTransaction().begin();
        Employee emp = new Employee(id, firstName, lastName, dept);
        em.persist(emp);
        em.getTransaction().commit();
            }
}