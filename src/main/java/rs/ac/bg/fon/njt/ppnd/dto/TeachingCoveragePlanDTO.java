package rs.ac.bg.fon.njt.ppnd.dto;

public class TeachingCoveragePlanDTO {

	private Long id;
	private YearDTO year;
	private ModuleSubjectDTO moduleSubject;

	public TeachingCoveragePlanDTO(Long id, YearDTO year, ModuleSubjectDTO moduleSubject) {
		super();
		this.id = id;
		this.year = year;
		this.moduleSubject = moduleSubject;
	}

	public TeachingCoveragePlanDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public YearDTO getYear() {
		return year;
	}

	public void setYear(YearDTO year) {
		this.year = year;
	}

	public ModuleSubjectDTO getModuleSubject() {
		return moduleSubject;
	}

	public void setModuleSubject(ModuleSubjectDTO moduleSubject) {
		this.moduleSubject = moduleSubject;
	}

}
