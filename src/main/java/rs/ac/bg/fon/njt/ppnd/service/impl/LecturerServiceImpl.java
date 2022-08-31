package rs.ac.bg.fon.njt.ppnd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.bg.fon.njt.ppnd.converter.LecturerConverter;
import rs.ac.bg.fon.njt.ppnd.dto.LecturerDTO;
import rs.ac.bg.fon.njt.ppnd.model.Lecturer;
import rs.ac.bg.fon.njt.ppnd.repository.LecturerRepository;
import rs.ac.bg.fon.njt.ppnd.service.LecturerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service implementation which contains business logic for lecturer entity
 *
 * @author Vasilije
 */
@Service
public class LecturerServiceImpl implements LecturerService {
    /**
     * Repository for lecturer entity
     */
    private final LecturerRepository lecturerRepository;
    /**
     * Converter for lecturer entity
     */
    private final LecturerConverter lecturerConverter;

    /**
     * Constructor with parameters
     * @param lecturerRepository - Repository for lecturer entity
     * @param lecturerConverter - Converter for lecturer entity
     */
    @Autowired
    public LecturerServiceImpl(LecturerRepository lecturerRepository, LecturerConverter lecturerConverter) {
        this.lecturerRepository = lecturerRepository;
        this.lecturerConverter = lecturerConverter;
    }

    /**
     * Returns list of all lecturers on the faculty
     * @return List of all lecturers on the faculty
     * @throws ResponseStatusException - if there is no saved lecturers
     */
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

    /**
     * Returns lecturers by department id - if recorded
     * @param departmentId - id of the department
     * @return List - List of LecturerDTO object which represents founded lecturers
     * @throws ResponseStatusException - if there is no saved lecturers for department with given id
     */
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

    @Override
    public LecturerDTO getLecturerById(Long lecturerId) {
        try {
            Optional<Lecturer> lecturer = this.lecturerRepository.findById(lecturerId);
            if (lecturer.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, " No saved lecturers for given id! ");
            }

            return this.lecturerConverter.toDto(lecturer.get());
        } catch (Exception e){
            throw e;
        }
    }
}
