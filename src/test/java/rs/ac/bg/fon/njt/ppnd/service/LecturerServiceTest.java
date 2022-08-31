package rs.ac.bg.fon.njt.ppnd.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.bg.fon.njt.ppnd.converter.LecturerConverter;
import rs.ac.bg.fon.njt.ppnd.dto.LecturerDTO;
import rs.ac.bg.fon.njt.ppnd.model.Department;
import rs.ac.bg.fon.njt.ppnd.model.Lecturer;
import rs.ac.bg.fon.njt.ppnd.repository.LecturerRepository;
import rs.ac.bg.fon.njt.ppnd.service.impl.LecturerServiceImpl;
import rs.ac.bg.fon.njt.ppnd.util.AcademicTitle;
import rs.ac.bg.fon.njt.ppnd.util.DepartmentType;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class LecturerServiceTest {

    @Mock
    protected LecturerRepository lecturerRepository;

    @Mock
    protected LecturerConverter lecturerConverter;

    @InjectMocks
    protected LecturerServiceImpl lecturerService;

    protected Lecturer lecturer;

    protected Department department;


    @Test
    public void geAllLecturers(){
        List<Lecturer> lecturersInDatabase = List.of(
                new Lecturer(1L, "Mitar", "Miric", AcademicTitle.DOCENT, department),
                new Lecturer(2L, "Branimir", "Stulic", AcademicTitle.REDOVNI_PROF, department),
                new Lecturer(3L, "Zdravko", "Colic", AcademicTitle.VANREDNI_PROF, department)
        );

        Mockito.when(lecturerRepository.findAll()).thenReturn(lecturersInDatabase);
        List<LecturerDTO> retrieved = lecturerService.getAllLecturers();
        List<LecturerDTO> converted = new ArrayList<>();
        lecturersInDatabase.forEach(lecturer1 ->{
            LecturerDTO l = lecturerConverter.toDto(lecturer1);
            converted.add(l);
        });

        assertEquals(converted, retrieved);
    }

    @Test
    public void getAllLecturersNoLecturersSaved(){
        List<Lecturer> lecturersInDatabase = new ArrayList<>();
        Mockito.when(lecturerRepository.findAll()).thenReturn(lecturersInDatabase);
        assertThrows(ResponseStatusException.class, ()->lecturerService.getAllLecturers());
    }

    @Test
    public void getLecturersFromDepartment(){
        Department department2 = new Department(2L, "Katedra za finansijski menadzment", 7, DepartmentType.KATEDRA, null);
        List<Lecturer> lecturersInDatabase = List.of(
                new Lecturer(1L, "Mitar", "Miric", AcademicTitle.DOCENT, department),
                new Lecturer(2L, "Branimir", "Stulic", AcademicTitle.REDOVNI_PROF, department),
                new Lecturer(3L, "Zdravko", "Colic", AcademicTitle.VANREDNI_PROF, department2)
        );
        Mockito.when(lecturerRepository.findByDepartmentId(department.getId())).thenReturn(lecturersInDatabase);
        List<LecturerDTO> retrieved = lecturerService.getLecturersFromDepartment(department.getId());
        List<LecturerDTO> converted = new ArrayList<>();
        lecturersInDatabase.forEach(lecturer1 ->{
            LecturerDTO l = lecturerConverter.toDto(lecturer1);
            converted.add(l);
        });
        assertEquals(converted, retrieved);

    }

    @Test
    public void getLecturerFromDepartmentNoSavedForDepartmentId(){
        Department department2 = new Department(2L, "Katedra za finansijski menadzment", 7, DepartmentType.KATEDRA, null);
        List<Lecturer> lecturersInDatabase = List.of(
                new Lecturer(1L, "Mitar", "Miric", AcademicTitle.DOCENT, department2),
                new Lecturer(2L, "Branimir", "Stulic", AcademicTitle.REDOVNI_PROF, department2),
                new Lecturer(3L, "Zdravko", "Colic", AcademicTitle.VANREDNI_PROF, department2)
        );
        Mockito.when(lecturerRepository.findByDepartmentId(department2.getId())).thenReturn(lecturersInDatabase);
        assertThrows(ResponseStatusException.class, ()->lecturerService.getLecturersFromDepartment(department.getId()));
    }


    @Test
    public void getLecturerById(){
        lecturer.setId(2L);
        Mockito.when(lecturerRepository.findById(lecturer.getId())).thenReturn(Optional.of(lecturer));

        LecturerDTO found = lecturerService.getLecturerById(2L);

        assertEquals(found, lecturerConverter.toDto(lecturer));
    }

    @Test
    public void getDepartmentByIdNotExist() {
        lecturer.setId(250L);
        Mockito.when(lecturerRepository.findById(lecturer.getId())).thenReturn(Optional.empty());
        assertThrows(ResponseStatusException.class, ()->lecturerService.getLecturerById(lecturer.getId()));
    }








}
