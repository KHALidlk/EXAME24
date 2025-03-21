package com.example.exam2024.DAO;

import com.example.exam2024.Entity.Employe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class DaoEmploye {

    EntityManagerFactory emf= Persistence.createEntityManagerFactory("DB");
    public void AjouterEmploye(Employe employe)
    {
        EntityManager em=emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(employe);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    public Employe findEmployeById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Employe.class, id);
        } finally {
            em.close();
        }
    }
    public List<Employe> getEmploye() {
        EntityManager em = emf.createEntityManager();
        List<Employe> employes = new ArrayList<>();
        try {
            employes = em.createQuery("select s from Employe s", Employe.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace(); // Pour déboguer le problème
        } finally {
            em.close();
        }
        return employes;
    }


}
