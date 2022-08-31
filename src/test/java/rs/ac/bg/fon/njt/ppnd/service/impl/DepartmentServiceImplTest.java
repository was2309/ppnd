package rs.ac.bg.fon.njt.ppnd.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import rs.ac.bg.fon.njt.ppnd.model.Department;
import rs.ac.bg.fon.njt.ppnd.service.DepartmentServiceTest;
import rs.ac.bg.fon.njt.ppnd.util.DepartmentType;

@SpringBootTest
public class DepartmentServiceImplTest extends DepartmentServiceTest {

    @BeforeEach
    public void setUp(){
        department = new Department(1L, "Katedra za matematiku", 9, DepartmentType.KATEDRA, null);
    }

    @AfterEach
    public void tearDown(){
        department = null;
    }
}
