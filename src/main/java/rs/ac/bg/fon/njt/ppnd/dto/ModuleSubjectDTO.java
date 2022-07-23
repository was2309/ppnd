package rs.ac.bg.fon.njt.ppnd.dto;

import rs.ac.bg.fon.njt.ppnd.util.SubjectType;

public class ModuleSubjectDTO {

	private Long id;
	private int position;
	private int semester;
	private SubjectType subjectType;
	private int numOfESPB;
	private SubjectDTO subject;
	private ModuleDTO module;

	public ModuleSubjectDTO(Long id, int position, int semester, SubjectType subjectType, int numOfESPB,
			SubjectDTO subject, ModuleDTO module) {
		super();
		this.id = id;
		this.position = position;
		this.semester = semester;
		this.subjectType = subjectType;
		this.numOfESPB = numOfESPB;
		this.subject = subject;
		this.module = module;
	}
	public ModuleSubjectDTO() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public SubjectDTO getSubject() {
		return subject;
	}
	public void setSubject(SubjectDTO subject) {
		this.subject = subject;
	}
	public ModuleDTO getModule() {
		return module;
	}
	public void setModule(ModuleDTO module) {
		this.module = module;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	
	
}
