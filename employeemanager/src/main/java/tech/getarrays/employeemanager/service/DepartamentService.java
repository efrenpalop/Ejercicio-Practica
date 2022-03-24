package tech.getarrays.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.exeption.UserNotFoundExeption;
import tech.getarrays.employeemanager.model.Departament;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repo.DepartamentRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class DepartamentService {

    private final DepartamentRepo departamentRepo;

    @Autowired
    public DepartamentService(DepartamentRepo departamentRepo){
        this.departamentRepo = departamentRepo;
    }

    public List<Departament> findAllDepartaments(){
        return departamentRepo.findAll();
    }

    public Departament addDepartament(Departament departament){
        return departamentRepo.save(departament);
    }

    public Departament updateDepartament(Departament departament){

        return departamentRepo.save(departament);
    }

    public Departament findDepartamentById(Long dep_id){
        return departamentRepo.findDepartamentById(dep_id)
                .orElseThrow(() -> new UserNotFoundExeption("Departament by id " + dep_id + " was not fonud"));
    }
}
