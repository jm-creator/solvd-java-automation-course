package entity;

import interfaces.IActiveService;
import interfaces.ICoverageService;
import enums.Categories;
import enums.CategoryCoverage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {

    private  List<Patient> patients;

    public App() {
        this.patients = Patient.generateRandomPatients();
        //        patients.add(new Patient("Hyatt", new Category(
//                Categories.BASE.getName(),
//                Categories.BASE.getPrice(),
//                CategoryCoverage.getBaseCoverage())));
    }

    public List<Patient> getPatients() {
        return patients;
    }

}
