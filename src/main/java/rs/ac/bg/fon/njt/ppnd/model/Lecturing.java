package rs.ac.bg.fon.njt.ppnd.model;

import lombok.*;
import rs.ac.bg.fon.njt.ppnd.model.keys.LecturingId;
import rs.ac.bg.fon.njt.ppnd.util.TeachingForm;

import javax.persistence.*;


@Entity
@Table(name = "teaching_coverage_plan")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Lecturing {

    @EmbeddedId
    private LecturingId id;

    private int numberOfClasses;

    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    private Lecturer lecturer;

    private TeachingForm teachingForm;

}
