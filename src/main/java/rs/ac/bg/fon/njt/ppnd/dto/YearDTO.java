package rs.ac.bg.fon.njt.ppnd.dto;

public class YearDTO {

	private Long id;
	private String studyYear;
	public YearDTO(Long id, String studyYear) {
		super();
		this.id = id;
		this.studyYear = studyYear;
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
	
	
}
