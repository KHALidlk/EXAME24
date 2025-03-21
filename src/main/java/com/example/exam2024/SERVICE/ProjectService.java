package com.example.exam2024.SERVICE;

import com.example.exam2024.DAO.DaoProject;
import com.example.exam2024.Entity.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectService {
    public ProjectService() {
    }
    public Project findProjectById(Long id) {
   return  daoProject.findProjectById(id);
    }

    public DaoProject daoProject=new DaoProject();
    public void AjouterPoject(Project project)
    {
        daoProject.AjouterProject(project);
    }

    public List<Project> projectList()
    {
        List<Project> projects=new ArrayList<>();
     return   projects= daoProject.getPoject();
    }
}
