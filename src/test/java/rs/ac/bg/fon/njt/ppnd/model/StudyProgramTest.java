package rs.ac.bg.fon.njt.ppnd.model;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class StudyProgramTest {
    StudyProgram s;

    @BeforeEach
    void setUp() throws Exception{
        s = new StudyProgram();
    }

    @AfterEach
    void tearDown() throws Exception {
        s = null;
    }


    @Test
    void testSetId(){
        s.setId(6L);
        assertEquals(6L, s.getId());
    }

    @Test
    void testSetName(){
        s.setName("Informacioni sistemi i tehnologije");
        assertEquals("Informacioni sistemi i tehnologije", s.getName());
    }

    @Test
    void testSetNameNull(){
        assertThrows(java.lang.IllegalArgumentException.class, ()-> s.setName(null));
    }

    @Test
    void testToStringMethod(){
        s.setName("Menadzment i organizacija");
        s.setId(9L);
        String str = s.toString();
        assertTrue(str.contains("Menadzment i organizacija"));
        assertTrue(str.contains("9"));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, Menadzment, Menadzment, true",
            "1, 1, Menadzment, Informacioni sistemi i tehnologije, false",
            "1, 2, Menadzment, Menadzment, false"
    })
    void testEqualsObject(Long id1, Long id2, String name1, String name2,  boolean eq){
        s.setId(id1);
        s.setName(name1);

        StudyProgram s2 = new StudyProgram();
        s2.setId(id2);
        s2.setName(name2);

        assertEquals(eq, s.equals(s2));
    }
}
