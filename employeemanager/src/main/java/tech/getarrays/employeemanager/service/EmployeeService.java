package tech.getarrays.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.exeption.UserNotFoundExeption;
import tech.getarrays.employeemanager.model.Departament;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repo.EmployeeRepo;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static java.util.Collections.emptyList;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundExeption("User by id " + id + " was not fonud"));
    }

    public List<Employee> findEmployeesByDepartamentId(Long dep_id){

        List<Employee> listEmployees = employeeRepo.findAll();
        List<Employee> auxList = Collections.<Employee>emptyList();

        for(Employee employee : listEmployees){

            if(employee.getDepartament().getDep_id() == dep_id){
                auxList.add(employee);
            }
        }
        return auxList;
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }
}
