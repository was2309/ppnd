package rs.ac.bg.fon.njt.ppnd.model;


import javax.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Class that represents subject held on faculty.
 *
 * @author Vasilije
 */
@Entity
@Table(name = "subject")
public class Subject {
	/**
	 * ID of the subject.
	 */
    @Id
    @GeneratedValue
    @Column(name = "subject_id")
    private Long id;
	/**
	 * Name of the subject.
	 */
    @Column(name = "subject_name")
    private String name;

	/**
	 * Number of lectures per week of the subject.
	 */
	@Column(name = "lectures_per_week")
    private int lecutresPerWeek;

	/**
	 * Number of excercies per week of the subject.
	 */
    @Column(name = "excercises_per_week")
    private int excerciesPerWeek;

	/**
	 * Number of lab exercises per week of the subject.
	 */
	@Column(name = "lab_excercises_per_week")
    private int labExcercisesPerWeek;

	/**
	 * Department responsible for the subject.
	 */
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

	/**
	 * List of module subjects for modules on which subject is held.
	 */
	@OneToMany(mappedBy = "module")
    List<ModuleSubject> moduleSubjects;

	/**
	 * Constructor with parameters
	 * @param id
	 * @param name
	 * @param lecutresPerWeek
	 * @param excerciesPerWeek
	 * @param labExcercisesPerWeek
	 * @param department
	 */
	public Subject(Long id, String name, int lecutresPerWeek, int excerciesPerWeek, int labExcercisesPerWeek,
			Department department) {
		super();
		this.id = id;
		this.name = name;
		this.lecutresPerWeek = lecutresPerWeek;
		this.excerciesPerWeek = excerciesPerWeek;
		this.labExcercisesPerWeek = labExcercisesPerWeek;
		this.department = department;
		this.moduleSubjects = moduleSubjects;
	}

	/**
	 * Non parameter constructor
	 */
	public Subject() {
		super();
	}

	/**
	 * Returns id of the subject.
	 * @return id of the subject
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets id of the subject.
	 * @param id - id of the subject.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns name of the subject.
	 * @return name of the subject
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name of the subject.
	 * @param name - name of the subject.
	 * @throws IllegalArgumentException
	 */
	public void setName(String name) {
		if(name == null) throw new IllegalArgumentException();
		this.name = name;
	}

	/**
	 * Returns number of lectures per week of the subject.
	 * @return number of lectures per week of the subject
	 */
	public int getLecutresPerWeek() {
		return lecutresPerWeek;
	}

	/**
	 * Sets number of lectures per week of the subject.
	 * @param lecutresPerWeek - number of lectures per week of the subject.
	 * @throws IllegalArgumentException
	 */
	public void setLecutresPerWeek(int lecutresPerWeek) {
		if(lecutresPerWeek < 0) throw new IllegalArgumentException();
		this.lecutresPerWeek = lecutresPerWeek;
	}

	/**
	 * Returns number of excercies per week of the subject.
	 * @return number of excercies per week of the subject.
	 */
	public int getExcerciesPerWeek() {
		return excerciesPerWeek;
	}

	/**
	 * Sets number of excercies per week of the subject.
	 * @param excerciesPerWeek - number of excercies per week of the subject.
	 * @throws IllegalArgumentException
	 */
	public void setExcerciesPerWeek(int excerciesPerWeek) {
		if(excerciesPerWeek < 0) throw new IllegalArgumentException();
		this.excerciesPerWeek = excerciesPerWeek;
	}

	/**
	 * Returns number of lab excercises per week of the subject.
	 * @return number of lab excercises per week of the subject.
	 */
	public int getLabExcercisesPerWeek() {
		return labExcercisesPerWeek;
	}

	/**
	 * Sets number of lab excercises per week of the subject.
	 * @param labExcercisesPerWeek - number of lab excercises per week of the subject.
	 * @throws IllegalArgumentException
	 */
	public void setLabExcercisesPerWeek(int labExcercisesPerWeek) {
		if(labExcercisesPerWeek < 0) throw new IllegalArgumentException();
		this.labExcercisesPerWeek = labExcercisesPerWeek;
	}

	/**
	 * Returns department of the subject.
	 * @return department of the subject
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * Sets department of the subject
	 * @param department - department of the subject
	 * @throws IllegalArgumentException
	 */
	public void setDepartment(Department department) {
		if(department == null) throw new IllegalArgumentException();
		this.department = department;
	}

	/**
	 * Returns moduleSubjects of the subject.
	 * @return moduleSubjects of the subject
	 */
	public List<ModuleSubject> getModuleSubjects() {
		return moduleSubjects;
	}

	/**
	 * Sets moduleSubjects of the subject
	 * @param moduleSubjects - moduleSubjects of the subject
	 */
	public void setModuleSubjects(List<ModuleSubject> moduleSubjects) {
		this.moduleSubjects = moduleSubjects;
	}

	/**
	 * Checks if two subjects are equal.
	 * @param o - Object
	 * @return boolean - true if two objects are equal
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Subject subject = (Subject) o;
		return lecutresPerWeek == subject.lecutresPerWeek && excerciesPerWeek == subject.excerciesPerWeek && labExcercisesPerWeek == subject.labExcercisesPerWeek && Objects.equals(id, subject.id) && Objects.equals(name, subject.name) && Objects.equals(department, subject.department) && Objects.equals(moduleSubjects, subject.moduleSubjects);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, lecutresPerWeek, excerciesPerWeek, labExcercisesPerWeek, department, moduleSubjects);
	}

	/**
	 * Returns string representation of the subject
	 * @return string
	 */
	@Override
	public String toString() {
		return "Subject{" +
				"id=" + id +
				", name='" + name + '\'' +
				", lecutresPerWeek=" + lecutresPerWeek +
				", excerciesPerWeek=" + excerciesPerWeek +
				", labExcercisesPerWeek=" + labExcercisesPerWeek +
				", department=" + department +
				", moduleSubjects=" + moduleSubjects +
				'}';
	}
}
