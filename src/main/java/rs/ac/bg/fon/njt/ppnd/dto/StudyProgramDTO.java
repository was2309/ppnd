package rs.ac.bg.fon.njt.ppnd.dto;

public class StudyProgramDTO {

	private Long id;
	private String name;

	public StudyProgramDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public StudyProgramDTO() {
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

}
