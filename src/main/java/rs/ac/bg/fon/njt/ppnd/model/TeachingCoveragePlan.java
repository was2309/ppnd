package rs.ac.bg.fon.njt.ppnd.model;


import javax.persistence.*;
import java.util.List;
import rs.ac.bg.fon.njt.ppnd.model.Lecturing;


@Entity
@Table(name = "teaching_coverage_plan")
public class TeachingCoveragePlan {

    @Id
    @GeneratedValue
    @Column(name = "teaching_coverage_plan_id")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "module_subject_id")
    private ModuleSubject moduleSubject;

    @ManyToOne
    @JoinColumn(name = "year_id")
    private Year year;

    @OneToMany(mappedBy = "teachingCoveragePlan", fetch = FetchType.EAGER)
    private List<Lecturing> lecturings;

	public TeachingCoveragePlan(Long id, ModuleSubject moduleSubject, Year year, List<Lecturing> lecturings) {
		super();
		this.id = id;
		this.moduleSubject = moduleSubject;
		this.year = year;
		this.lecturings = lecturings;
	}

	public TeachingCoveragePlan() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ModuleSubject getModuleSubject() {
		return moduleSubject;
	}

	public void setModuleSubject(ModuleSubject moduleSubject) {
		this.moduleSubject = moduleSubject;
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public List<Lecturing> getLecturings() {
		return lecturings;
	}

	public void setLecturings(List<Lecturing> lecturings) {
		this.lecturings = lecturings;
	}
}
