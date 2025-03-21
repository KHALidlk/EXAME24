package com.example.exam2024.DAO;

import com.example.exam2024.Entity.Affectation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class DaoAffectation {
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("DB");
    public void AjouterAffectaion(Affectation affectation)
    {
        EntityManager em=emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(affectation);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }


    public List<Object[]> getEmployeProjectDetails() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery(
                    "SELECT e.id, e.name, p.id, p.name " +
                            "FROM Employe e " +
                            "JOIN e.affectations a " +
                            "JOIN a.project p", Object[].class
            ).getResultList();
        } finally {
            em.close();
        }
    }


}
