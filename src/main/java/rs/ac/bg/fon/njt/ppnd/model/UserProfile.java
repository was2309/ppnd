package rs.ac.bg.fon.njt.ppnd.model;

import javax.persistence.*;


@Entity
@Table(name = "user_profile")
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

    public UserProfile(Long id, String email, String password, String status, Employee employee) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.status = status;
        this.employee = employee;
    }

    public UserProfile() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
