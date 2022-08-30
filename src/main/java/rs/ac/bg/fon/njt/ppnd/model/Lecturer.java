package rs.ac.bg.fon.njt.ppnd.model;


import rs.ac.bg.fon.njt.ppnd.util.AcademicTitle;

import javax.persistence.*;
import java.util.Objects;

/**
 * Class that represents Lecturer on the faculty.
 *
 * @author Vasilije
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Lecturer extends Employee {

	/**
	 * Academic title of the lecturer.
	 */
    @Enumerated(EnumType.STRING)
    @Column(name = "academic_title")
    private AcademicTitle academicTitle;

	/**
	 * Constructor with parameters.
	 * @param academicTitle - academic title of the lecturer
	 */
	public Lecturer(AcademicTitle academicTitle) {
		super();
		this.academicTitle = academicTitle;
	}

	/**
	 * Non parameter constructor.
	 */
	public Lecturer() {
	}

	/**
	 * Constructor with parameters.
	 * @param id - id of the lecturer
	 * @param firstName - first name of the lecturer
	 * @param lastName - last name of the lecturer
	 * @param academicTitle - academic title of the lecturer
	 */
    public Lecturer(Long id, String firstName, String lastName, AcademicTitle academicTitle) {
		this.setId(id);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.academicTitle = academicTitle;
    }

	/**
	 * Returns academic title of the lecturer.
	 * @return academicTitle
	 */
	public AcademicTitle getAcademicTitle() {
		return academicTitle;
	}

	/**
	 * Sets academic title of the lecturer.
	 *
	 * @param academicTitle - academic title of the lecturer
	 * @throws IllegalArgumentException - if academic title is null
	 */
	public void setAcademicTitle(AcademicTitle academicTitle) {
		if(academicTitle == null) throw new IllegalArgumentException();
		this.academicTitle = academicTitle;
	}

	/**
	 * Checks if two lecturer objects are equal.
	 * @param o - object
	 * @return boolean - true if objects are equal
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Lecturer lecturer = (Lecturer) o;
		return academicTitle == lecturer.academicTitle;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), academicTitle);
	}

	@Override
	public String toString() {
		return "Lecturer{" +
				"academicTitle=" + academicTitle +
				'}';
	}
}
