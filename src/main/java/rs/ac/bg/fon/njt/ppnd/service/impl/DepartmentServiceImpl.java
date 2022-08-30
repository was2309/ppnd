package rs.ac.bg.fon.njt.ppnd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.bg.fon.njt.ppnd.converter.DepartmentConverter;
import rs.ac.bg.fon.njt.ppnd.dto.DepartmentDTO;
import rs.ac.bg.fon.njt.ppnd.model.Department;
import rs.ac.bg.fon.njt.ppnd.repository.DepartmentRepository;
import rs.ac.bg.fon.njt.ppnd.service.DepartmentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service implementation which contains business logic for department entity
 *
 * @author Vasilije
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    /**
     * Repository for department entity
     */
    private final DepartmentRepository departmentRepository;

    /**
     * Converter for department entity
     */
    private final DepartmentConverter departmentConverter;

    /**
     * Constructor with params
     * @param departmentRepository - Repository for department entity
     * @param departmentConverter - Converter for department entity
     */
    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentConverter departmentConverter) {
        this.departmentRepository = departmentRepository;
        this.departmentConverter = departmentConverter;
    }

    /**
     * Returns list of all departments on the faculty
     * @return List of all departments on the faculty
     * @throws ResponseStatusException - if there is no saved departments
     */
    @Override
    public List<DepartmentDTO> getAllDepartments() {
        try {
            List<Department> departments = this.departmentRepository.findAll();
            if (departments.size() == 0) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No saved departments");
            }
            List<DepartmentDTO> dto = new ArrayList<>();
            departments.forEach((department -> {
                DepartmentDTO d = this.departmentConverter.toDto(department);
                dto.add(d);
            }));
            return dto;
        } catch (Exception e){
            throw e;
        }
    }

    /**
     * Returns department by given id - if recorded
     * @param departmentId - id of the department
     * @return DepartmentDTO - DepartmentDTO object which represents founded department
     * @throws ResponseStatusException - if there is no saved department with given id
     */
    @Override
    public DepartmentDTO getDepartmentById(Long departmentId) {
        try {
            Optional<Department> department = this.departmentRepository.findById(departmentId);
            if(department.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, " No saved department with given id. ");
            }
            return this.departmentConverter.toDto(department.get());
        } catch (Exception e){
            throw e;
        }
    }
}
