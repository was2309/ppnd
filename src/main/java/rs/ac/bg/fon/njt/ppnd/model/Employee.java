package rs.ac.bg.fon.njt.ppnd.model;


import rs.ac.bg.fon.njt.ppnd.util.EducationTitle;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "employee_id")
    private Long id;

    private String firstName;
    private String lastName;
    private Date birthday;

    @Enumerated(EnumType.STRING)
    @Column(name = "education_title")
    private EducationTitle title;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

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

	public Employee() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public EducationTitle getTitle() {
		return title;
	}

	public void setTitle(EducationTitle title) {
		this.title = title;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
    
    

}
