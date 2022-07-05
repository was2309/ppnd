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
    @Column(name = "employee_id")
    private Long id;

    private String firstName;
    private String lastName;
    private Date birthday;

    @Enumerated(EnumType.STRING)
    @Column(name = "education_title")
    private EducationTitle title;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

}
