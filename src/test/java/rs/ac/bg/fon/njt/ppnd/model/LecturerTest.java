package rs.ac.bg.fon.njt.ppnd.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import rs.ac.bg.fon.njt.ppnd.util.AcademicTitle;

public class LecturerTest {

    Lecturer l;

    @BeforeEach
    void setUp() throws Exception{
        l = new Lecturer();
    }

    @AfterEach
    void tearDown() throws Exception {
        l = null;
    }

    @Test
    void testSetAcademicTitle(){
        l.setAcademicTitle(AcademicTitle.ASISTENT);
        assertEquals(AcademicTitle.ASISTENT, l.getAcademicTitle());
    }

    @Test
    void testSetAcademicTitleNull(){
        assertThrows(java.lang.IllegalArgumentException.class, ()->l.setAcademicTitle(null));
    }

    @Test
    void testToString(){
        l.setAcademicTitle(AcademicTitle.ASISTENT);
        String s = l.toString();
        assertTrue(s.contains("ASISTENT"));
    }

    @ParameterizedTest
    @CsvSource({
            "ASISTENT, ASISTENT, true",
            "ASISTENT, DOCENT, false"
    })
    void testEqualsObject(AcademicTitle a1, AcademicTitle a2, boolean eq){
        l.setAcademicTitle(a1);
        Lecturer l2 = new Lecturer();
        l2.setAcademicTitle(a2);

        assertEquals(eq, l.equals(l2));
    }


}
