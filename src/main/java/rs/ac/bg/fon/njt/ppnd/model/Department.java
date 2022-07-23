package rs.ac.bg.fon.njt.ppnd.model;

import rs.ac.bg.fon.njt.ppnd.util.DepartmentType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "department")
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

	public Department(Long id, String name, int numberOfMembers, DepartmentType type, Set<Employee> employees) {
		super();
		this.id = id;
		this.name = name;
		this.numberOfMembers = numberOfMembers;
		this.type = type;
		this.employees = employees;
	}

	public Department() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfMembers() {
		return numberOfMembers;
	}

	public void setNumberOfMembers(int numberOfMembers) {
		this.numberOfMembers = numberOfMembers;
	}

	public DepartmentType getType() {
		return type;
	}

	public void setType(DepartmentType type) {
		this.type = type;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

    
    


}
