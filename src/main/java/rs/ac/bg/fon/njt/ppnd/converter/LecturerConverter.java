package rs.ac.bg.fon.njt.ppnd.converter;

import org.springframework.stereotype.Component;
import rs.ac.bg.fon.njt.ppnd.dto.LecturerDTO;
import rs.ac.bg.fon.njt.ppnd.model.Lecturer;

@Component
public class LecturerConverter implements Converter<LecturerDTO, Lecturer>{
    @Override
    public Lecturer toEntity(LecturerDTO lecturerDTO) {
        return new Lecturer(lecturerDTO.getId(), lecturerDTO.getFirstName(), lecturerDTO.getLastName(), lecturerDTO.getAcademicTitle());
    }

    @Override
    public LecturerDTO toDto(Lecturer lecturer) {
        return new LecturerDTO(lecturer.getId(), lecturer.getFirstName(), lecturer.getLastName(), lecturer.getAcademicTitle());
    }
}
