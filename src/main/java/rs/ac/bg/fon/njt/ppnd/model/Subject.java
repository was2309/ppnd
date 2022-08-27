package rs.ac.bg.fon.njt.ppnd.model;

import lombok.*;
import javax.persistence.*;

import java.util.List;
import java.util.Set;


@Entity
@Table(name = "subject")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Subject {
    @Id
    @GeneratedValue
    @Column(name = "subject_id")
    private Long id;

    @Column(name = "subject_name")
    private String name;

    @Column(name = "lectures_per_week")
    private int lecutresPerWeek;
    @Column(name = "excercises_per_week")
    private int excercisesPerWeek;
    @Column(name = "lab_excercises_per_week")
    private int labExcercisesPerWeek;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    
    @OneToMany(mappedBy = "module",fetch = FetchType.EAGER)
    List<ModuleSubject> moduleSubjects;

	public Subject(Long id, String name, int lecutresPerWeek, int excerciesPerWeek, int labExcercisesPerWeek,
			Department department) {
		super();
		this.id = id;
		this.name = name;
		this.lecutresPerWeek = lecutresPerWeek;
		this.excerciesPerWeek = excerciesPerWeek;
		this.labExcercisesPerWeek = labExcercisesPerWeek;
		this.department = department;
	}

	public Subject() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLecutresPerWeek() {
		return lecutresPerWeek;
	}

	public void setLecutresPerWeek(int lecutresPerWeek) {
		this.lecutresPerWeek = lecutresPerWeek;
	}

	public int getExcerciesPerWeek() {
		return excerciesPerWeek;
	}

	public void setExcerciesPerWeek(int excerciesPerWeek) {
		this.excerciesPerWeek = excerciesPerWeek;
	}

	public int getLabExcercisesPerWeek() {
		return labExcercisesPerWeek;
	}

	public void setLabExcercisesPerWeek(int labExcercisesPerWeek) {
		this.labExcercisesPerWeek = labExcercisesPerWeek;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<ModuleSubject> getModuleSubjects() {
		return moduleSubjects;
	}

	public void setModuleSubjects(List<ModuleSubject> moduleSubjects) {
		this.moduleSubjects = moduleSubjects;
	}
    
    
    

}
