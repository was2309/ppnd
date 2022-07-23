package rs.ac.bg.fon.njt.ppnd.model;


import javax.persistence.*;


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

	public TeachingCoveragePlan(Long id, ModuleSubject moduleSubject, Year year) {
		super();
		this.id = id;
		this.moduleSubject = moduleSubject;
		this.year = year;
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
	
	

}
