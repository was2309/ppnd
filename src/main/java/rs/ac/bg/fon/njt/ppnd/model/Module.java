package rs.ac.bg.fon.njt.ppnd.model;

import lombok.*;


import javax.persistence.*;

import java.util.List;
import java.util.Set;


@Entity
@Table(name = "module")
public class Module {

    @Id
    @GeneratedValue
    @Column(name = "module_id")
    private Long id;

    @Column(name = "module_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "study_program_id")
    private StudyProgram studyProgram;

    @ToString.Exclude
    @OneToMany(mappedBy = "subject")
    List<ModuleSubject> moduleSubjects;

	public Module(Long id, String name, StudyProgram studyProgram) {
		super();
		this.id = id;
		this.name = name;
		this.studyProgram = studyProgram;
		
	}
	
	

	public Module() {
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

	public StudyProgram getStudyProgram() {
		return studyProgram;
	}

	public void setStudyProgram(StudyProgram studyProgram) {
		this.studyProgram = studyProgram;
	}

	public List<ModuleSubject> getModuleSubjects() {
		return moduleSubjects;
	}

	public void setModuleSubjects(List<ModuleSubject> moduleSubjects) {
		this.moduleSubjects = moduleSubjects;
	}
    
    

}
