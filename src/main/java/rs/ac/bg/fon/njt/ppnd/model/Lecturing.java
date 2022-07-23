package rs.ac.bg.fon.njt.ppnd.model;

import lombok.*;
import rs.ac.bg.fon.njt.ppnd.util.TeachingForm;

import javax.persistence.*;


@Entity
@Table(name = "teaching_coverage_plan")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Lecturing {

    @Id
    @GeneratedValue
    private Long id;

    private int numberOfClasses;

    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    private Lecturer lecturer;

    @ManyToOne
    @JoinColumn(name = "teaching_coverage_plan_id")
    private TeachingCoveragePlan teachingCoveragePlan;

    @Enumerated(EnumType.STRING)
    private TeachingForm teachingForm;

	public Lecturing(Long id, int numberOfClasses, Lecturer lecturer, TeachingCoveragePlan teachingCoveragePlan,
			TeachingForm teachingForm) {
		super();
		this.id = id;
		this.numberOfClasses = numberOfClasses;
		this.lecturer = lecturer;
		this.teachingCoveragePlan = teachingCoveragePlan;
		this.teachingForm = teachingForm;
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

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	public TeachingCoveragePlan getTeachingCoveragePlan() {
		return teachingCoveragePlan;
	}

	public void setTeachingCoveragePlan(TeachingCoveragePlan teachingCoveragePlan) {
		this.teachingCoveragePlan = teachingCoveragePlan;
	}

	public TeachingForm getTeachingForm() {
		return teachingForm;
	}

	public void setTeachingForm(TeachingForm teachingForm) {
		this.teachingForm = teachingForm;
	}
    
    
    
}
