package rs.ac.bg.fon.njt.ppnd.dto;

import java.util.List;

public class YearDTO {

	private Long id;
	private String studyYear;
	private StudyProgramDTO studyProgram;
	private List<TeachingCoveragePlanDTO>coveragePlans;
	
	
	public YearDTO(Long id, String studyYear, StudyProgramDTO studyProgram,List<TeachingCoveragePlanDTO>coveragePlans) {
		super();
		this.id = id;
		this.studyYear = studyYear;
		this.studyProgram = studyProgram;
		this.coveragePlans=coveragePlans;
	}
	public YearDTO() {
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

	public StudyProgramDTO getStudyProgram() {
		return studyProgram;
	}

	public void setStudyProgram(StudyProgramDTO studyProgram) {
		this.studyProgram = studyProgram;
	}
	public List<TeachingCoveragePlanDTO> getCoveragePlans() {
		return coveragePlans;
	}
	public void setCoveragePlans(List<TeachingCoveragePlanDTO> coveragePlans) {
		this.coveragePlans = coveragePlans;
	}
	
}
