package rs.ac.bg.fon.njt.ppnd.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import rs.ac.bg.fon.njt.ppnd.util.DepartmentType;
import rs.ac.bg.fon.njt.ppnd.util.EducationTitle;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class EmployeeTest {

    Employee e;

    @BeforeEach
    void setUp() throws Exception{
        e = new Employee();
    }

    @AfterEach
    void tearDown() throws Exception {
        e = null;
    }

    @Test
    void testSetId(){
        e.setId(4L);
        assertEquals(4L, e.getId());
    }

    @Test
    void testSetFirstName(){
        e.setFirstName("Pera");
        assertEquals("Pera", e.getFirstName());
    }

    @Test
    void testSetFirstNameNull(){
        assertThrows(java.lang.IllegalArgumentException.class, ()->e.setFirstName(null));
    }

    @Test
    void testSetLastName(){
        e.setLastName("Peric");
        assertEquals("Peric", e.getLastName());
    }

    @Test
    void testSetLastNameNull(){
        assertThrows(java.lang.IllegalArgumentException.class, ()->e.setLastName(null));
    }

    @Test
    void testSetBirthday(){
        e.setBirthday(new Date(55556L));
        assertEquals(new Date(55556L), e.getBirthday());
    }

    @Test
    void testSetBirthdayNull(){
        assertThrows(java.lang.IllegalArgumentException.class, ()->e.setBirthday(null));
    }

    @Test
    void testSetTitle(){
        e.setTitle(EducationTitle.DR);
        assertEquals(EducationTitle.DR, e.getTitle());
    }

    @Test
    void testSetTitleNull(){
        assertThrows(java.lang.IllegalArgumentException.class, ()->e.setTitle(null));
    }

    @Test
    void testSetDepartment(){
        Department d = new Department(1L, "Katedra za poslovanje", 4, DepartmentType.KATEDRA, null);
        e.setDepartment(d);
        assertEquals(d, e.getDepartment());
    }

    @Test
    void testSetDepartmentNull(){
        assertThrows(java.lang.IllegalArgumentException.class, ()->e.setDepartment(null));
    }

    @Test
    void testToString(){
        e.setFirstName("Pera");
        e.setLastName("Peric");
        e.setTitle(EducationTitle.DR);

        String s = e.toString();
        assertTrue(s.contains("Pera"));
        assertTrue(s.contains("Peric"));
        assertTrue(s.contains("DR"));

    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, Marko, Marko, Markovic, Markovic, DR, DR, true",
            "1, 1, Marko, Marko, Markovic, Petrovic, DR, DR, false",
            "1, 1, Marko, Petar, Markovic, Markovic, DR, DR, false",
            "1, 2, Marko, Marko, Markovic, Markovic, DR, DR, false",
            "1, 1, Marko, Marko, Markovic, Markovic, DR, MSA, false"
    })
    void testEquals(Long id1, Long id2, String fname1, String fname2, String lname1, String lname2, EducationTitle et1, EducationTitle et2, boolean eq){
        e.setId(id1);
        e.setFirstName(fname1);
        e.setLastName(lname1);
        e.setTitle(et1);


        Employee e2 = new Employee();
        e2.setId(id2);
        e2.setFirstName(fname2);
        e2.setLastName(lname2);
        e2.setTitle(et2);

        assertEquals(eq, e.equals(e2));
    }





}
