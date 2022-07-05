package rs.ac.bg.fon.njt.ppnd.model;

import lombok.*;


import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "year")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Year {

    @Id
    @GeneratedValue
    private Long id;


    private String studyYear;

    @ManyToOne
    @JoinColumn(name = "study_program_id")
    private StudyProgram studyProgram;

    @OneToMany(mappedBy = "moduleSubject")
    private Set<TeachingCoveragePlan> plans;

}
