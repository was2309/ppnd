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
    @Column(name = "department_id")
    private Long id;

    @Column(name = "department_name")
    private String name;
    private int numberOfMembers;

    @Enumerated(EnumType.STRING)
    @Column(name = "department_type")
    private DepartmentType type;

    @OneToMany
    private Set<Employee> employees;



}
