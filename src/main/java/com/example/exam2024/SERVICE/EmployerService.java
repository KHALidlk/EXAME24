package com.example.exam2024.SERVICE;

import com.example.exam2024.DAO.DaoEmploye;
import com.example.exam2024.Entity.Employe;

import java.util.ArrayList;
import java.util.List;

public class EmployerService {
    private DaoEmploye daoEmploye=new DaoEmploye();
    public void AjouterEmplyer(Employe employe)
    {
        daoEmploye.AjouterEmploye(employe);
    }
    public Employe findEmployeById(Long id) {
    return   daoEmploye.findEmployeById(id);
    }
    public List<Employe> getEmploye()
    {
        List<Employe> employes =new ArrayList<>();
        return   employes = daoEmploye.getEmploye();
    }
}
