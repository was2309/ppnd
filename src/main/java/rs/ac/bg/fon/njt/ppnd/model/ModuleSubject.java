package rs.ac.bg.fon.njt.ppnd.model;



import rs.ac.bg.fon.njt.ppnd.util.SubjectType;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * Class that represents associative class between subject and module.
 *
 * @author Vasilije
 */
@Entity
@Table(name = "module_subject")

public class ModuleSubject {

	/**
	 * Module subject id.
	 */
   @Id
   @GeneratedValue
   private Long id;

	/**
	 * Position of the subject in specific module.
	 */
	private int position;
	/**
	 * Semester in which subject is held.
	 */
    private int semester;

	/**
	 * Type of subject in the module.
	 */
	@Enumerated(EnumType.STRING)
    @Column(name = "subject_type")
    private SubjectType subjectType;

	/**
	 * Number of ESPB that subject has in specific module
	 */
    @Column(name = "num_of_espb")
    private int numOfESPB;

	/**
	 * Subject on specific module
	 */
	@ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

	/**
	 * Module which has subjects
	 */
    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

	/**
	 * Teaching Coverage Plan that is created for specific subject on the module for specific year
	 */
	@OneToMany(mappedBy = "year")
    private Set<TeachingCoveragePlan> plans;

	/**
	 * Constructor with parameters
	 * @param id - id of the moduleSubject
	 * @param position - position of the subject in the module
	 * @param semester - semester in which subject is executed in the module
	 * @param subjectType - type of the subject in the module
	 * @param numOfESPB - number of ESPB point for subject in th module
	 * @param subject - subject
	 * @param module - module
	 */
	public ModuleSubject(Long id, int position, int semester, SubjectType subjectType, int numOfESPB, Subject subject,
			Module module) {
		super();
		this.id = id;
		this.position = position;
		this.semester = semester;
		this.subjectType = subjectType;
		this.numOfESPB = numOfESPB;
		this.subject = subject;
		this.module = module;
	}

	/**
	 * Non parameter constructor
	 */
	public ModuleSubject() {
		super();
	}

	/**
	 * Returns ID of the moduleSubject
	 * @return id of the moduleSubject
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets id of the moduleSubject.
	 * @param id - id of the moduleSubject
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns position of the subject on the module.
	 * @return position of the subject on the module
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * Sets position of the subject on the module
	 * @param position - position of the subject on the module
	 * @throws IllegalArgumentException - if position is less than 0
	 */
	public void setPosition(int position) {
		if(position <0 ) throw new IllegalArgumentException();
		this.position = position;
	}

	/**
	 * Returns semester of the subject on the module.
	 * @return semester of the subject on the module
	 */
	public int getSemester() {
		return semester;
	}

	/**
	 * Sets semester of the subject on the module
	 * @param semester - semester of the subject on the module
	 * @throws IllegalArgumentException - if semester is less than 0 and greater than 13
	 */
	public void setSemester(int semester) {
		if(semester < 0 || semester > 8) throw new IllegalArgumentException();
		this.semester = semester;
	}

	/**
	 * Returns type of subject.
	 * @return type of subject
	 */
	public SubjectType getSubjectType() {
		return subjectType;
	}

	/**
	 * Sets type of subject.
	 * @param subjectType - type of subject
	 * @throws IllegalArgumentException - if subject type is null
	 */
	public void setSubjectType(SubjectType subjectType) {
		if(subjectType == null) throw new IllegalArgumentException();
		this.subjectType = subjectType;
	}

	/**
	 * Returns number of ESPB of subject.
	 * @return number of ESPB of subject
	 */
	public int getNumOfESPB() {
		return numOfESPB;
	}

	/**
	 * Sets number of ESPB of subject.
	 * @param numOfESPB - number of ESPB of subject
	 * @throws IllegalArgumentException - if number of ESPB is less than 0
	 */
	public void setNumOfESPB(int numOfESPB) {
		if(numOfESPB < 0) throw new IllegalArgumentException();
		this.numOfESPB = numOfESPB;
	}

	/**
	 * Returns subject of moduleSubject.
	 * @return subject of moduleSubject
	 */
	public Subject getSubject() {
		return subject;
	}

	/**
	 * Sets subject of moduleSubject.
	 * @param subject - subject of moduleSubject
	 * @throws IllegalArgumentException - if subject is null
	 */
	public void setSubject(Subject subject) {
		if(subject == null) throw new IllegalArgumentException();
		this.subject = subject;
	}

	/**
	 * Returns module of moduleSubject.
	 * @return module of moduleSubject
	 */
	public Module getModule() {
		return module;
	}

	/**
	 * Sets module of moduleSubject.
	 * @param module - module of moduleSubject
	 * @throws IllegalArgumentException - if module is null
	 */
	public void setModule(Module module) {
		if(module == null) throw new IllegalArgumentException();
		this.module = module;
	}

	/**
	 * Returns teaching coverage plans for specific moduleSubject.
	 * @return teaching coverage plans for specific moduleSubject
	 */
	public Set<TeachingCoveragePlan> getPlans() {
		return plans;
	}

	/**
	 * Sets teaching coverage plans for specific moduleSubject.
	 * @param plans - teaching coverage plans for specific moduleSubject.
	 */
	public void setPlans(Set<TeachingCoveragePlan> plans) {
		this.plans = plans;
	}

	/**
	 * Checks if two moduleSubject objects are equal
	 * @param o - Object
	 * @return boolean - true if objects are equal
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ModuleSubject that = (ModuleSubject) o;
		return position == that.position && semester == that.semester && numOfESPB == that.numOfESPB && Objects.equals(id, that.id) && subjectType == that.subjectType && Objects.equals(subject, that.subject) && Objects.equals(module, that.module) && Objects.equals(plans, that.plans);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, position, semester, subjectType, numOfESPB, subject, module, plans);
	}

	/**
	 * Returns string representation of moduleSubject
	 * @return string
	 */
	@Override
	public String toString() {
		return "ModuleSubject{" +
				"id=" + id +
				", position=" + position +
				", semester=" + semester +
				", subjectType=" + subjectType +
				", numOfESPB=" + numOfESPB +
				", subject=" + subject +
				", module=" + module +
				", plans=" + plans +
				'}';
	}
}
