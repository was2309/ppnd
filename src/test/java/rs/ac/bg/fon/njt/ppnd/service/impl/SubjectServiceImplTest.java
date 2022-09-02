package rs.ac.bg.fon.njt.ppnd.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import rs.ac.bg.fon.njt.ppnd.dto.*;
import rs.ac.bg.fon.njt.ppnd.model.Department;
import rs.ac.bg.fon.njt.ppnd.model.Module;
import rs.ac.bg.fon.njt.ppnd.model.StudyProgram;
import rs.ac.bg.fon.njt.ppnd.model.Subject;
import rs.ac.bg.fon.njt.ppnd.service.SubjectServiceTest;
import rs.ac.bg.fon.njt.ppnd.util.DepartmentType;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class SubjectServiceImplTest extends SubjectServiceTest {
    @BeforeEach
    public void setUp(){
        department = new Department(1L, "Katedra za matematiku", 9, DepartmentType.KATEDRA, null);
        subject = new Subject(1L, "Matematika 2", 2, 0, 2, department);

        inDTO = new SubjectDTO();
        inDTO.setName(subject.getName());
        inDTO.setLecutresPerWeek(subject.getLecutresPerWeek());
        inDTO.setExercisesPerWeek(subject.getExcerciesPerWeek());
        inDTO.setLabExercisesPerWeek(subject.getLabExcercisesPerWeek());
        inDTO.setDepartment(new DepartmentDTO(subject.getDepartment().getId(), subject.getDepartment().getName(), subject.getDepartment().getNumberOfMembers()));
        List<ModuleSubjectDTO> moduleSubjectDTOS = new ArrayList<>();
        if(subject.getModuleSubjects()!=null) {
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
        inDTO.setModuleSubjects(moduleSubjectDTOS);
        studyProgram = new StudyProgram(1L, "Informacioni sistemi i thenologije");
        module = new Module(1L, "Informacioni sistemi", studyProgram);
    }

    @AfterEach
    public void tearDown(){
        inDTO = null;
        subject = null;
        department = null;
    }
}
