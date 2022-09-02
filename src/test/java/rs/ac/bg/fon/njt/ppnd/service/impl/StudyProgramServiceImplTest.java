package rs.ac.bg.fon.njt.ppnd.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import rs.ac.bg.fon.njt.ppnd.dto.StudyProgramDTO;
import rs.ac.bg.fon.njt.ppnd.model.StudyProgram;
import rs.ac.bg.fon.njt.ppnd.service.StudyProgramServiceTest;

@SpringBootTest
public class StudyProgramServiceImplTest  extends StudyProgramServiceTest {
    @BeforeEach
    public void setUp(){
        studyProgram = new StudyProgram(1L, "Informacioni sistemi i tehnologije");
        inDto = new StudyProgramDTO(1L, "Menadzment");
    }

    @AfterEach
    public void tearDown(){
        studyProgram = null;
    }
}
