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
    private Long id;


    private String name;


}
