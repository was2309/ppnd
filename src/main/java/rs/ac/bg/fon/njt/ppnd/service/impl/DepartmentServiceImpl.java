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

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final DepartmentConverter departmentConverter;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentConverter departmentConverter) {
        this.departmentRepository = departmentRepository;
        this.departmentConverter = departmentConverter;
    }

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
