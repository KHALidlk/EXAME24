package com.example.exam2024.SERVICE;

import com.example.exam2024.Entity.Affectation;
import com.example.exam2024.DAO.DaoAffectation;

import java.util.List;

public class AffectationService {
    private DaoAffectation daoAffectation=new DaoAffectation();
    public void ajouterAffectation(Affectation affectation)
    {
        daoAffectation.AjouterAffectaion(affectation);
    }


    public List<Object[]> getEmployeProjectDetails() {
        return daoAffectation.getEmployeProjectDetails();
    }
 }
