package rs.ac.bg.fon.njt.ppnd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.bg.fon.njt.ppnd.converter.LecturerConverter;
import rs.ac.bg.fon.njt.ppnd.dto.LecturerDTO;
import rs.ac.bg.fon.njt.ppnd.model.Lecturer;
import rs.ac.bg.fon.njt.ppnd.repository.LecturerRepository;
import rs.ac.bg.fon.njt.ppnd.service.LecturerService;

import java.util.ArrayList;
import java.util.List;

public class LecturerServiceImpl implements LecturerService {

    @Autowired
    LecturerRepository lecturerRepository;

    @Autowired
    LecturerConverter lecturerConverter;

    @Override
    public List<LecturerDTO> getAllLecturers() {
        try {
            List<Lecturer> lecturers = this.lecturerRepository.findAll();
            if (lecturers.size() == 0) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No saved lecturers");
            }
            List<LecturerDTO> dto = new ArrayList<>();
            lecturers.forEach((lecturer -> {
                LecturerDTO l = this.lecturerConverter.toDto(lecturer);
                dto.add(l);
            }));
            return dto;
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<LecturerDTO> getLecturersFromDepartment(Long departmentId){
        try {
            List<Lecturer> lecturers = this.lecturerRepository.findByDepartmentId(departmentId);
            if (lecturers.size() == 0) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No saved lecturers for requested department");
            }
            List<LecturerDTO> dto = new ArrayList<>();
            lecturers.forEach((lecturer -> {
                LecturerDTO l = this.lecturerConverter.toDto(lecturer);
                dto.add(l);
            }));
            return dto;
        } catch (Exception e){
            throw e;
        }
    }
}
