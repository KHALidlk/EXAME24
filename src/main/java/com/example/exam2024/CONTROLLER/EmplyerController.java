package com.example.exam2024.CONTROLLER;

import com.example.exam2024.Entity.Employe;
import com.example.exam2024.SERVICE.EmployerService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Named("EmployerBean")
@SessionScoped
public class EmplyerController implements Serializable {
    public EmplyerController() {
    }
private Employe employe=new Employe();

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    private EmployerService employerService = new EmployerService();
    @PostConstruct
    public void init() {
        employes = employerService.getEmploye();
        System.out.println("Employés initialisés : " + employes);
    }
    public Employe findEmployeById(Long id) {
        return   employerService.findEmployeById(id);
    }
    public void AjouterEmployer(Employe employe)
    {
        employerService.AjouterEmplyer(employe);
        employe=new Employe();
    }
    List<Employe> employes =new ArrayList<>();
    public void getEmploye()
    {
        setEmployes(employerService.getEmploye()) ;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }
}
