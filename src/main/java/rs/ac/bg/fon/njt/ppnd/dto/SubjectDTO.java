package rs.ac.bg.fon.njt.ppnd.dto;

public class SubjectDTO {

	private Long id;
	private String name;
	private int exercisesPerWeek;
	private int labExercisesPerWeek;
	private DepartmentDTO department;
	public SubjectDTO(Long id, String name, int exercisesPerWeek, int labExercisesPerWeek, DepartmentDTO department) {
		super();
		this.id = id;
		this.name = name;
		this.exercisesPerWeek = exercisesPerWeek;
		this.labExercisesPerWeek = labExercisesPerWeek;
		this.department = department;
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
	
	
	
}
