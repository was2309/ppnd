package rs.ac.bg.fon.njt.ppnd.model;


import lombok.*;
import rs.ac.bg.fon.njt.ppnd.util.AcademicTitle;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Lecturer extends Employee {

    @Enumerated(EnumType.STRING)
    @Column(name = "academic_title")
    private AcademicTitle academicTitle;


}
