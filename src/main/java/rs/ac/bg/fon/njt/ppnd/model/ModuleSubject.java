package rs.ac.bg.fon.njt.ppnd.model;



import rs.ac.bg.fon.njt.ppnd.util.SubjectType;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "module_subject")

public class ModuleSubject {

   @Id
   @GeneratedValue
   private Long id;

    private int position;
    private int semester;
    @Enumerated(EnumType.STRING)
    @Column(name = "subject_type")
    private SubjectType subjectType;
    @Column(name = "num_of_espb")
    private int numOfESPB;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    @OneToMany(mappedBy = "year")
    private Set<TeachingCoveragePlan> plans;

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

	public ModuleSubject() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public SubjectType getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(SubjectType subjectType) {
		this.subjectType = subjectType;
	}

	public int getNumOfESPB() {
		return numOfESPB;
	}

	public void setNumOfESPB(int numOfESPB) {
		this.numOfESPB = numOfESPB;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Set<TeachingCoveragePlan> getPlans() {
		return plans;
	}

	public void setPlans(Set<TeachingCoveragePlan> plans) {
		this.plans = plans;
	}
    
    

}
