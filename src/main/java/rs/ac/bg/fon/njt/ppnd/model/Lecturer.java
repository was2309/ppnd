package rs.ac.bg.fon.njt.ppnd.model;


import lombok.*;
import rs.ac.bg.fon.njt.ppnd.util.AcademicTitle;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Lecturer extends Employee {

    private AcademicTitle academicTitle;


}
