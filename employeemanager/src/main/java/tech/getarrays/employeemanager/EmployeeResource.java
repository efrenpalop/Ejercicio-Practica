package tech.getarrays.employeemanager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.employeemanager.model.Departament;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.service.DepartamentService;
import tech.getarrays.employeemanager.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmployeeService employeeService;
    private final DepartamentService departamentService;

    public EmployeeResource(EmployeeService employeeService, DepartamentService departamentService) {
        this.employeeService = employeeService;
        this.departamentService = departamentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/allDep")
    public ResponseEntity<List<Departament>> getAllDepartaments(){
        List<Departament> departaments = departamentService.findAllDepartaments();
        return new ResponseEntity<>(departaments, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/findByDep/{dep_id}")
    public ResponseEntity<List<Employee>> getEmployeesByDepartament(@PathVariable("dep_id") Long dep_id){
        List<Employee> employees = employeeService.findEmployeesByDepartamentId(dep_id);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        if(employee.getDepartament().getDep_id() != null){}
        System.out.println(employee.getDepartament().getDep_id());
        Departament departament = departamentService.findDepartamentById(employee.getDepartament().getDep_id());
        newEmployee.setDepartament(departament);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PostMapping("addDep")
    public ResponseEntity<Departament> addDepartament(@RequestBody Departament departament){
        Departament newDepartament = departamentService.addDepartament(departament);
        return new ResponseEntity<>(newDepartament, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }
    @PutMapping("/updateDep")
    public ResponseEntity<Departament> updateDepartament(@RequestBody Departament departament){
        Departament updateDepartament = departamentService.updateDepartament(departament);
        return new ResponseEntity<>(updateDepartament, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*@DeleteMapping("/deleteDep/{id}")
    public ResponseEntity<?> deleteDepartament(@PathVariable("dep_id") Long dep_id){
        departamentService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }*/
}
