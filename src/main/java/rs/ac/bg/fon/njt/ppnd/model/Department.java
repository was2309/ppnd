package rs.ac.bg.fon.njt.ppnd.model;

import lombok.*;
import rs.ac.bg.fon.njt.ppnd.util.DepartmentType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "department")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Department {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int numOfMembers;

    private DepartmentType type;

    @OneToMany
    private Set<Employee> employees;



}
