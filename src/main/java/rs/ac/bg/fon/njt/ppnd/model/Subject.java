package rs.ac.bg.fon.njt.ppnd.model;

import lombok.*;
import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "subject")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Subject {
    @Id
    @GeneratedValue
    @Column(name = "subject_id")
    private Long id;

    @Column(name = "subject_name")
    private String name;

    @Column(name = "lectures_per_week")
    private int lecutresPerWeek;
    @Column(name = "excercises_per_week")
    private int excerciesPerWeek;
    @Column(name = "lab_excercises_per_week")
    private int labExcercisesPerWeek;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "module")
    Set<ModuleSubject> moduleSubjects;

}
