package com.example.exam2024;

import com.example.exam2024.DAO.DaoEmploye;
import com.example.exam2024.DAO.DaoProject;
import com.example.exam2024.Entity.Employe;
import com.example.exam2024.Entity.Project;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        // Liste pour les employés
        List<Employe> employes = new ArrayList<>();
DaoProject daoProject=new DaoProject();
DaoEmploye daoEmploye=new DaoEmploye();

        // Création des employés
        Employe employe1 = new Employe();
        employe1.setName("John");
        employe1.setEmail("john@test.com");
        employe1.setSkills(List.of("Java", ".Net", "NodeJS"));
daoEmploye.AjouterEmploye(employe1);
        Employe employe2 = new Employe();
        employe2.setName("Alice");
        employe2.setEmail("alice@test.com");
        employe2.setSkills(List.of("Spring", "Angular"));
        daoEmploye.AjouterEmploye(employe2);

        Employe employe3 = new Employe();
        employe3.setName("Mark");
        employe3.setEmail("mark@sales.com");
        employe3.setSkills(List.of("Sales Cloud", "Marketing Cloud"));
        daoEmploye.AjouterEmploye(employe3);
        // Création des projets
        Project projet1 = new Project();
        projet1.setName("Adidas");
        projet1.setBudget(100.000);
daoProject.AjouterProject(projet1);
        Project projet2 = new Project();
        projet2.setName("Nestle");
        projet2.setBudget(200.000);
        daoProject.AjouterProject(projet2);

        Project projet3 = new Project();
        projet3.setName("CTM");
        projet3.setBudget(150.000);
        daoProject.AjouterProject(projet3);
    }
}
