package rs.ac.bg.fon.njt.ppnd.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import rs.ac.bg.fon.njt.ppnd.model.Module;
import rs.ac.bg.fon.njt.ppnd.model.StudyProgram;
import rs.ac.bg.fon.njt.ppnd.service.ModuleServiceTest;


@SpringBootTest
public class ModuleServiceImplTest extends ModuleServiceTest {
    @BeforeEach
    public void setUp(){
        studyProgram = new StudyProgram(1L, "Informacioni sistemi i tehnologije");
        module = new Module(10L, "Informacioni sistemi", studyProgram);
    }

    @AfterEach
    public void tearDown(){
        module = null;
        studyProgram = null;
    }

}
