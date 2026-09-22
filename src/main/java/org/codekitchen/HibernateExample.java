package org.codekitchen;

import org.codekitchen.config.HibernateConfig;
import org.codekitchen.entity.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.Arrays;
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

            Section footballSection = new Section(SectionType.FOOTBALL);
            entityManager.persist(footballSection);

            Section basketballSection = new Section(SectionType.BASKETBALL);
            entityManager.persist(basketballSection);

            Section swimmingSection = new Section(SectionType.SWIMMING);
            entityManager.persist(swimmingSection);

            Section dancingSection = new Section(SectionType.DANCING);
            entityManager.persist(dancingSection);

            Student student1 = new Student(19, "Linkoln", "John");
            student1.setSectionList(Arrays.asList(footballSection, basketballSection));
            entityManager.persist(student1);

            Student student2 = new Student(21, "Armstrong", "Ivan");
            student2.setSectionList(Arrays.asList(footballSection, swimmingSection));
            entityManager.persist(student2);

            Student student3 = new Student(17, "Popov", "Ivan");
            student3.setSectionList(List.of(dancingSection));
            entityManager.persist(student3);

            Student student4 = new Student(22, "Petrov", "Evgeniy");
            student4.setSectionList(List.of(footballSection));
            entityManager.persist(student4);

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
