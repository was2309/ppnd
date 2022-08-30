package rs.ac.bg.fon.njt.ppnd.model;

import lombok.*;


import javax.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Class that represents module on study program on faculty.
 *
 * @author Vasilije
 */
@Entity
@Table(name = "module")
public class Module {

	/**
	 * ID of the module.
	 */
    @Id
    @GeneratedValue
    @Column(name = "module_id")
    private Long id;

	/**
	 * Name of the module.
	 */
	@Column(name = "module_name")
    private String name;

	/**
	 * Study program that contains the module.
	 */
    @ManyToOne
    @JoinColumn(name = "study_program_id")
    private StudyProgram studyProgram;


	/**
	 * Module subjects on the module.
	 */
	@ToString.Exclude
    @OneToMany(mappedBy = "module")
    List<ModuleSubject> moduleSubjects;

	/**
	 * Constructor with params.
	 * @param id - ID of the module.
	 * @param name - Name of the module.
	 * @param studyProgram - Study program of the module.
	 */
	public Module(Long id, String name, StudyProgram studyProgram) {
		super();
		this.id = id;
		this.name = name;
		this.studyProgram = studyProgram;
		
	}


	/**
	 * Non parameter constructor.
	 */
	public Module() {
		super();
	}

	/**
	 * Returns id of the module.
	 * @return id  of the module
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets id  of the module.
	 * @param id - id  of the module
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns name of the module.
	 * @return name of the module
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name of the module.
	 * @param name - name  of the module
	 * @throws IllegalArgumentException - if name is null
	 */
	public void setName(String name) {
		if(name == null) throw new IllegalArgumentException();
		this.name = name;
	}

	/**
	 * Returns study program of the module.
	 * @return studyProgram of the module
	 */
	public StudyProgram getStudyProgram() {
		return studyProgram;
	}

	/**
	 * Sets study program of the module.
	 * @param studyProgram - study program of the module
	 * @throws IllegalArgumentException - if study program is null
	 */
	public void setStudyProgram(StudyProgram studyProgram) {
		if(studyProgram == null) throw new IllegalArgumentException();
		this.studyProgram = studyProgram;
	}

	/**
	 * Returns module subjects of the module.
	 * @return module subjects of the module
	 */
	public List<ModuleSubject> getModuleSubjects() {
		return moduleSubjects;
	}

	/**
	 * Sets module subjects of the module.
	 * @param moduleSubjects - module subjects of the module
	 */
	public void setModuleSubjects(List<ModuleSubject> moduleSubjects) {
		this.moduleSubjects = moduleSubjects;
	}

	/**
	 * Returns string representation of the module.
	 * @return string
	 */
	@Override
	public String toString() {
		return "Module{" +
				"id=" + id +
				", name='" + name + '\'' +
				", studyProgram=" + studyProgram +
				", moduleSubjects=" + moduleSubjects +
				'}';
	}

	/**
	 * Checks if two module objects are equal.
	 * @param o - Object
	 * @return boolean - true if two objects are equal
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Module module = (Module) o;
		return Objects.equals(id, module.id) && Objects.equals(name, module.name) && Objects.equals(studyProgram, module.studyProgram) && Objects.equals(moduleSubjects, module.moduleSubjects);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, studyProgram, moduleSubjects);
	}
}
