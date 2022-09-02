package rs.ac.bg.fon.njt.ppnd.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.bg.fon.njt.ppnd.converter.StudyProgramConverter;
import rs.ac.bg.fon.njt.ppnd.dto.ModuleDTO;
import rs.ac.bg.fon.njt.ppnd.dto.StudyProgramDTO;
import rs.ac.bg.fon.njt.ppnd.model.Module;
import rs.ac.bg.fon.njt.ppnd.model.StudyProgram;
import rs.ac.bg.fon.njt.ppnd.repository.StudyProgramRepository;
import rs.ac.bg.fon.njt.ppnd.service.impl.StudyProgramServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class StudyProgramServiceTest {

    @Mock
    protected StudyProgramRepository studyProgramRepository;

    @Mock
    protected StudyProgramConverter studyProgramConverter;

    @InjectMocks
    protected StudyProgramServiceImpl studyProgramService;

    protected StudyProgram studyProgram;

    protected StudyProgramDTO inDto;

    @Test
    public void getStudyProgramById(){
        studyProgram.setId(4L);
        Mockito.when(studyProgramRepository.findById(studyProgram.getId())).thenReturn(Optional.of(studyProgram));

        StudyProgramDTO found = studyProgramService.getBuyId(4L);

        assertEquals(found, studyProgramConverter.toDto(studyProgram));
    }

    @Test
    public void getStudyProgramByIdNotExist() {
        studyProgram.setId(55L);
        Mockito.when(studyProgramRepository.findById(studyProgram.getId())).thenReturn(Optional.empty());
        assertThrows(ResponseStatusException.class, ()->studyProgramService.getBuyId(studyProgram.getId()));
    }

    @Test
    public void geAllStudyPrograms(){
        List<StudyProgram> studyProgramsInDatabase = List.of(
                new StudyProgram(1L, "Informacioni sistemi i tehnologije"),
                new StudyProgram(2L, "Menadzment i organizacija"),
                new StudyProgram(3L, "Marketing menadzment")
        );

        Mockito.when(studyProgramRepository.findAll()).thenReturn(studyProgramsInDatabase);
        List<StudyProgramDTO> retrieved = studyProgramService.getAllStudyPrograms();
        List<StudyProgramDTO> converted = new ArrayList<>();
        studyProgramsInDatabase.forEach(sp ->{
            StudyProgramDTO studyProgramDTO = studyProgramConverter.toDto(sp);
            converted.add(studyProgramDTO);
        });

        assertEquals(converted, retrieved);
    }

    @Test
    public void getAllStudyProgramsNoStudyPrograms(){
        List<StudyProgram> studyProgramsInDatabase = new ArrayList<>();
        Mockito.when(studyProgramRepository.findAll()).thenReturn(studyProgramsInDatabase);
        assertThrows(ResponseStatusException.class, ()->studyProgramService.getAllStudyPrograms());
    }

    @Test
    public void saveStudyProgram(){
        Mockito.when(studyProgramRepository.save(studyProgram)).thenReturn(studyProgram);
        StudyProgramDTO studyProgramDTO = studyProgramConverter.toDto(studyProgram);
        StudyProgramDTO saved = studyProgramService.saveStudyProgram(inDto);

        assertEquals(studyProgramDTO, saved);
    }

    @Test
    public void deleteStudyProgram(){
        studyProgram.setId(75L);
        Mockito.when(studyProgramRepository.findById(studyProgram.getId())).thenReturn(Optional.of(studyProgram));
        Mockito.doNothing().when(studyProgramRepository).delete(studyProgram);

        assertEquals(studyProgramConverter.toDto(studyProgram), studyProgramService.deleteStudyProgram(studyProgram.getId()));
    }

    @Test
    public void deleteStudyProgramDoesntExist(){
        studyProgram.setId(95L);
        assertThrows(ResponseStatusException.class, ()->studyProgramService.deleteStudyProgram(198L));
    }

    @Test
    public void updateStudyProgram(){
        studyProgram.setId(1L);
        StudyProgram updatedStudyProgram = new StudyProgram(studyProgram.getId(), "Menadzment");
        Mockito.when(studyProgramConverter.toDto(updatedStudyProgram)).thenReturn(inDto);
        inDto = studyProgramConverter.toDto(updatedStudyProgram);

        Mockito.when(studyProgramRepository.findById(studyProgram.getId())).thenReturn(Optional.of(studyProgram));
        Mockito.when(studyProgramRepository.save(updatedStudyProgram)).thenReturn(updatedStudyProgram);

        StudyProgramDTO updated = studyProgramService.updateStudyProgram(inDto);
        updatedStudyProgram.setId(studyProgram.getId());
        assertEquals(updated, studyProgramConverter.toDto(updatedStudyProgram));
    }

    @Test
    public void updateStudyProgramNoStudyProgramFound(){
        studyProgram.setId(7L);

        Mockito.when(studyProgramRepository.findById(studyProgram.getId())).thenReturn(Optional.empty());
        assertThrows(ResponseStatusException.class, ()->studyProgramService.updateStudyProgram(inDto));
    }
}
