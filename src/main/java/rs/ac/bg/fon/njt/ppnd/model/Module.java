package rs.ac.bg.fon.njt.ppnd.model;

import lombok.*;


import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "module")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Module {

    @Id
    @GeneratedValue
    @Column(name = "module_id")
    private Long id;

    @Column(name = "module_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "study_program_id")
    private StudyProgram studyProgram;

    @ToString.Exclude
    @OneToMany(mappedBy = "subject")
    Set<ModuleSubject> moduleSubjects = new java.util.LinkedHashSet<>();

}
