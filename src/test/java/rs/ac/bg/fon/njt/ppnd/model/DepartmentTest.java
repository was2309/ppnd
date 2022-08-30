package rs.ac.bg.fon.njt.ppnd.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import rs.ac.bg.fon.njt.ppnd.util.DepartmentType;


public class DepartmentTest {

    Department d;

    @BeforeEach
    void setUp() throws Exception{
        d = new Department();
    }

    @AfterEach
    void tearDown() throws Exception {
        d = null;
    }


    @Test
    void testSetName(){
        d.setName("Katedra za poslovanje");
        assertEquals("Katedra za poslovanje", d.getName());
    }

    @Test
    void testSetNameNull(){
        assertThrows(java.lang.IllegalArgumentException.class, ()->d.setName(null));
    }

    @Test
    void testSetNumberOfMembers(){
        d.setNumberOfMembers(3);
        assertEquals(3, d.getNumberOfMembers());
    }

    @ParameterizedTest
    @CsvSource({
            "-3", "-9"
    })
    void testSetNumberOfMembersLessThanZero(int numOfMembers){
        assertThrows(java.lang.IllegalArgumentException.class, ()->d.setNumberOfMembers(numOfMembers));
    }

    @Test
    void testSetDepartmentType(){
        d.setType(DepartmentType.KATEDRA);
        assertEquals(DepartmentType.KATEDRA, d.getType());
    }

    @Test
    void testSetDepartmentTypeNull(){
        assertThrows(java.lang.IllegalArgumentException.class, ()->d.setType(null));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, Katedra za poslovanje, Katedra za poslovanje, 5, 5, true",
            "1, 1, Katedra za poslovanje, Katedra za poslovanje, 5, 6, false",
            "1, 1, Katedra za poslovanje, Katedra za elektronsko poslovanje, 5, 5, false",
            "1, 2, Katedra za poslovanje, Katedra za poslovanje, 5, 5, false"
    })
    void testEqualsObject(Long id1, Long id2, String name1, String name2, int numOfMembers1, int numOfMembers2,  boolean eq){
        d.setId(id1);
        d.setName(name1);
        d.setNumberOfMembers(numOfMembers1);

        Department d2 = new Department();
        d2.setId(id2);
        d2.setName(name2);
        d2.setNumberOfMembers(numOfMembers2);

        assertEquals(eq, d.equals(d2));
    }



}
