package rs.ac.bg.fon.njt.ppnd.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import rs.ac.bg.fon.njt.ppnd.util.DepartmentType;
import rs.ac.bg.fon.njt.ppnd.util.SubjectType;

import static org.junit.jupiter.api.Assertions.*;


public class ModuleSubjectTest {

    ModuleSubject m;

    @BeforeEach
    void setUp() throws Exception {
        m = new ModuleSubject();
    }

    @AfterEach
    void tearDown() throws Exception {
        m = null;
    }

    @Test
    void testSetId() {
        m.setId(3L);
        assertEquals(3L, m.getId());
    }

    @Test
    void testSetPosition() {
        m.setPosition(4);
        assertEquals(4, m.getPosition());
    }

    @ParameterizedTest
    @CsvSource({
            "-9", "-89"
    })
    void testSetPositionNotValid(int position) {
        assertThrows(java.lang.IllegalArgumentException.class, () -> m.setPosition(position));
    }

    @Test
    void testSetSemester() {
        m.setSemester(4);
        assertEquals(4, m.getSemester());
    }

    @ParameterizedTest
    @CsvSource({
            "-9", "-89", "11", "9"
    })
    void testSetSemesterNotValid(int semester) {
        assertThrows(java.lang.IllegalArgumentException.class, () -> m.setSemester(semester));
    }

    @Test
    void testSetSubjectType() {
        m.setSubjectType(SubjectType.OBAVEZNI);
        assertEquals(SubjectType.OBAVEZNI, m.getSubjectType());
    }

    @Test
    void testSetSubjectTypeNull() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> m.setSubjectType(null));
    }

    @Test
    void testSetNumOfESPB() {
        m.setNumOfESPB(6);
        assertEquals(6, m.getNumOfESPB());
    }

    @ParameterizedTest
    @CsvSource({
            "-15", "-49"
    })
    void testSetNumOfESPBNotValid(int numOfESBP) {
        assertThrows(java.lang.IllegalArgumentException.class, () -> m.setNumOfESPB(numOfESBP));
    }

    @Test
    void testSetModule() {
        StudyProgram sp = new StudyProgram(1L, "Finansijski menadzment");
        Module module = new Module(2L, "Racunovodstvo", sp);
        m.setModule(module);
        assertEquals(module, m.getModule());
    }

    @Test
    void testSetModuleNull(){
        assertThrows(java.lang.IllegalArgumentException.class, () -> m.setModule(null));
    }

    @Test
    void testSetSubject(){
        Department d = new Department(3L, "Katedra za finansije", 5, DepartmentType.KATEDRA, null);
        Subject s = new Subject(4L, "Finansijski menadzment i racunovodstvo", 2, 2, 0, d);
        m.setSubject(s);
        assertEquals(s, m.getSubject());
    }

    @Test
    void testSetSubjectNull(){
        assertThrows(java.lang.IllegalArgumentException.class, () -> m.setSubject(null));
    }

    @Test
    void testSetToString(){
        m.setSubjectType(SubjectType.OBAVEZNI);
        m.setSemester(4);
        m.setPosition(5);
        m.setNumOfESPB(6);
        String s = m.toString();
        assertTrue(s.contains("OBAVEZNI"));
        assertTrue(s.contains("4"));
        assertTrue(s.contains("5"));
        assertTrue(s.contains("6"));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 5, 5, 4, 4, 6, 6, true",
            "1, 1, 5, 5, 4, 4, 6, 5, false",
            "1, 1, 5, 5, 4, 5, 6, 6, false",
            "1, 1, 8, 5, 4, 4, 6, 6, false",
            "1, 2, 5, 5, 4, 4, 6, 6, false",
    })
    void testEqualsObject(Long id1, Long id2, int pos1, int pos2, int sem1, int sem2, int num1, int num2, boolean eq){
        m.setId(id1);
        m.setPosition(pos1);
        m.setSemester(sem1);
        m.setNumOfESPB(num1);

        ModuleSubject m2 = new ModuleSubject();
        m2.setId(id2);
        m2.setPosition(pos2);
        m2.setSemester(sem2);
        m2.setNumOfESPB(num2);

        assertEquals(eq, m.equals(m2));
    }



}
