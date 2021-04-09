package com.solvd.medicalInsuranceSystem.models;

import org.apache.log4j.Logger;
import com.solvd.medicalInsuranceSystem.interfaces.IWork;

public class HumanResourcesEmployee extends BaseEmployee implements IWork {
    private static final Logger LOGGER = Logger.getLogger(HumanResourcesEmployee.class);
    private int idCompanyNumber;


    public HumanResourcesEmployee(int idCompanyNumber) {
        this.idCompanyNumber = idCompanyNumber;
    }

    public HumanResourcesEmployee(String firstName, String lastName, int idNumber, int idCompanyNumber) {
        super(firstName, lastName, idNumber, idCompanyNumber);
        this.idCompanyNumber = idCompanyNumber;
    }


    @Override
    public void work(Partner partner) {
        LOGGER.info("Employee from H.R Working on partner " + partner);
    }
}
