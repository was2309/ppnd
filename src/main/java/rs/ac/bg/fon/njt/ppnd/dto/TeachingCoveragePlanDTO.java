package rs.ac.bg.fon.njt.ppnd.dto;

import rs.ac.bg.fon.njt.ppnd.model.Lecturing;

import java.util.List;
import java.util.Objects;

public class TeachingCoveragePlanDTO {

	private Long id;
	private YearDTO year;
	private ModuleSubjectDTO moduleSubject;
	private List<LecturingDTO> lecturings;

	public TeachingCoveragePlanDTO(Long id, YearDTO year, ModuleSubjectDTO moduleSubject, List<LecturingDTO> lecturings) {
		super();
		this.id = id;
		this.year = year;
		this.moduleSubject = moduleSubject;
		this.lecturings = lecturings;
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

	public List<LecturingDTO> getLecturings() {
		return lecturings;
	}

	public void setLecturings(List<LecturingDTO> lecturings) {
		this.lecturings = lecturings;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TeachingCoveragePlanDTO that = (TeachingCoveragePlanDTO) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
