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

}
