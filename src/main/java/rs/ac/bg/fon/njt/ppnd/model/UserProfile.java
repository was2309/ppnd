package rs.ac.bg.fon.njt.ppnd.model;

import lombok.*;
import javax.persistence.*;


@Entity
@Table(name = "user_profile")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserProfile {

    @Id
    @GeneratedValue
    private Long id;

    private String email;
    private String password;
    private String status;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


}
