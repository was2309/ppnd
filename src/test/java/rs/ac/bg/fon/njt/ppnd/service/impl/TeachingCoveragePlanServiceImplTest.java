package rs.ac.bg.fon.njt.ppnd.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import rs.ac.bg.fon.njt.ppnd.model.*;
import rs.ac.bg.fon.njt.ppnd.model.Module;
import rs.ac.bg.fon.njt.ppnd.service.TeachingCoveragePlanServiceTest;
import rs.ac.bg.fon.njt.ppnd.util.AcademicTitle;
import rs.ac.bg.fon.njt.ppnd.util.DepartmentType;
import rs.ac.bg.fon.njt.ppnd.util.SubjectType;
import rs.ac.bg.fon.njt.ppnd.util.TeachingForm;

import java.util.ArrayList;

@SpringBootTest
public class TeachingCoveragePlanServiceImplTest extends TeachingCoveragePlanServiceTest {

    @BeforeEach
    public void setUp(){
        department = new Department(1L, "Katedra za matematiku", 9, DepartmentType.KATEDRA, null);
        subject = new Subject(1L, "Matematika 2", 2, 0, 2, department);
        module = new Module(1L, "Informacioni sistemi", new StudyProgram(1L, "Informacioni sistemi i tehnologije"));
        year = new Year(2022L, "2022/2023", new StudyProgram(1L, "Informacioni sistemi i tehnologije"));
        moduleSubject = new ModuleSubject(1L, 2, 4, SubjectType.OBAVEZNI, 6, subject, module);
        teachingCoveragePlan = new TeachingCoveragePlan(1L, moduleSubject, year, null);
        lecturer = new Lecturer(1L, "Petar", "Petrovic", AcademicTitle.VANREDNI_PROF, department);
        lecturing = new Lecturing(1L, 4, lecturer, teachingCoveragePlan, TeachingForm.VEZBE);
        lecturings = new ArrayList<>();
        lecturings.add(lecturing);
        teachingCoveragePlan.setLecturings(lecturings);
    }

}
