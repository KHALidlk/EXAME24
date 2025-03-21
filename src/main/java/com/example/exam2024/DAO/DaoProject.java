package com.example.exam2024.DAO;

import com.example.exam2024.Entity.Project;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class DaoProject {

    EntityManagerFactory emf= Persistence.createEntityManagerFactory("DB");
    public void AjouterProject(Project project)
    {
        EntityManager em=emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(project);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    public Project findProjectById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Project.class, id);
        } finally {
            em.close();
        }
    }

    public List<Project> getPoject() {
        EntityManager em = emf.createEntityManager();
        List<Project> projects = new ArrayList<>();
        try {
            projects = em.createQuery("select s from Project s", Project.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace(); // Pour déboguer le problème
        } finally {
            em.close();
        }
        return projects;
    }



}

