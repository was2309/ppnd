package rs.ac.bg.fon.njt.ppnd.model;



import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * Class that represents study year on faculty.
 *
 * @author Vasilije
 */
@Entity
@Table(name = "year")
public class Year {

	/**
	 * ID of the year
	 */
    @Id
    @GeneratedValue
    @Column(name = "year_id")
    private Long id;


	/**
	 * Name of the year - e.g. "2022/2023"
	 */
	private String studyYear;

	/**
	 * Study program for the year
	 */
    @ManyToOne
    @JoinColumn(name = "study_program_id")
    private StudyProgram studyProgram;

	/**
	 * Teaching coverage plans of the year.
	 */
	@OneToMany(mappedBy = "moduleSubject")
    private Set<TeachingCoveragePlan> plans;

	/**
	 * Constructor with parameters
	 * @param id - id of the year
	 * @param studyYear - full name of the study year in format YYYY/YYYY e.g. 2022/2023
	 * @param studyProgram - studyProgram for the year
	 */
	public Year(Long id, String studyYear, StudyProgram studyProgram) {
		super();
		this.id = id;
		this.studyYear = studyYear;
		this.studyProgram = studyProgram;
		
	}

	/**
	 * Non parameter constructor
	 */
	public Year() {
		super();
	}

	/**
	 * Returns id of the year.
	 * @return id of the year
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets id of the year
	 * @param id - id of the year
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns name of the year
	 * @return name of the year
	 */
	public String getStudyYear() {
		return studyYear;
	}

	/**
	 * Sets name of the year
	 * @param studyYear - name of the year
	 */
	public void setStudyYear(String studyYear) {
		this.studyYear = studyYear;
	}

	/**
	 * Returns study program of the year.
	 * @return study program of the year
	 */
	public StudyProgram getStudyProgram() {
		return studyProgram;
	}

	/**
	 * Sets study program of the year
	 * @param studyProgram - study program of the year
	 * @throws IllegalArgumentException - if studyProgram is null
	 */
	public void setStudyProgram(StudyProgram studyProgram) {
		if(studyProgram == null) throw new IllegalArgumentException();
		this.studyProgram = studyProgram;
	}

	/**
	 * Returns teaching coverage plans of the year.
	 * @return teaching coverage plans of the year
	 */
	public Set<TeachingCoveragePlan> getPlans() {
		return plans;
	}

	/**
	 * Sets teaching coverage plans of the year
	 * @param plans - teaching coverage plans of the year
	 */
	public void setPlans(Set<TeachingCoveragePlan> plans) {
		this.plans = plans;
	}

	/**
	 * Checks if two years are equal
	 * @param o - Object
	 * @return boolean - true if objects are equal
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Year year = (Year) o;
		return Objects.equals(id, year.id) && Objects.equals(studyYear, year.studyYear) && Objects.equals(studyProgram, year.studyProgram) && Objects.equals(plans, year.plans);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, studyYear, studyProgram, plans);
	}

	/**
	 * Returns string representation of the year
	 * @return string
	 */
	@Override
	public String toString() {
		return "Year{" +
				"id=" + id +
				", studyYear='" + studyYear + '\'' +
				", studyProgram=" + studyProgram +
				", plans=" + plans +
				'}';
	}
}
