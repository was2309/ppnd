package rs.ac.bg.fon.njt.ppnd.model;



import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "year")
public class Year {

    @Id
    @GeneratedValue
    @Column(name = "year_id")
    private Long id;


    private String studyYear;

    @ManyToOne
    @JoinColumn(name = "study_program_id")
    private StudyProgram studyProgram;

    @OneToMany(mappedBy = "moduleSubject")
    private Set<TeachingCoveragePlan> plans;

	public Year(Long id, String studyYear, StudyProgram studyProgram) {
		super();
		this.id = id;
		this.studyYear = studyYear;
		this.studyProgram = studyProgram;
		
	}

	public Year() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStudyYear() {
		return studyYear;
	}

	public void setStudyYear(String studyYear) {
		this.studyYear = studyYear;
	}

	public StudyProgram getStudyProgram() {
		return studyProgram;
	}

	public void setStudyProgram(StudyProgram studyProgram) {
		this.studyProgram = studyProgram;
	}

	public Set<TeachingCoveragePlan> getPlans() {
		return plans;
	}

	public void setPlans(Set<TeachingCoveragePlan> plans) {
		this.plans = plans;
	}
    
    

}
