package com.solvd.medicalInsuranceSystem.models;

import com.solvd.medicalInsuranceSystem.enums.Permissions;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseEmployee extends Person {
    private int idCompanyNumber;
    protected List<Permissions> permissions;

    public BaseEmployee() {}

    public BaseEmployee(String firstName, String lastName, int idNumber, int idCompanyNumber) {
        super(firstName, lastName, idNumber);
        this.idCompanyNumber = idCompanyNumber;
        this.permissions = new ArrayList<>();
    }

    public int getIdCompanyNumber() {
        return idCompanyNumber;
    }

    public void setIdCompanyNumber(int idCompanyNumber) {
        this.idCompanyNumber = idCompanyNumber;
    }

    public List<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permissions> permissions) {
        this.permissions = permissions;
    }
}
