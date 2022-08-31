package rs.ac.bg.fon.njt.ppnd.model;



import javax.persistence.*;
import java.util.Objects;

/**
 * Class that represents study program on faculty.
 *
 * @author Vasilije
 */
@Entity
@Table(name = "study_program")
public class StudyProgram {

	/**
	 * ID of study program.
	 */
    @Id
    @GeneratedValue
    @Column(name = "study_program_id")
    private Long id;

	/**
	 * Name of study program.
	 */
    @Column(name = "study_program_name")
    private String name;

	/**
	 * Constructor with parameters.
	 * @param id - id of the study program
	 * @param name - name of the study program
	 */
	public StudyProgram(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * Non parameter constructor
	 */
	public StudyProgram() {
		super();
	}

	/**
	 * Returns id of study program.
	 * @return id of study program
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets id of study program.
	 * @param id - id of study program
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns name of study program.
	 * @return name of study program.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name of study program.
	 * @param name - name of study program
	 * @throws IllegalArgumentException - if name is null
	 */
	public void setName(String name) {
		if(name == null) throw new IllegalArgumentException();
		this.name = name;
	}

	/**
	 * Checks if two study programs are equal
	 * @param o - Object
	 * @return boolean - true if two objects are equal
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		StudyProgram that = (StudyProgram) o;
		return Objects.equals(id, that.id) && Objects.equals(name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	/**
	 * Returns string representation of study program.
	 * @return string
	 */
	@Override
	public String toString() {
		return "StudyProgram{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
