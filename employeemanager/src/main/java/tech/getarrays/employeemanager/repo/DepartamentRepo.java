package tech.getarrays.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.employeemanager.model.Departament;

import java.util.Optional;

public interface DepartamentRepo extends JpaRepository<Departament, Long> {

    Optional<Departament> findDepartamentById(Long dep_id);
}
