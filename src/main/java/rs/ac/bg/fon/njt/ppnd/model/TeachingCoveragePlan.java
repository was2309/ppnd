package rs.ac.bg.fon.njt.ppnd.model;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

import rs.ac.bg.fon.njt.ppnd.model.Lecturing;

/**
 * Class that represents teaching coverage plan created for specific subject for semester.
 */
@Entity
@Table(name = "teaching_coverage_plan")
public class TeachingCoveragePlan {

	/**
	 * ID of teaching coverage plan.
	 */
    @Id
    @GeneratedValue
    @Column(name = "teaching_coverage_plan_id")
    private Long id;

	/**
	 * ModuleSubject of teaching coverage plan.
	 */
	@ManyToOne
    @JoinColumn(name = "module_subject_id")
    private ModuleSubject moduleSubject;

	/**
	 * Year of teaching coverage plan.
	 */
    @ManyToOne
    @JoinColumn(name = "year_id")
    private Year year;

	/**
	 * List of lecturings of teaching coverage plan
	 */
    @OneToMany(mappedBy = "teachingCoveragePlan", fetch = FetchType.EAGER)
    private List<Lecturing> lecturings;

	/**
	 * Constructor with parameters
	 * @param id - id of the teaching coverage plan
	 * @param moduleSubject - moduleSubject for the the teaching coverage plan
	 * @param year - year for the teaching coverage plan
	 * @param lecturings - lecturings of the teaching coverage plan
	 */
	public TeachingCoveragePlan(Long id, ModuleSubject moduleSubject, Year year, List<Lecturing> lecturings) {
		super();
		this.id = id;
		this.moduleSubject = moduleSubject;
		this.year = year;
		this.lecturings = lecturings;
	}

	/**
	 * Non parameter constructor
	 */
	public TeachingCoveragePlan() {
		super();
	}

	/**
	 * Returns id of teaching coverage plan
	 * @return id of teaching coverage plan
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets id of teaching coverage plan
	 * @param id - id of teaching coverage plan
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns moduleSubject of teaching coverage plan.
	 * @return moduleSubject of teaching coverage plan
	 */
	public ModuleSubject getModuleSubject() {
		return moduleSubject;
	}

	/**
	 * Sets moduleSubject of teaching coverage plan.
	 * @param moduleSubject - moduleSubject of teaching coverage plan
	 * @throws IllegalArgumentException - if moduleSubject is null
	 */
	public void setModuleSubject(ModuleSubject moduleSubject) {
		if(moduleSubject == null) throw new IllegalArgumentException();
		this.moduleSubject = moduleSubject;
	}

	/**
	 * Returns year of teaching coverage plan.
	 * @return year of teaching coverage plan
	 */
	public Year getYear() {
		return year;
	}

	/**
	 * Sets year of teaching coverage plan.
	 * @param year - year of teaching coverage plan
	 * @throws IllegalArgumentException - if year is null
	 */
	public void setYear(Year year) {
		if(year == null) throw new IllegalArgumentException();
		this.year = year;
	}

	/**
	 * Returns list of lecturings of teaching coverage plan.
	 * @return list of lecturings of teaching coverage plan
	 */
	public List<Lecturing> getLecturings() {
		return lecturings;
	}

	/**
	 * Sets lecturings of of teaching coverage plan
	 * @param lecturings - lecturings of teaching coverage plan
	 */
	public void setLecturings(List<Lecturing> lecturings) {
		this.lecturings = lecturings;
	}

	/**
	 * Checks if two teaching coverage plans are equal
	 * @param o - Object
	 * @return boolean - true if two objects are equal
	 */
	@Override
	public boolean equals(Object o) {

		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TeachingCoveragePlan that = (TeachingCoveragePlan) o;
		return Objects.equals(id, that.id) && Objects.equals(moduleSubject, that.moduleSubject) && Objects.equals(year, that.year) && Objects.equals(lecturings, that.lecturings);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, moduleSubject, year, lecturings);
	}

	/**
	 * Returns string representation of teaching coverage plan.
	 * @return string
	 */
	@Override
	public String toString() {
		return "TeachingCoveragePlan{" +
				"id=" + id +
				", moduleSubject=" + moduleSubject +
				", year=" + year +
				'}';
	}
}
