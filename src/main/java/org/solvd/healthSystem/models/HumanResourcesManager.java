package org.solvd.healthSystem.models;

import org.apache.log4j.Logger;
import org.solvd.healthSystem.interfaces.IWork;

import java.util.ArrayList;
import java.util.List;

public class HumanResourcesManager extends BaseEmployee implements IWork {
    private static final Logger LOGGER = Logger.getLogger(HumanResourcesManager.class);
    private List<HumanResourcesEmployee> subordinates;

    public HumanResourcesManager(String firstName, String lastName, int idNumber, int idCompanyNumber) {
        super(firstName, lastName, idNumber, idCompanyNumber);
        this.permissions = new ArrayList<>();
        this.subordinates = new ArrayList<>();
    }

    @Override
    public void work(Partner partner) {
        LOGGER.info("Manager working with partner " + partner);
    }


    public List<HumanResourcesEmployee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<HumanResourcesEmployee> subordinates) {
        this.subordinates = subordinates;
    }
}
