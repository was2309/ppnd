package rs.ac.bg.fon.njt.ppnd.dto;

import java.util.List;

public class ModuleDTO {

	private Long id;
	private String name;
	private List<ModuleSubjectDTO> moduleSubject;
	private StudyProgramDTO studyProgram;

	public ModuleDTO(Long id, String name, List<ModuleSubjectDTO> moduleSubject, StudyProgramDTO studyProgram) {
		super();
		this.id = id;
		this.name = name;
		this.moduleSubject = moduleSubject;
		this.studyProgram = studyProgram;
	}

	public ModuleDTO() {
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

	public List<ModuleSubjectDTO> getModuleSubject() {
		return moduleSubject;
	}

	public void setModuleSubject(List<ModuleSubjectDTO> moduleSubject) {
		this.moduleSubject = moduleSubject;
	}

	public StudyProgramDTO getStudyProgram() {
		return studyProgram;
	}

	public void setStudyProgram(StudyProgramDTO studyProgram) {
		this.studyProgram = studyProgram;
	}

}
