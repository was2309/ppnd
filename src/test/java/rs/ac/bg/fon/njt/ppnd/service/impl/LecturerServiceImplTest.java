package rs.ac.bg.fon.njt.ppnd.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import rs.ac.bg.fon.njt.ppnd.model.Department;
import rs.ac.bg.fon.njt.ppnd.model.Lecturer;
import rs.ac.bg.fon.njt.ppnd.service.LecturerServiceTest;
import rs.ac.bg.fon.njt.ppnd.util.AcademicTitle;
import rs.ac.bg.fon.njt.ppnd.util.DepartmentType;

@SpringBootTest
public class LecturerServiceImplTest extends LecturerServiceTest {
    @BeforeEach
    public void setUp(){
        department = new Department(1L, "Katedra za matematiku", 9, DepartmentType.KATEDRA, null);
        lecturer = new Lecturer(1L, "Boban", "Rajovic", AcademicTitle.PROF_EMERITUS, department);
    }

    @AfterEach
    public void tearDown(){
        lecturer = null;
        department = null;
    }
}
