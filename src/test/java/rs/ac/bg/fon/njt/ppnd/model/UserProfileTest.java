package rs.ac.bg.fon.njt.ppnd.model;


import org.apache.catalina.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import rs.ac.bg.fon.njt.ppnd.util.DepartmentType;
import rs.ac.bg.fon.njt.ppnd.util.EducationTitle;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

public class UserProfileTest {
    UserProfile u;

    @BeforeEach
    void setUp() throws Exception{
        u = new UserProfile();
    }

    @AfterEach
    void tearDown() throws Exception {
        u = null;
    }

    @Test
    void testSetId(){
        u.setId(2L);
        assertEquals(2L, u.getId());
    }

    @Test
    void testSetEmail(){
        u.setEmail("pera@gmail.com");
        assertEquals("pera@gmail.com", u.getEmail());
    }

    @Test
    void testSetEmailNull(){
        assertThrows(java.lang.IllegalArgumentException.class, ()-> u.setEmail(null));
    }

    @Test
    void testSetPassword(){
        u.setPassword("pera123");
        assertEquals("pera123", u.getPassword());
    }

    @Test
    void testSetPasswordNull(){
        assertThrows(java.lang.IllegalArgumentException.class, ()-> u.setPassword(null));
    }

    @Test
    void testSetStatus(){
        u.setStatus("active");
        assertEquals("active", u.getStatus());
    }

    @Test
    void testSetEmployee(){
        Department d = new Department(1L, "Katedra za marketing", 4, DepartmentType.KATEDRA, null);
        Employee e = new Employee(4L, "Miroslav", "Ilic", new Date(55556L), EducationTitle.DR, d);
        u.setEmployee(e);
        assertEquals(e, u.getEmployee());
    }

    @Test
    void testSetEmployeeNull(){
        assertThrows(java.lang.IllegalArgumentException.class, ()-> u.setEmployee(null));
    }

    @Test
    void testToString(){
        u.setId(9L);
        u.setEmail("toma.zdravkovic@gmail.com");
        u.setPassword("tomatoma");
        u.setStatus("active");
        String s = u.toString();

        assertTrue(s.contains("9"));
        assertTrue(s.contains("toma.zdravkovic@gmail.com"));
        assertTrue(s.contains("tomatoma"));
        assertTrue(s.contains("active"));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, pera@gmail.com, pera@gmail.com, pass123, pass123, active, active,  true",
            "1, 1, pera@gmail.com, pera@gmail.com, pass123, pass123, active, deactivated,  false",
            "1, 1, pera@gmail.com, pera@gmail.com, pass123, word567, active, active,  false",
            "1, 1, pera@gmail.com, mika@yahoo.com, pass123, pass123, active, active,  false",
            "1, 2, pera@gmail.com, pera@gmail.com, pass123, pass123, active, active,  false"
    })
    void testEqualsObject(Long id1, Long id2, String email1, String email2, String password1, String password2, String status1, String status2,  boolean eq){
        u.setId(id1);
        u.setEmail(email1);
        u.setPassword(password1);
        u.setStatus(status1);

        UserProfile u2 = new UserProfile();
        u2.setId(id2);
        u2.setEmail(email2);
        u2.setPassword(password2);
        u2.setStatus(status2);

        assertEquals(eq, u.equals(u2));
    }


}
