package rs.ac.bg.fon.njt.ppnd.model;



import lombok.*;
import rs.ac.bg.fon.njt.ppnd.util.EducationTitle;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private Date birthday;

    private EducationTitle title;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

}
