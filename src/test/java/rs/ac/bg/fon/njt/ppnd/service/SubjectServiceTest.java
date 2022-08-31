package rs.ac.bg.fon.njt.ppnd.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.bg.fon.njt.ppnd.converter.ModuleConverter;
import rs.ac.bg.fon.njt.ppnd.converter.SubjectConverter;
import rs.ac.bg.fon.njt.ppnd.dto.*;
import rs.ac.bg.fon.njt.ppnd.model.Department;
import rs.ac.bg.fon.njt.ppnd.model.StudyProgram;
import rs.ac.bg.fon.njt.ppnd.model.Subject;
import rs.ac.bg.fon.njt.ppnd.repository.DepartmentRepository;
import rs.ac.bg.fon.njt.ppnd.repository.ModuleRepository;
import rs.ac.bg.fon.njt.ppnd.repository.ModuleSubjectRepository;
import rs.ac.bg.fon.njt.ppnd.repository.SubjectRepository;
import rs.ac.bg.fon.njt.ppnd.service.impl.SubjectServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class SubjectServiceTest {

    @Mock
    protected SubjectRepository subjectRepository;

    @Mock
    protected SubjectConverter subjectConverter;

    @Mock
    protected ModuleRepository moduleRepository;

    @Mock
    protected ModuleSubjectRepository moduleSubjectRepository;

    @Mock
    protected ModuleService moduleService;

    @Mock
    protected ModuleConverter moduleConverter;

    @Mock
    protected DepartmentRepository departmentRepository;

    @InjectMocks
    protected SubjectServiceImpl subjectService;

    protected Subject subject;

    protected Department department;

    protected SubjectDTO inDTO;


    @Test
    public void getSubjectById(){
        subject.setId(4L);
        Mockito.when(subjectRepository.findById(subject.getId())).thenReturn(Optional.of(subject));

        SubjectDTO found = subjectService.getById(4L);

        SubjectDTO converted = new SubjectDTO();
        converted.setId(subject.getId());
        converted.setName(subject.getName());
        converted.setLecutresPerWeek(subject.getLecutresPerWeek());
        converted.setExercisesPerWeek(subject.getExcerciesPerWeek());
        converted.setLabExercisesPerWeek(subject.getLabExcercisesPerWeek());

        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(subject.getDepartment().getId());
        departmentDTO.setName(subject.getDepartment().getName());
        departmentDTO.setNumberOfMembers(subject.getDepartment().getNumberOfMembers());
        converted.setDepartment(departmentDTO);
        List<ModuleSubjectDTO> moduleSubjectDTOS = new ArrayList<>();
        if(subject.getModuleSubjects()!=null){
            subject.getModuleSubjects().forEach(moduleSubject -> {
                ModuleDTO moduleDTO = new ModuleDTO();
                moduleDTO.setId(moduleSubject.getModule().getId());
                moduleDTO.setName(moduleSubject.getModule().getName());

                ModuleSubjectDTO moduleSubjectDTO = new ModuleSubjectDTO();
                moduleSubjectDTO.setModule(moduleDTO);
                moduleSubjectDTO.setSubjectType(moduleSubject.getSubjectType());
                moduleSubjectDTO.setId(moduleSubject.getId());
                moduleSubjectDTO.setPosition(moduleSubject.getPosition());
                moduleSubjectDTO.setNumOfESPB(moduleSubject.getNumOfESPB());
                moduleSubjectDTO.setSemester(moduleSubject.getSemester());
                moduleSubjectDTOS.add(moduleSubjectDTO);
            });
        }

        converted.setModuleSubjects(moduleSubjectDTOS);

        assertEquals(found, converted);
    }

    @Test
    public void getSubjectByIdNotExist() {
        subject.setId(55L);
        Mockito.when(subjectRepository.findById(subject.getId())).thenReturn(Optional.empty());
        assertThrows(ResponseStatusException.class, ()->subjectService.getById(subject.getId()));
    }

    @Test
    public void geAllSubjects(){
        List<Subject> subjectsInDatabase = List.of(
                new Subject(1L, "Programiranje 1", 2, 0, 2, department),
                new Subject(2L, "Programiranje 2", 2, 0, 2, department),
                new Subject(3L, "Programiranje 3", 2, 0, 2, department)
        );

        Mockito.when(subjectRepository.findAll()).thenReturn(subjectsInDatabase);
        List<SubjectDTO> retrieved = subjectService.getAllSubjects();
        List<SubjectDTO> converted = new ArrayList<>();
        subjectsInDatabase.forEach(s ->{
            SubjectDTO subjectDTO = subjectConverter.toDto(s);
            converted.add(subjectDTO);
        });

        assertEquals(converted, retrieved);
    }

    @Test
    public void getAllStudyProgramsNoStudyPrograms(){
        List<Subject> subjectsInDatabase = new ArrayList<>();
        Mockito.when(subjectRepository.findAll()).thenReturn(subjectsInDatabase);
        assertThrows(ResponseStatusException.class, ()->subjectService.getAllSubjects());
    }

    @Test
    public void saveSubject(){
        Mockito.when(subjectRepository.save(subject)).thenReturn(subject);
        Mockito.when(departmentRepository.findById(subject.getDepartment().getId())).thenReturn(Optional.of(subject.getDepartment()));


        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setId(subject.getId());
        subjectDTO.setName(subject.getName());
        subjectDTO.setLecutresPerWeek(subject.getLecutresPerWeek());
        subjectDTO.setExercisesPerWeek(subject.getExcerciesPerWeek());
        subjectDTO.setLabExercisesPerWeek(subject.getLabExcercisesPerWeek());
        subjectDTO.setDepartment(new DepartmentDTO(subject.getDepartment().getId(), subject.getDepartment().getName(), subject.getDepartment().getNumberOfMembers()));
        List<ModuleSubjectDTO> moduleSubjectDTOS = new ArrayList<>();
        if(subject.getModuleSubjects()!=null){
            subject.getModuleSubjects().forEach(moduleSubject -> {
                ModuleSubjectDTO moduleSubjectDTO = new ModuleSubjectDTO();
                moduleSubjectDTO.setId(moduleSubject.getId());
                moduleSubjectDTO.setSubjectType(moduleSubject.getSubjectType());
                moduleSubjectDTO.setPosition(moduleSubject.getPosition());
                moduleSubjectDTO.setNumOfESPB(moduleSubject.getNumOfESPB());
                ModuleDTO moduleDTO = new ModuleDTO();
                moduleDTO.setId(moduleSubject.getModule().getId());
                moduleSubjectDTO.setModule(moduleDTO);
                moduleSubjectDTOS.add(moduleSubjectDTO);
            });
        }

        subjectDTO.setModuleSubjects(moduleSubjectDTOS);

        SubjectDTO saved = subjectService.saveSubject(inDTO);

        assertEquals(subjectDTO, saved);
    }

    @Test
    public void saveSubjectDepartmentDoesntExist(){
        Mockito.when(departmentRepository.findById(department.getId())).thenReturn(Optional.empty());
        assertThrows(ResponseStatusException.class, ()->subjectService.saveSubject(inDTO));
    }

    @Test
    public void deleteSubject(){
        subject.setId(75L);
        Mockito.when(subjectRepository.findById(subject.getId())).thenReturn(Optional.of(subject));
        Mockito.doNothing().when(subjectRepository).delete(subject);
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setId(subject.getId());

        assertEquals(subjectDTO, subjectService.deleteSubject(subject.getId()));
    }

    @Test
    public void deleteSubjectDoesntExist(){
        subject.setId(95L);
        assertThrows(ResponseStatusException.class, ()->subjectService.deleteSubject(2088L));
    }

    @Test
    public void updateSubject(){
        subject.setId(1L);
        Subject updatedSubject = new Subject(subject.getId(), "Subject2", 2, 0 ,2, department);
        inDTO = new SubjectDTO();
        inDTO.setId(updatedSubject.getId());
        inDTO.setName(updatedSubject.getName());
        inDTO.setLecutresPerWeek(updatedSubject.getLecutresPerWeek());
        inDTO.setExercisesPerWeek(updatedSubject.getExcerciesPerWeek());
        inDTO.setLabExercisesPerWeek(updatedSubject.getLabExcercisesPerWeek());
        inDTO.setDepartment(new DepartmentDTO(updatedSubject.getDepartment().getId(), updatedSubject.getDepartment().getName(), updatedSubject.getDepartment().getNumberOfMembers()));
        List<ModuleSubjectDTO> moduleSubjectDTOS = new ArrayList<>();
        if(updatedSubject.getModuleSubjects()!=null){
            updatedSubject.getModuleSubjects().forEach(moduleSubject -> {
                ModuleSubjectDTO moduleSubjectDTO = new ModuleSubjectDTO();
                moduleSubjectDTO.setId(moduleSubject.getId());
                moduleSubjectDTO.setSubjectType(moduleSubject.getSubjectType());
                moduleSubjectDTO.setPosition(moduleSubject.getPosition());
                moduleSubjectDTO.setNumOfESPB(moduleSubject.getNumOfESPB());
                ModuleDTO moduleDTO = new ModuleDTO();
                moduleDTO.setId(moduleSubject.getModule().getId());
                moduleSubjectDTO.setModule(moduleDTO);
                moduleSubjectDTOS.add(moduleSubjectDTO);
            });
        }

        inDTO.setModuleSubjects(moduleSubjectDTOS);


        Mockito.when(subjectRepository.findById(subject.getId())).thenReturn(Optional.of(subject));
        Mockito.when(subjectRepository.save(updatedSubject)).thenReturn(updatedSubject);
        Mockito.when(departmentRepository.findById(subject.getDepartment().getId())).thenReturn(Optional.of(subject.getDepartment()));

        SubjectDTO updated = subjectService.updateSubject(inDTO);
        updatedSubject.setId(updatedSubject.getId());
        assertEquals(updated, inDTO);
    }

    @Test
    public void updateSubjectNoSubjectFound(){
        subject.setId(7L);

        Mockito.when(subjectRepository.findById(subject.getId())).thenReturn(Optional.empty());
        assertThrows(ResponseStatusException.class, ()->subjectService.updateSubject(inDTO));
    }

    @Test
    public void updateSubjectNoDeparmtentFound(){
        Mockito.when(departmentRepository.findById(department.getId())).thenReturn(Optional.empty());
        assertThrows(ResponseStatusException.class, ()->subjectService.updateSubject(inDTO));
    }





}
