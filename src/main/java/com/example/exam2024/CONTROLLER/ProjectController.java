package com.example.exam2024.CONTROLLER;

import com.example.exam2024.Entity.Project;
import com.example.exam2024.SERVICE.ProjectService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Named("projectBean")
@SessionScoped
public class ProjectController implements Serializable {
    public ProjectController() {
    }
    private Project project=new Project();
    public Project findProjectById(Long id) {
        return  projectService.findProjectById(id);
    }
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    private ProjectService projectService=new ProjectService();
    @PostConstruct
    public void init() {
        projects = projectService.projectList();
        System.out.println("Projets initialisés : " + projects);
    }


    public void AjouterPoject(Project project)
    {
        projectService.AjouterPoject(project);
        project=new Project();
    }
    List<Project> projects=new ArrayList<>();
    public void projectList()
    {
           setProjects(projectService.projectList());
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
