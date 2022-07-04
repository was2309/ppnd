package rs.ac.bg.fon.njt.ppnd.model;

import lombok.*;
import rs.ac.bg.fon.njt.ppnd.model.keys.TeachingCoveragePlanId;

import javax.persistence.*;


@Entity
@Table(name = "teaching_coverage_plan")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeachingCoveragePlan {

    @EmbeddedId
    private TeachingCoveragePlanId id;

    @ManyToOne
    @JoinColumn(name = "module_subject_id")
    private ModuleSubject moduleSubject;

    @ManyToOne
    @JoinColumn(name = "year_id")
    private Year year;

}
