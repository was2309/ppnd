package rs.ac.bg.fon.njt.ppnd.model;


import lombok.*;


import javax.persistence.*;


@Entity
@Table(name = "study_program")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudyProgram {


    @Id
    @GeneratedValue
    @Column(name = "study_program_id")
    private Long id;

    @Column(name = "study_program_name")
    private String name;


}
