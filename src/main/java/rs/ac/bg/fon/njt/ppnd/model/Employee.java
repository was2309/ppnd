package rs.ac.bg.fon.njt.ppnd.model;


import rs.ac.bg.fon.njt.ppnd.util.EducationTitle;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * Class that represents an employee on the faculty.
 *
 * @author Vasilije
 */
@Entity
@Table(name = "employee")
public class Employee {

	/**
	 * ID of the employee.
	 */
    @Id
    @GeneratedValue
    @Column(name = "employee_id")
    private Long id;

	/**
	 * First name of the employee.
	 */
	private String firstName;
	/**
	 * Last name of the employee.
	 */
    private String lastName;
	/**
	 * Birthday of the employee.
	 */
	private Date birthday;

	/**
	 * Education title of the employee.
	 */
    @Enumerated(EnumType.STRING)
    @Column(name = "education_title")
    private EducationTitle title;

	/**
	 * Department of the employee.
	 */
	@ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

	/**
	 * Constructor with parameters.
	 * @param id - ID of the employee.
	 * @param firstName - First name of the employee.
	 * @param lastName - Last name of the employee.
	 * @param birthday - Birthday of the employee.
	 * @param title - Education title of the employee.
	 * @param department - Department of the employee.
	 */
	public Employee(Long id, String firstName, String lastName, Date birthday, EducationTitle title,
			Department department) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.title = title;
		this.department = department;
	}

	/**
	 * Non parameter constructor.
	 */
	public Employee() {
		super();
	}

	/**
	 * Returns id of the employee.
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets id of the employee.
	 * @param id - id of the employee
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns first name of the employee.
	 * @return first name of the employee
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets first name of the employee.
	 * @param firstName - first name of the employee
	 * @throws IllegalArgumentException
	 */
	public void setFirstName(String firstName) {
		if(firstName == null) throw new IllegalArgumentException();
		this.firstName = firstName;
	}

	/**
	 * Returns last name of the employee.
	 * @return lastName of the employee
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets last name of the employee.
	 * @param lastName - last name of the employee
	 * @throws IllegalArgumentException
	 */
	public void setLastName(String lastName) {
		if(lastName == null) throw new IllegalArgumentException();
		this.lastName = lastName;
	}

	/**
	 * Returns birthday of the employee.
	 * @return birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * Sets birthday of the employee.
	 * @param birthday - birthday of the employee
	 * @throws IllegalArgumentException
	 */
	public void setBirthday(Date birthday) {
		if(birthday == null) throw new IllegalArgumentException();
		this.birthday = birthday;
	}

	/**
	 * Returns education title of the employee.
	 * @return title
	 */
	public EducationTitle getTitle() {
		return title;
	}

	/**
	 * Sets education title of the employee.
	 * @param title - education title of the employee
	 * @throws IllegalArgumentException
	 */
	public void setTitle(EducationTitle title) {
		if(title == null) throw new IllegalArgumentException();
		this.title = title;
	}

	/**
	 * Returns department of the employee.
	 * @return department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * Sets department of the employee.
	 * @param department - department of the employee
	 * @throws IllegalArgumentException
	 */
	public void setDepartment(Department department) {
		if(department == null) throw new IllegalArgumentException();
		this.department = department;
	}

	/**
	 * Checks if two employee objects are equal.
	 * @param o - object
	 * @return boolean - true if objects are equal
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		return Objects.equals(id, employee.id) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(birthday, employee.birthday) && title == employee.title && Objects.equals(department, employee.department);
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName, birthday, title, department);
	}

	/**
	 * Returns string representation of the employee
	 * @return string
	 */
	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", birthday=" + birthday +
				", title=" + title +
				", department=" + department +
				'}';
	}
}
