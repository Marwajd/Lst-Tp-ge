package Modules;

import java.util.ArrayList;

public class Filieres {
    private int id;
    private String intitule;
    private Enseignant responsable;
    private Departement dept;

    ArrayList<Module> modules = new ArrayList<Module>();

    public Filieres() {
    }

    public Filieres(int id, String intitule, Enseignant responsable, Departement dept) {
        this.id = id;
        this.intitule = intitule;
        this.responsable = responsable;
        this.dept = dept;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Enseignant getResponsable() {
        return responsable;
    }

    public void setResponsable(Enseignant responsable) {
        this.responsable = responsable;
    }

    public Departement getDept() {
        return dept;
    }

    public void setDept(Departement dept) {
        this.dept = dept;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }
}
