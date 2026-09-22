package org.codekitchen;

import org.codekitchen.config.HibernateConfig;
import org.codekitchen.entity.Address;
import org.codekitchen.entity.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

/**
 * Hello world!
 *
 */
public class HibernateExample
{
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        EntityManagerFactory entityManagerFactory = context.getBean(EntityManagerFactory.class);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Student student = new Student(25, "Test", "Test");
            Address address = new Address("Test", 5, 5);

            student.setAddress(address);
            entityManager.persist(student);

            entityManager.getTransaction().commit();
        }catch (Exception exception){
            System.out.println("Exception caught, executing rollback...");
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }



        context.close();
    }
}
