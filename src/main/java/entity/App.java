package entity;

import interfaces.IActiveService;
import interfaces.ICoverageService;
import enums.Categories;
import enums.CategoryCoverage;
import services.ActiveService;
import services.CoverageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {

    ICoverageService iCoverageService;
    IActiveService iActiveService;
    List<Patient> patientList = Patient.getRandomPatients();

    //Using strategy design pattern for services
    public App() {
        this.iActiveService = new ActiveService();
        this.iCoverageService = new CoverageService();
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public ICoverageService getICoverageService() {
        return iCoverageService;
    }

    public IActiveService getIActiveService() {
        return this.iActiveService;
    }


}
