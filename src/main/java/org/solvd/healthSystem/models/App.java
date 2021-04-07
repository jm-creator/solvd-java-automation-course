package org.solvd.healthSystem.models;
import static org.solvd.healthSystem.enums.Permissions.*;

import org.solvd.healthSystem.exceptions.IncorrectPermissionsException;
import org.solvd.healthSystem.exceptions.InvalidCoverageException;
import org.solvd.healthSystem.exceptions.PartnerInsufficientIncomeException;
import org.solvd.healthSystem.interfaces.BiPredicate;
import org.apache.log4j.Logger;
import org.solvd.healthSystem.interfaces.Consumer;
import org.solvd.healthSystem.interfaces.Predicate;
import org.solvd.healthSystem.utils.DataGenerator;

import java.util.List;
import java.util.Random;

public class App {

   private static final Logger LOGGER = Logger.getLogger(Partner.class);
   private List<Partner> partners;
   private List<BaseEmployee> employees;
   private List<AbstractHealthCarePlan> healthCarePlans;

   public App() {
       this.partners = DataGenerator.loadPatientsList();
       this.employees = DataGenerator.loadEmployees();
       this.healthCarePlans = DataGenerator.loadHealthCarePlans();
   }

    public boolean partnerHasCoverage(BiPredicate<Partner, HealthCareCategoryCoverage> partnerPredicate, Partner partner, HealthCareCategoryCoverage category) throws InvalidCoverageException {
        return partnerPredicate.test(partner, category);
    }

    public void addPermissions(List<BaseEmployee> partners, Consumer<BaseEmployee> consumer) {
       partners.forEach(consumer::supply);
    }

    public boolean checkConstrainsEmployee(Predicate<BaseEmployee> predicate, BaseEmployee employee) {
        return predicate.test(employee);
    }

    public boolean checkConstrainsPartner(Predicate<Partner> predicate, Partner partner) {
       return predicate.test(partner);
    }

    public void deletePartner(BaseEmployee employee, Partner partner) throws IncorrectPermissionsException {
       boolean constrainsEmployee = checkConstrainsEmployee(e -> e.getPermissions().contains(DELETE_PARTNER), employee);
       if (constrainsEmployee) {
           partners.remove(partner);
           LOGGER.info("Removing " + partner.getFirstName() + " from registered partners");
       } else throw new IncorrectPermissionsException();
    }

    public void addPartner(BaseEmployee employee, Partner partner, AbstractHealthCarePlan healthCarePlan) throws IncorrectPermissionsException, PartnerInsufficientIncomeException {
        boolean constrainsEmployee = checkConstrainsEmployee(e -> e.getPermissions().contains(CREATE_PARTNER), employee);
        boolean constrainsPartner = checkConstrainsPartner(
                p -> p.getIncome() >= healthCarePlan.getPrice() * 3,
                partner);

        if (constrainsEmployee) {
            if (constrainsPartner) {
                partners.add(partner);
                LOGGER.info("Employee " + employee.getFirstName() + " is going to add a new partner");
                LOGGER.info("Partner " + partner.getFirstName() + " has been registered successfully");
            } else {
                throw new PartnerInsufficientIncomeException();
            }
        } else {
            throw new IncorrectPermissionsException();
        }
    }

//    public List<Partner> filterPatientsWithBaseCategory() {
//        return PARTNERS.stream()
//                .filter(t -> t.getHealCareCategory().getName().equals("BASE"))
//                .collect(Collectors.toList());
//    }


    public List<Partner> getPartners() {
        return partners;
    }

    public List<BaseEmployee> getEmployees() {
        return employees;
    }

    public BaseEmployee getEmployee() {
       return employees.get(new Random().nextInt(employees.size() - 1));
    }

    public Partner getRandomPartner() {
       return partners.get(new Random().nextInt(employees.size() - 1));
    }

    public AbstractHealthCarePlan getRandomHealthCarePlan() {
       return healthCarePlans.get(new Random().nextInt(healthCarePlans.size() -1 ));
    }

    public List<AbstractHealthCarePlan> getHealthCarePlans() {
        return healthCarePlans;
    }

    public void setHealthCarePlans(List<AbstractHealthCarePlan> healthCarePlans) {
        this.healthCarePlans = healthCarePlans;
    }
}
