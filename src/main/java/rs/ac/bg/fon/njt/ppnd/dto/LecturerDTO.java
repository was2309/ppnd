package rs.ac.bg.fon.njt.ppnd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import rs.ac.bg.fon.njt.ppnd.util.AcademicTitle;

@Data
@AllArgsConstructor
public class LecturerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private AcademicTitle academicTitle;
}
