package org.codekitchen;

import org.codekitchen.config.HibernateConfig;
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

        try{
            entityManager.getTransaction().begin();

            Query query = entityManager.createQuery("SELECT lastName, firstName FROM Student  WHERE age >= 18 AND age <=20");
            List<Object[]> students = query.getResultList();
            for (Object[] studentColumns : students){
                String lastName = (String) studentColumns[0];
                String firstName = (String) studentColumns[1];
                System.out.println(lastName + " " + firstName);
            }

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
