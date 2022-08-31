package rs.ac.bg.fon.njt.ppnd.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class YearTest {
    Year y;

    @BeforeEach
    void setUp() throws Exception{
        y = new Year();
    }

    @AfterEach
    void tearDown() throws Exception {
        y = null;
    }


    @Test
    void testSetId(){
        y.setId(2022L);
        assertEquals(2022L, y.getId());
    }

    @Test
    void testSetStudyYear(){
        y.setStudyYear("2024/2025");
        assertEquals("2024/2025", y.getStudyYear());
    }

    @Test
    void testSetStudyYearNull(){
        assertThrows(java.lang.IllegalArgumentException.class, ()-> y.setStudyYear(null));
    }

    @ParameterizedTest
    @CsvSource({"2022/20223", "2888888888888"})
    void testSetStudyYearNotValid(String studyYear){
        assertThrows(java.lang.IllegalArgumentException.class, ()-> y.setStudyYear(studyYear));
    }

    @Test
    void testSetStudyProgram(){
        StudyProgram sp = new StudyProgram(4L, "Menadzment i organizacija");
        y.setStudyProgram(sp);
        assertEquals(sp, y.getStudyProgram());
    }

    @Test
    void testSetStudyProgramNull(){
        assertThrows(java.lang.IllegalArgumentException.class, ()-> y.setStudyProgram(null));
    }

    @Test
    void testToString(){
        y.setId(2024L);
        y.setStudyYear("2025/2026");
        String s = y.toString();

        assertTrue(s.contains("2024"));
        assertTrue(s.contains("2025/2026"));
    }

    @ParameterizedTest
    @CsvSource({
            "2021, 2021, 2021/2022, 2021/2022, true",
            "2021, 2021, 2021/2022, 2022/2023, false",
            "2021, 2022, 2021/2022, 2021/2022, false",
    })
    void testEqualsObject(Long id1, Long id2, String studyYear1, String studyYear2, boolean eq){
        y.setId(id1);
        y.setStudyYear(studyYear1);


        Year y2 = new Year();
        y2.setId(id2);
        y2.setStudyYear(studyYear2);


        assertEquals(eq, y.equals(y2));
    }

}
