package rs.ac.bg.fon.njt.ppnd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import rs.ac.bg.fon.njt.ppnd.util.AcademicTitle;

@Data
@AllArgsConstructor

@Getter
@Setter
public class LecturerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private AcademicTitle academicTitle;

	public LecturerDTO(Long id, String firstName, String lastName, AcademicTitle academicTitle) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.academicTitle = academicTitle;
	}
	public LecturerDTO() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public AcademicTitle getAcademicTitle() {
		return academicTitle;
	}
	public void setAcademicTitle(AcademicTitle academicTitle) {
		this.academicTitle = academicTitle;
	}
    
    

}
