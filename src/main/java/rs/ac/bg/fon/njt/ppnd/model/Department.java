package rs.ac.bg.fon.njt.ppnd.model;

import rs.ac.bg.fon.njt.ppnd.util.DepartmentType;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * Class that represents department on faculty.
 *
 * @author Vasilije
 *
 */
@Entity
@Table(name = "department")
public class Department {

	/**
	 * ID of department.
	 */
    @Id
    @GeneratedValue
    @Column(name = "department_id")
    private Long id;

	/**
	 * Name of department.
	 */
	@Column(name = "department_name")
    private String name;

	/**
	 * Number of employees engaged in department.
	 */
    private int numberOfMembers;

	/**
	 * Type of department.
	 */
	@Enumerated(EnumType.STRING)
    @Column(name = "department_type")
    private DepartmentType type;

	/**
	 * Employees engaged in department.
	 */
    @OneToMany
    private Set<Employee> employees;

	/**
	 * Constructor with parameters
	 * @param id ID of department.
	 * @param name Name of department.
	 * @param numberOfMembers Number of employees engaged in department.
	 * @param type Type of department.
	 * @param employees Employees engaged in department.
	 */
	public Department(Long id, String name, int numberOfMembers, DepartmentType type, Set<Employee> employees) {
		super();
		this.id = id;
		this.name = name;
		this.numberOfMembers = numberOfMembers;
		this.type = type;
		this.employees = employees;
	}

	/**
	 * Non parameter constructor
	 */
	public Department() {
		super();
	}

	/**
	 * Returns id of the department.
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets id of the department.
	 * @param id - id of the department
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the name of the department
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name of the department
	 * @param name - name of the department
	 * @throws IllegalArgumentException - if name is null
	 */
	public void setName(String name) {
		if(name == null) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

	/**
	 * Returns number of employees engaged in the department.
	 * @return numberOfMembers - number of employees engaged in the department
	 */
	public int getNumberOfMembers() {
		return numberOfMembers;
	}

	/**
	 * Sets number of employees engaged in the department.
	 * @param numberOfMembers - number of employees engaged in the department
	 * @throws IllegalArgumentException - if number of members is less than zero
	 */
	public void setNumberOfMembers(int numberOfMembers) {
		if(numberOfMembers < 0){
			throw new IllegalArgumentException();
		}
		this.numberOfMembers = numberOfMembers;
	}

	/**
	 * Returns type of the department.
	 * @return type - type of the department
	 */
	public DepartmentType getType() {
		return type;
	}

	/**
	 * Sets type of the department.
	 * @param type - type of the department
	 * @throws IllegalArgumentException - if department type is null
	 */
	public void setType(DepartmentType type) {
		if(type == null) {
			throw new IllegalArgumentException();
		}
		this.type = type;
	}

	/**
	 * Returns employees engaged in the department.
	 * @return employees - employees engaged in the department
	 */
	public Set<Employee> getEmployees() {
		return employees;
	}

	/**
	 * Sets employees engaged in the department.
	 * @param employees - employees engaged in the department.
	 */
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	/**
	 * Checks if two department objects are equal.
	 * @param o - object
	 * @return boolean - true if objects are equal
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Department that = (Department) o;
		return numberOfMembers == that.numberOfMembers && Objects.equals(id, that.id) && Objects.equals(name, that.name) && type == that.type && Objects.equals(employees, that.employees);
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, name, numberOfMembers, type, employees);
	}

	/**
	 * Returns string representation of department object.
	 * @return string
	 */
	@Override
	public String toString() {
		return "Department{" +
				"id=" + id +
				", name='" + name + '\'' +
				", numberOfMembers=" + numberOfMembers +
				", type=" + type +
				", employees=" + employees +
				'}';
	}
}
