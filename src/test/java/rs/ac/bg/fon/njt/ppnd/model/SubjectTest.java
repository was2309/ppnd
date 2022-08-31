package rs.ac.bg.fon.njt.ppnd.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import rs.ac.bg.fon.njt.ppnd.util.DepartmentType;

import static org.junit.jupiter.api.Assertions.*;

public class SubjectTest {

    Subject s;

    @BeforeEach
    void setUp() throws Exception{
        s = new Subject();
    }

    @AfterEach
    void tearDown() throws Exception {
        s = null;
    }


    @Test
    void testSetId(){
        s.setId(4L);
        assertEquals(4L, s.getId());
    }

    @Test
    void testSetName(){
        s.setName("Programiranje 1");
        assertEquals("Programiranje 1", s.getName());
    }

    @Test
    void testSetNameNull(){
        assertThrows(java.lang.IllegalArgumentException.class, ()-> s.setName(null));
    }

    @Test
    void testSetLecutresPerWeek(){
        s.setLecutresPerWeek(3);
        assertEquals(3, s.getLecutresPerWeek());
    }

    @ParameterizedTest
    @CsvSource({"-3", "-1"})
    void testSetLecturesPerWeekNotValid(int lecturesPerWeek){
        assertThrows(java.lang.IllegalArgumentException.class, ()->s.setLecutresPerWeek(lecturesPerWeek));
    }

    @Test
    void testSetExercisesPerWeek(){
        s.setExcerciesPerWeek(2);
        assertEquals(2, s.getExcerciesPerWeek());
    }

    @ParameterizedTest
    @CsvSource({"-4", "-1"})
    void testSetExercisesPerWeekNotValid(int exercisesPerWeek){
        assertThrows(java.lang.IllegalArgumentException.class, ()->s.setExcerciesPerWeek(exercisesPerWeek));
    }

    @Test
    void testSetLabExercisesPerWeek(){
        s.setLabExcercisesPerWeek(1);
        assertEquals(1, s.getLabExcercisesPerWeek());
    }

    @ParameterizedTest
    @CsvSource({"-3", "-1"})
    void testSetLabExercisesWeekNotValid(int labExercisesPerWeek){
        assertThrows(java.lang.IllegalArgumentException.class, ()->s.setLabExcercisesPerWeek(labExercisesPerWeek));
    }

    @Test
    void testSetDepartment(){
        Department d = new Department(1L, "Katedra za menadzment", 4, DepartmentType.KATEDRA, null);
        s.setDepartment(d);
        assertEquals(d, s.getDepartment());
    }

    @Test
    void testSetDepartmentNull(){
        assertThrows(java.lang.IllegalArgumentException.class, ()->s.setDepartment(null));
    }

    @Test
    void setToString(){
        s.setId(5L);
        s.setName("Matematika 2");
        s.setLecutresPerWeek(3);
        s.setExcerciesPerWeek(1);
        s.setLabExcercisesPerWeek(0);
        String str = s.toString();

        assertTrue(str.contains("5"));
        assertTrue(str.contains("Matematika 2"));
        assertTrue(str.contains("3"));
        assertTrue(str.contains("1"));
        assertTrue(str.contains("0"));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, OIKT, OIKT, 5, 5, 4, 4, 6, 6, true",
            "1, 1, OIKT, OIKT, 5, 5, 4, 4, 6, 5, false",
            "1, 1, OIKT, OIKT, 5, 5, 4, 5, 6, 6, false",
            "1, 1, OIKT, OIKT, 8, 5, 4, 4, 6, 6, false",
            "1, 1, OIKT, UIS, 5, 5, 4, 4, 6, 6, false",
            "1, 2, OIKT, OIKT, 5, 5, 4, 4, 6, 6, false"
    })
    void testEqualsObject(Long id1, Long id2, String name1, String name2, int lpw1, int lpw2, int epw1, int epw2, int lepw1, int lepw2, boolean eq){
        s.setId(id1);
        s.setName(name1);
        s.setLecutresPerWeek(lpw1);
        s.setExcerciesPerWeek(epw1);
        s.setLabExcercisesPerWeek(lepw1);

        Subject s2 = new Subject();
        s2.setId(id2);
        s2.setName(name2);
        s2.setLecutresPerWeek(lpw2);
        s2.setExcerciesPerWeek(epw2);
        s2.setLabExcercisesPerWeek(lepw2);

        assertEquals(eq, s.equals(s2));
    }

}
