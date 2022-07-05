package rs.ac.bg.fon.njt.ppnd.model;

import lombok.*;

import rs.ac.bg.fon.njt.ppnd.util.SubjectType;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "module_subject")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ModuleSubject {

   @Id
   @GeneratedValue
   private Long id;

    private int position;
    private int semester;
    @Enumerated(EnumType.STRING)
    @Column(name = "subject_type")
    private SubjectType subjectType;
    @Column(name = "num_of_espb")
    private int numOfESPB;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    @OneToMany(mappedBy = "year")
    private Set<TeachingCoveragePlan> plans;

}
