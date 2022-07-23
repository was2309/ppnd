package rs.ac.bg.fon.njt.ppnd.dto;

import java.util.List;

public class SubjectDTO {

	private Long id;
	private String name;
	private int exercisesPerWeek;
	private int labExercisesPerWeek;
	private int lecutresPerWeek;
	private DepartmentDTO department;
	private List<ModuleSubjectDTO>moduleSubjects;


	public SubjectDTO(Long id, String name, int exercisesPerWeek, int labExercisesPerWeek, int lecutresPerWeek,
			DepartmentDTO department, List<ModuleSubjectDTO> moduleSubjects) {
		super();
		this.id = id;
		this.name = name;
		this.exercisesPerWeek = exercisesPerWeek;
		this.labExercisesPerWeek = labExercisesPerWeek;
		this.lecutresPerWeek = lecutresPerWeek;
		this.department = department;
		this.moduleSubjects = moduleSubjects;
	}
	public SubjectDTO() {
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
	public int getExercisesPerWeek() {
		return exercisesPerWeek;
	}
	public void setExercisesPerWeek(int exercisesPerWeek) {
		this.exercisesPerWeek = exercisesPerWeek;
	}
	public int getLabExercisesPerWeek() {
		return labExercisesPerWeek;
	}
	public void setLabExercisesPerWeek(int labExercisesPerWeek) {
		this.labExercisesPerWeek = labExercisesPerWeek;
	}
	public DepartmentDTO getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentDTO department) {
		this.department = department;
	}
	public int getLecutresPerWeek() {
		return lecutresPerWeek;
	}
	public void setLecutresPerWeek(int lecutresPerWeek) {
		this.lecutresPerWeek = lecutresPerWeek;
	}
	public List<ModuleSubjectDTO> getModuleSubjects() {
		return moduleSubjects;
	}
	public void setModuleSubjects(List<ModuleSubjectDTO> moduleSubjects) {
		this.moduleSubjects = moduleSubjects;
	}
	
	
	
}
