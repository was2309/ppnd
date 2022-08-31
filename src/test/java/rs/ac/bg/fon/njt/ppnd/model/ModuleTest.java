package rs.ac.bg.fon.njt.ppnd.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ModuleTest {

    Module m;

    @BeforeEach
    void setUp() throws Exception{
        m = new Module();
    }

    @AfterEach
    void tearDown() throws Exception {
        m = null;
    }

    @Test
    void testSetId(){
        m.setId(3L);
        assertEquals(3L, m.getId());
    }

    @Test
    void testSetName(){
        m.setName("Informaciono inzenjerstvo");
        assertEquals("Informaciono inzenjerstvo", m.getName());
    }

    @Test
    void testSetNameNull(){
        assertThrows(java.lang.IllegalArgumentException.class, ()->m.setName(null));
    }

    @Test
    void testSetStudyProgram(){
        StudyProgram sp = new StudyProgram(4L, "Informacioni sistemi");
        m.setStudyProgram(sp);
        assertEquals(sp, m.getStudyProgram());
    }

    @Test
    void testSetStudyProgramNull(){
        assertThrows(java.lang.IllegalArgumentException.class, ()-> m.setStudyProgram(null));
    }

    @Test
    void testToString(){
        m.setId(78L);
        m.setName("Informaciono inzenjerstvo");
        String s = m.toString();
        assertTrue(s.contains("78"));
        assertTrue(s.contains("Informaciono inzenjerstvo"));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 5, Racunovodstvo, Racunovodstvo, true",
            "5, 5, Racunovodstvo, Marketing, false",
            "5, 9, Racunovodstvo, Racunovodstvo, false"
    })
    void testEqualsObject(Long id1, Long id2, String name1, String name2, boolean eq){
        m.setId(id1);
        m.setName(name1);

        Module m2 = new Module();
        m2.setId(id2);
        m2.setName(name2);

        assertEquals(eq, m.equals(m2));
    }



}
