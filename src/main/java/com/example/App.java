package com.example;

import com.example.service.DataInitService;
import com.example.service.PerformanceTestService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-cache-pu");
        EntityManager em = emf.createEntityManager();

        DataInitService dataInitService = new DataInitService();
        PerformanceTestService performanceTestService = new PerformanceTestService();

        dataInitService.em = em;
        performanceTestService.em = em;

        em.getTransaction().begin();
        dataInitService.initData();
        em.getTransaction().commit();

        em.clear();

        System.out.println("--- Test sans cache ---");
        performanceTestService.testPerformanceSansCache();

        em.clear();

        System.out.println("--- Test avec JOIN FETCH ---");
        performanceTestService.testPerformanceAvecJoinFetch();

        em.clear();

        System.out.println("--- Test avec cache de second niveau ---");
        performanceTestService.testPerformanceAvecCache();

        em.close();
        emf.close();
    }
}
