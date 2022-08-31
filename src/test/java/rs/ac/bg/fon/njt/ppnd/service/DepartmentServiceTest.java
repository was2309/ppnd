package rs.ac.bg.fon.njt.ppnd.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.bg.fon.njt.ppnd.converter.DepartmentConverter;
import rs.ac.bg.fon.njt.ppnd.dto.DepartmentDTO;
import rs.ac.bg.fon.njt.ppnd.model.Department;
import rs.ac.bg.fon.njt.ppnd.repository.DepartmentRepository;
import rs.ac.bg.fon.njt.ppnd.service.impl.DepartmentServiceImpl;
import rs.ac.bg.fon.njt.ppnd.util.DepartmentType;
import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class DepartmentServiceTest {

    @Mock
    protected DepartmentRepository departmentRepository;

    @Mock
    protected DepartmentConverter departmentConverter;

    @InjectMocks
    protected DepartmentServiceImpl departmentService;

    protected Department department;


    @Test
    public void getAllDepartments() throws Exception{
        List<Department> departmentsInDatabase = List.of(
                new Department(1L, "Katedra za elektronsko poslovanje", 6, DepartmentType.KATEDRA, null),
                new Department(2L, "Katedra za marketing", 4, DepartmentType.KATEDRA, null),
                new Department(3L, "Katedra za informacione sisteme", 7, DepartmentType.KATEDRA, null)
        );

        Mockito.when(departmentRepository.findAll()).thenReturn(departmentsInDatabase);

        List<DepartmentDTO> retrieved  = departmentService.getAllDepartments();
        List<DepartmentDTO> converted = new ArrayList<>();
        departmentsInDatabase.forEach(department -> {
            DepartmentDTO d = this.departmentConverter.toDto(department);
            converted.add(d);
        });
        assertEquals(retrieved, converted);
    }

    @Test
    public void getAllDepartmentsNoDepartmentsSaved(){
        List<Department> departmentsInDatabase = new ArrayList<>();
        Mockito.when(departmentRepository.findAll()).thenReturn(departmentsInDatabase);
        assertThrows(ResponseStatusException.class, ()->departmentService.getAllDepartments());
    }

    @Test
    public void getDepartmentById() throws Exception{
        department.setId(2L);
        Mockito.when(departmentRepository.findById(department.getId())).thenReturn(Optional.of(department));

        DepartmentDTO found = departmentService.getDepartmentById(2L);

        assertEquals(found, departmentConverter.toDto(department));
    }

    @Test
    public void getDepartmentByIdNotExist() {
        department.setId(150L);
        Mockito.when(departmentRepository.findById(department.getId())).thenReturn(Optional.empty());
        assertThrows(ResponseStatusException.class, ()->departmentService.getDepartmentById(department.getId()));
    }




}
