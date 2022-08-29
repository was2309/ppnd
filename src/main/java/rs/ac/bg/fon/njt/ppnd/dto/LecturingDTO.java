package rs.ac.bg.fon.njt.ppnd.dto;


import rs.ac.bg.fon.njt.ppnd.util.TeachingForm;


public class LecturingDTO {

	private Long id;

	private int numberOfClasses;
	private LecturerDTO lecturer;

	private TeachingCoveragePlanDTO teachingCoveragePlan;

	private TeachingForm teachingForm;

	public LecturingDTO(Long id, int numberOfClasses, LecturerDTO lecturer, TeachingCoveragePlanDTO teachingCoveragePlan,
			TeachingForm teachingForm) {
		super();
		this.id = id;
		this.numberOfClasses = numberOfClasses;
		this.lecturer = lecturer;
		this.teachingCoveragePlan = teachingCoveragePlan;
		this.teachingForm = teachingForm;
	}

	public LecturingDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumberOfClasses() {
		return numberOfClasses;
	}

	public void setNumberOfClasses(int numberOfClasses) {
		this.numberOfClasses = numberOfClasses;
	}

	public LecturerDTO getLecturer() {
		return lecturer;
	}

	public void setLecturer(LecturerDTO lecturer) {
		this.lecturer = lecturer;
	}

	public TeachingCoveragePlanDTO getTeachingCoveragePlan() {
		return teachingCoveragePlan;
	}

	public void setTeachingCoveragePlan(TeachingCoveragePlanDTO teachingCoveragePlan) {
		this.teachingCoveragePlan = teachingCoveragePlan;
	}

	public TeachingForm getTeachingForm() {
		return teachingForm;
	}

	public void setTeachingForm(TeachingForm teachingForm) {
		this.teachingForm = teachingForm;
	}

	
	
}