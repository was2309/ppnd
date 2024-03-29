package rs.ac.bg.fon.njt.ppnd.service;

import rs.ac.bg.fon.njt.ppnd.dto.LecturerDTO;

import java.util.List;

public interface LecturerService {
    List<LecturerDTO> getAllLecturers();
    List<LecturerDTO> getLecturersFromDepartment(Long departmentId);
    LecturerDTO getLecturerById(Long lecturerId);
//    List<LecturerDTO> getLecturersByLastName(LecturerDTO lecturerDTO); // optional
}
