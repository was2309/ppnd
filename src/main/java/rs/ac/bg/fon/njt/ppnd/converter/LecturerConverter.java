package rs.ac.bg.fon.njt.ppnd.converter;

import rs.ac.bg.fon.njt.ppnd.dto.LecturerDTO;
import rs.ac.bg.fon.njt.ppnd.model.Lecturer;

public class LecturerConverter implements Converter<LecturerDTO, Lecturer>{
    @Override
    public Lecturer toEntity(LecturerDTO lecturerDTO) {
        return null;
    }

    @Override
    public LecturerDTO toDto(Lecturer lecturer) {
        return new LecturerDTO(lecturer.getId(), lecturer.getFirstName(), lecturer.getLastName(), lecturer.getAcademicTitle());
    }
}
