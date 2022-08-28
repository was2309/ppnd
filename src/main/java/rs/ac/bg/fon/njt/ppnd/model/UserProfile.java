package rs.ac.bg.fon.njt.ppnd.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Class that represents user profile for the app.
 *
 * @author Vasilije
 */
@Entity
@Table(name = "user_profile")
public class UserProfile {

    /**
     * Id of the profile.
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Email of the profile
     */
    private String email;
    /**
     * Password of the profile
     */
    private String password;

    /**
     * Status of the profile
     */
    private String status;

    /**
     * Employee who manages the profile
     */
    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    /**
     * Constructor with parameters.
     * @param id
     * @param email
     * @param password
     * @param status
     * @param employee
     */
    public UserProfile(Long id, String email, String password, String status, Employee employee) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.status = status;
        this.employee = employee;
    }

    /**
     * Non parameter constructor
     */
    public UserProfile() {
    }

    /**
     * Returns id of the profile.
     * @return id of the profile
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id of the profile
     * @param id - id of the profile
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns email of the profile
     * @return email of the profile
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email of the profile.
     * @param email - email of the profile
     * @throws IllegalArgumentException
     */
    public void setEmail(String email) {
        if(email == null) throw new IllegalArgumentException();
        this.email = email;
    }

    /**
     * Returns password of the profile
     * @return password of the profile
     */
    public String getPassword() {
        return password;
    }
    /**
     * Sets password of the profile.
     * @param password - password of the profile
     * @throws IllegalArgumentException
     */
    public void setPassword(String password) {
        if(password == null) throw new IllegalArgumentException();
        this.password = password;
    }

    /**
     * Returns status of the profile
     * @return status of the profile
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status of the profile
     * @param status - status of the profile
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns employee who manages the profile
     * @return employee who manages the profile
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Sets employee who manages the profile
     * @param employee - employee who manages the profile
     */
    public void setEmployee(Employee employee) {
        if (employee == null) throw new IllegalArgumentException();
        this.employee = employee;
    }

    /**
     * Checks if two employees are equal
     * @param o - Object
     * @return boolean - true if two objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return Objects.equals(id, that.id) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(status, that.status) && Objects.equals(employee, that.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, status, employee);
    }

    /**
     * Returns string representation of the user profile
     * @return string
     */
    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", employee=" + employee +
                '}';
    }
}
