package tech.getarrays.employeemanager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="departament")
public class Departament implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="dep_id", nullable = false, updatable = false)
    private Long id;
    private String name;

    public Departament() {
    }

    public Departament(Long id, String name) {
        super();
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDep_id() {
        return id;
    }

    public void setDep_id(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Departament{" +
                "dep_id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
