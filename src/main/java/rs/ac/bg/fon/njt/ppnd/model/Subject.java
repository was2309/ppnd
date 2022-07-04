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
    private Long id;

    private String name;
    private int LecutresPerWeek;
    private int ExcerciesPerWeek;
    private int LabExcercisesPerWeek;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "module")
    Set<ModuleSubject> moduleSubjects;

}
