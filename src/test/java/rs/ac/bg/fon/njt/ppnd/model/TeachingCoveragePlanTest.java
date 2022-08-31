package rs.ac.bg.fon.njt.ppnd.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import rs.ac.bg.fon.njt.ppnd.util.DepartmentType;
import rs.ac.bg.fon.njt.ppnd.util.SubjectType;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TeachingCoveragePlanTest {
    TeachingCoveragePlan tcp;

    @BeforeEach
    void setUp() throws Exception{
        tcp = new TeachingCoveragePlan();
    }

    @AfterEach
    void tearDown() throws Exception {
        tcp = null;
    }

    @Test
    void testSetId(){
        tcp.setId(1L);
        assertEquals(1L, tcp.getId());
    }

    @Test
    void testSetModuleSubject(){
        StudyProgram sp = new StudyProgram(1L, "Finansijski menadzment");
        Module module = new Module(2L, "Racunovodstvo", sp);
        Department d = new Department(3L, "Katedra za finansije", 5, DepartmentType.KATEDRA, null);
        Subject s = new Subject(4L, "Finansijski menadzment i racunovodstvo", 2, 2, 0, d);
        ModuleSubject moduleSubject = new ModuleSubject(5L, 1, 4, SubjectType.OBAVEZNI, 6, s, module);
        tcp.setModuleSubject(moduleSubject);
        assertEquals(moduleSubject, tcp.getModuleSubject());
    }

    @Test
    void testSetModuleSubjectNull(){
        assertThrows(java.lang.IllegalArgumentException.class, ()->tcp.setModuleSubject(null));
    }


    @Test
    void testSetYear(){
        StudyProgram sp = new StudyProgram(1L, "Finansijski menadzment");
        Year year = new Year(2022L, "2022/2023", sp);
        tcp.setYear(year);
        assertEquals(year, tcp.getYear());
    }

    @Test
    void testSetYearNull(){
        assertThrows(java.lang.IllegalArgumentException.class, ()->tcp.setYear(null));
    }

    @Test
    void testToString(){
        tcp.setId(5L);
        String s = tcp.toString();
        assertTrue(s.contains("5"));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, true",
            "1, 2, false"
    })
    void testEqualsObject(Long id1, Long id2, boolean eq){
        tcp.setId(id1);

        TeachingCoveragePlan tcp2 = new TeachingCoveragePlan();
        tcp2.setId(id2);

        assertEquals(eq, tcp.equals(tcp2));
    }




}
