package rs.ac.bg.fon.njt.ppnd.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import rs.ac.bg.fon.njt.ppnd.util.AcademicTitle;
import rs.ac.bg.fon.njt.ppnd.util.DepartmentType;
import rs.ac.bg.fon.njt.ppnd.util.SubjectType;
import rs.ac.bg.fon.njt.ppnd.util.TeachingForm;

public class LecturingTest {
    Lecturing l;

    @BeforeEach
    void setUp() throws Exception{
        l = new Lecturing();
    }

    @AfterEach
    void tearDown() throws Exception {
        l = null;
    }

    @Test
    void testSetId(){
        l.setId(3L);
        assertEquals(3L, l.getId());
    }

    @Test
    void testSetNumberOfClasses(){
        l.setNumberOfClasses(5);
        assertEquals(5, l.getNumberOfClasses());
    }

    @ParameterizedTest
    @CsvSource({
            "-1", "-78", "78", "14"
    })
    void testSetNumberOfClassesNotValid(int numOfClasses){
        assertThrows(java.lang.IllegalArgumentException.class, ()->l.setNumberOfClasses(numOfClasses));
    }

    @Test
    void testSetLecturer(){
        Lecturer lecturer = new Lecturer(3L, "Pera", "Peric", AcademicTitle.ASISTENT);
        l.setLecturer(lecturer);
        assertEquals(lecturer, l.getLecturer());
    }

    @Test
    void testSetLecturerNull(){
        assertThrows(java.lang.IllegalArgumentException.class, ()->l.setLecturer(null));
    }

    @Test
    void testSetTeachingCoveragePlan(){
        StudyProgram sp = new StudyProgram(1L, "Finansijski menadzment");
        Module module = new Module(2L, "Racunovodstvo", sp);
        Department d = new Department(3L, "Katedra za finansije", 5, DepartmentType.KATEDRA, null);
        Subject s = new Subject(4L, "Finansijski menadzment i racunovodstvo", 2, 2, 0, d);
        ModuleSubject moduleSubject = new ModuleSubject(5L, 1, 4, SubjectType.OBAVEZNI, 6, s, module);
        Year year = new Year(2022L, "2022/2023", sp);
        TeachingCoveragePlan tcp = new TeachingCoveragePlan(3L, moduleSubject, year, null);
        l.setTeachingCoveragePlan(tcp);
        assertEquals(tcp, l.getTeachingCoveragePlan());
    }

    @Test
    void testSetTeachingCoveragePlanNull(){
        assertThrows(java.lang.IllegalArgumentException.class, ()->l.setTeachingCoveragePlan(null));
    }

    @Test
    void testSetTeachingForm(){
        l.setTeachingForm(TeachingForm.VEZBE);
        assertEquals(TeachingForm.VEZBE, l.getTeachingForm());
    }

    @Test
    void testSetTeachingFormNull(){
        assertThrows(java.lang.IllegalArgumentException.class, ()->l.setTeachingForm(null));
    }

    @Test
    void testToString(){
        l.setId(6L);
        l.setNumberOfClasses(5);
        l.setTeachingForm(TeachingForm.VEZBE);
        String s = l.toString();

        assertTrue(s.contains("VEZBE"));
        assertTrue(s.contains("6"));
        assertTrue(s.contains("5"));

    }


    @ParameterizedTest
    @CsvSource({
            "1, 1, 5, 5, VEZBE, VEZBE, true",
            "1, 1, 5, 5, VEZBE, PREDAVANJA, false",
            "1, 1, 5, 9, VEZBE, VEZBE, false",
            "1, 2, 5, 5, VEZBE, VEZBE, false",
    })
    void testEqualsObject(Long id1, Long id2, int numOfClasses1, int numOfClasses2, TeachingForm tf1, TeachingForm tf2, boolean eq){
        l.setId(id1);
        l.setNumberOfClasses(numOfClasses1);
        l.setTeachingForm(tf1);

        Lecturing l2 = new Lecturing();
        l2.setId(id2);
        l2.setNumberOfClasses(numOfClasses2);
        l2.setTeachingForm(tf2);

        assertEquals(eq, l.equals(l2));
    }




}
