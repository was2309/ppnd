package rs.ac.bg.fon.njt.ppnd.model;


import rs.ac.bg.fon.njt.ppnd.util.TeachingForm;

import javax.persistence.*;
import java.util.Objects;

/**
 * Class that represents lecturing held by specific lecturer for specific teaching form.
 *
 * @author Vasilije
 */
@Entity
@Table(name = "teaching_coverage_plan")
public class Lecturing {

	/**
	 * ID of the lecturing.
	 */
    @Id
    @GeneratedValue
    private Long id;

	/**
	 * Number of classes of the lecturing held by lecturer.
	 */
	private int numberOfClasses;

	/**
	 * Lecturer holding the lecturing.
	 */
    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    private Lecturer lecturer;

	/**
	 * Teaching coverage plan that contains the lecturing.
	 */
	@ManyToOne
    @JoinColumn(name = "teaching_coverage_plan_id")
    private TeachingCoveragePlan teachingCoveragePlan;

	/**
	 * Teaching form of the lecturing.
	 */
    @Enumerated(EnumType.STRING)
    private TeachingForm teachingForm;

	/**
	 * Constructor with parameters.
	 * @param id - id of the lecturing
	 * @param numberOfClasses - Number of classes of the lecturing held by lecturer.
	 * @param lecturer - Lecturer holding the lecturing.
	 * @param teachingCoveragePlan - Teaching coverage plan that contains the lecturing.
	 * @param teachingForm - Teaching form of the lecturing.
	 */
	public Lecturing(Long id, int numberOfClasses, Lecturer lecturer, TeachingCoveragePlan teachingCoveragePlan,
			TeachingForm teachingForm) {
		super();
		this.id = id;
		this.numberOfClasses = numberOfClasses;
		this.lecturer = lecturer;
		this.teachingCoveragePlan = teachingCoveragePlan;
		this.teachingForm = teachingForm;
	}

	/**
	 * Non parameter constructor.
	 */
	public Lecturing() {
	}

	/**
	 * Returns id of the lecturing
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets id of the lecturing.
	 * @param id - id of the lecturing
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns number of classes of the lecturing held by lecturer.
	 * @return numberOfClasses of the lecturing held by lecturer.
	 */
	public int getNumberOfClasses() {
		return numberOfClasses;
	}

	/**
	 * Sets number of classes of the lecturing held by lecturer.
	 * @param numberOfClasses - Number of classes of the lecturing held by lecturer.
	 * @throws IllegalArgumentException
	 */
	public void setNumberOfClasses(int numberOfClasses) {
		if(numberOfClasses < 0 || numberOfClasses > 13) throw new IllegalArgumentException();
		this.numberOfClasses = numberOfClasses;
	}

	/**
	 * Returns lecturer holding the lecturing.
	 * @return lecturer holding the lecturing.
	 */
	public Lecturer getLecturer() {
		return lecturer;
	}

	/**
	 * Sets lecturer holding the lecturing.
	 * @param lecturer - lecturer holding the lecturing.
	 * @throws IllegalArgumentException
	 */
	public void setLecturer(Lecturer lecturer) {
		if(lecturer == null) throw new IllegalArgumentException();
		this.lecturer = lecturer;
	}

	/**
	 * Returns teaching coverage plan that contains the lecturing.
	 * @return teaching coverage plan that contains the lecturing
	 */
	public TeachingCoveragePlan getTeachingCoveragePlan() {
		return teachingCoveragePlan;
	}

	/**
	 * Sets teaching coverage plan that contains the lecturing.
	 * @param teachingCoveragePlan - teaching coverage plan that contains the lecturing.
	 * @throws IllegalArgumentException
	 */
	public void setTeachingCoveragePlan(TeachingCoveragePlan teachingCoveragePlan) {
		if(teachingCoveragePlan == null) throw new IllegalArgumentException();
		this.teachingCoveragePlan = teachingCoveragePlan;
	}

	/**
	 * Returns teaching form of the lecturing.
	 * @return teaching form of the lecturing.
	 */
	public TeachingForm getTeachingForm() {
		return teachingForm;
	}

	/**
	 * Sets teaching form of the lecturing.
	 * @param teachingForm - teaching form of the lecturing.
	 * @throws IllegalArgumentException
	 */
	public void setTeachingForm(TeachingForm teachingForm) {
		if(teachingForm == null) throw new IllegalArgumentException();
		this.teachingForm = teachingForm;
	}

	/**
	 * Cheks if two lecturings are equal
	 * @param o - Object
	 * @return boolean - true if two objects are equal
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Lecturing lecturing = (Lecturing) o;
		return numberOfClasses == lecturing.numberOfClasses && Objects.equals(id, lecturing.id) && Objects.equals(lecturer, lecturing.lecturer) && Objects.equals(teachingCoveragePlan, lecturing.teachingCoveragePlan) && teachingForm == lecturing.teachingForm;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, numberOfClasses, lecturer, teachingCoveragePlan, teachingForm);
	}

	@Override
	public String toString() {
		return "Lecturing{" +
				"id=" + id +
				", numberOfClasses=" + numberOfClasses +
				", lecturer=" + lecturer +
				", teachingCoveragePlan=" + teachingCoveragePlan +
				", teachingForm=" + teachingForm +
				'}';
	}
}
