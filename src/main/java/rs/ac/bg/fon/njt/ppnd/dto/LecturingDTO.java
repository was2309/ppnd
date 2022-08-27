package rs.ac.bg.fon.njt.ppnd.dto;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.ac.bg.fon.njt.ppnd.model.Lecturer;
import rs.ac.bg.fon.njt.ppnd.model.TeachingCoveragePlan;
import rs.ac.bg.fon.njt.ppnd.util.TeachingForm;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LecturingDTO {

	private Long id;

	private int numberOfClasses;
	private Long lecturer;

	private TeachingCoveragePlanDTO teachingCoveragePlan;

	private TeachingForm teachingForm;

	public LecturingDTO(Long id, int numberOfClasses, Long lecturer, TeachingCoveragePlanDTO teachingCoveragePlan,
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

	public Long getLecturer() {
		return lecturer;
	}

	public void setLecturer(Long lecturer) {
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