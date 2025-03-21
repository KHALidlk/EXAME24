package com.example.exam2024.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="affectation")
public class Affectation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name="employe_id")
    private Employe employe;
    @ManyToOne
    @JoinColumn(name="project_id")
    private Project project;
    private double implication;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public double getImplication() {
        return implication;
    }

    public void setImplication(double implication) {
        this.implication = implication;
    }
}