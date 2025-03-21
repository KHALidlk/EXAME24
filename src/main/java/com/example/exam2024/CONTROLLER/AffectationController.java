package com.example.exam2024.CONTROLLER;

import com.example.exam2024.Entity.Affectation;
import com.example.exam2024.Entity.Employe;
import com.example.exam2024.Entity.Project;
import com.example.exam2024.SERVICE.AffectationService;
import com.example.exam2024.SERVICE.EmployerService;
import com.example.exam2024.SERVICE.ProjectService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("affectationBean")
@SessionScoped
public class AffectationController implements Serializable {
    private Affectation affectation; // Objet Affectation pour lier la vue
    private Long employeId; // ID de l'employé sélectionné
    private Long projectId; // ID du projet sélectionné

    private List<Employe> employes; // Liste des employés pour afficher dans le formulaire
    private List<Project> projects; // Liste des projets pour afficher dans le formulaire
    private List<Object[]> employeProjectDetails; // Liste des détails employés-projets

    private final AffectationService affectationService = new AffectationService();
    private final EmployerService employerService = new EmployerService();
    private final ProjectService projectService = new ProjectService();

    @PostConstruct
    public void init() {
        affectation = new Affectation();
        employeId = null;
        projectId = null;

        // Charger les données nécessaires
        employes = employerService.getEmploye();
        projects = projectService.projectList();
        employeProjectDetails = affectationService.getEmployeProjectDetails();
    }

    // Méthode pour ajouter une nouvelle affectation
    public void ajouterAffectation() {
        Employe employe = employerService.findEmployeById(employeId);
        Project project = projectService.findProjectById(projectId);

        affectation.setEmploye(employe);
        affectation.setProject(project);

        affectationService.ajouterAffectation(affectation);

        // Mise à jour des données après ajout
        employeProjectDetails = affectationService.getEmployeProjectDetails();
        affectation = new Affectation(); // Réinitialisation de l'objet affectation
        employeId = null;
        projectId = null;
    }

//    // Méthode pour supprimer une affectation
//    public void supprimerAffectation(Long affectationId) {
//        affectationService.supprimerAffectation(affectationId);
//
//        // Mise à jour des données après suppression
//        employeProjectDetails = affectationService.getEmployeProjectDetails();
//    }

    // Getters et Setters
    public Affectation getAffectation() {
        return affectation;
    }

    public void setAffectation(Affectation affectation) {
        this.affectation = affectation;
    }

    public Long getEmployeId() {
        return employeId;
    }

    public void setEmployeId(Long employeId) {
        this.employeId = employeId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public List<Object[]> getEmployeProjectDetails() {
        return employeProjectDetails;
    }
}
