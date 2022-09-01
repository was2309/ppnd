package rs.ac.bg.fon.njt.ppnd.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.bg.fon.njt.ppnd.converter.TeachingCoveragePlanConverter;
import rs.ac.bg.fon.njt.ppnd.dto.TeachingCoveragePlanDTO;
import rs.ac.bg.fon.njt.ppnd.model.*;
import rs.ac.bg.fon.njt.ppnd.model.Module;
import rs.ac.bg.fon.njt.ppnd.repository.*;
import rs.ac.bg.fon.njt.ppnd.service.impl.SaveTCPInJsonFileServiceImpl;
import rs.ac.bg.fon.njt.ppnd.service.impl.TeachingCoveragePlanServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class TeachingCoveragePlanServiceTest {

    @Mock
    protected TeachingCoveragePlanRepository teachingCoveragePlanRepository;

    @Mock
    protected TeachingCoveragePlanConverter teachingCoveragePlanConverter;

    @Mock
    protected YearRepository yearRepository;

    @Mock
    protected ModuleSubjectRepository moduleSubjectRepository;

    @Mock
    protected SaveTCPInJsonFileServiceImpl saveTCPInJsonFileService;

    @Mock
    protected LecturerRepository lecturerRepository;

    @Mock
    protected LecturingRepository lecturingRepository;

    @InjectMocks
    protected TeachingCoveragePlanServiceImpl teachingCoveragePlanService;

    protected TeachingCoveragePlan teachingCoveragePlan;

    protected Lecturing lecturing;

    protected List<Lecturing> lecturings;

    protected ModuleSubject moduleSubject;

    protected Year year;

    protected Department department;

    protected Subject subject;

    protected Module module;

    protected Lecturer lecturer;


    @Test
    public void geAllTCPsByYear(){
        List<TeachingCoveragePlan> tcpsInDatabase = List.of(
                new TeachingCoveragePlan(1L, moduleSubject, year, lecturings),
                new TeachingCoveragePlan(2L, moduleSubject, year, lecturings),
                new TeachingCoveragePlan(3L, moduleSubject, year, lecturings)
        );

        Mockito.when(teachingCoveragePlanRepository.findAllByYear(teachingCoveragePlan.getYear())).thenReturn(tcpsInDatabase);
        Mockito.when(yearRepository.findById(year.getId())).thenReturn(Optional.of(year));
        List<TeachingCoveragePlanDTO> retrieved = teachingCoveragePlanService.getAllByYear(year.getId());
        List<TeachingCoveragePlanDTO> converted = new ArrayList<>();
        tcpsInDatabase.forEach(tcp ->{
            TeachingCoveragePlanDTO tcpDTO = teachingCoveragePlanConverter.toDto(tcp);
            converted.add(tcpDTO);
        });

        assertEquals(converted, retrieved);
    }

    @Test
    public void getAllTCPsByYearNoTCPs(){
        List<TeachingCoveragePlan> tcpsInDatabase = new ArrayList<>();
        Mockito.when(yearRepository.findById(year.getId())).thenReturn(Optional.of(year));
        Mockito.when(teachingCoveragePlanRepository.findAllByYear(teachingCoveragePlan.getYear())).thenReturn(tcpsInDatabase);
        assertThrows(ResponseStatusException.class, ()->teachingCoveragePlanService.getAllByYear(year.getId()));
    }

    @Test
    public void getAllTCPsByYearNoYear(){
        List<TeachingCoveragePlan> tcpsInDatabase = List.of(
                new TeachingCoveragePlan(1L, moduleSubject, year, lecturings),
                new TeachingCoveragePlan(2L, moduleSubject, year, lecturings),
                new TeachingCoveragePlan(3L, moduleSubject, year, lecturings)
        );
        Mockito.when(yearRepository.findById(year.getId())).thenReturn(Optional.empty());
        Mockito.when(teachingCoveragePlanRepository.findAllByYear(teachingCoveragePlan.getYear())).thenReturn(tcpsInDatabase);
        assertThrows(ResponseStatusException.class, ()->teachingCoveragePlanService.getAllByYear(year.getId()));
    }

    @Test
    public void geAllTCPsByModuleSubject(){
        List<TeachingCoveragePlan> tcpsInDatabase = List.of(
                new TeachingCoveragePlan(1L, moduleSubject, year, lecturings),
                new TeachingCoveragePlan(2L, moduleSubject, year, lecturings),
                new TeachingCoveragePlan(3L, moduleSubject, year, lecturings)
        );

        Mockito.when(teachingCoveragePlanRepository.findAllByModuleSubject(teachingCoveragePlan.getModuleSubject())).thenReturn(tcpsInDatabase);
        Mockito.when(moduleSubjectRepository.findById(moduleSubject.getId())).thenReturn(Optional.of(moduleSubject));
        List<TeachingCoveragePlanDTO> retrieved = teachingCoveragePlanService.getAllByModuleSubject(moduleSubject.getId());
        List<TeachingCoveragePlanDTO> converted = new ArrayList<>();
        tcpsInDatabase.forEach(tcp ->{
            TeachingCoveragePlanDTO tcpDTO = teachingCoveragePlanConverter.toDto(tcp);
            converted.add(tcpDTO);
        });

        assertEquals(converted, retrieved);
    }

    @Test
    public void getAllTCPsByModuleSubjectNoTCPs(){
        List<TeachingCoveragePlan> tcpsInDatabase = new ArrayList<>();
        Mockito.when(moduleSubjectRepository.findById(moduleSubject.getId())).thenReturn(Optional.of(moduleSubject));
        Mockito.when(teachingCoveragePlanRepository.findAllByModuleSubject(teachingCoveragePlan.getModuleSubject())).thenReturn(tcpsInDatabase);
        assertThrows(ResponseStatusException.class, ()->teachingCoveragePlanService.getAllByModuleSubject(moduleSubject.getId()));
    }

    @Test
    public void getAllTCPsByModuleSubjectNoModuleSubject(){
        List<TeachingCoveragePlan> tcpsInDatabase = List.of(
                new TeachingCoveragePlan(1L, moduleSubject, year, lecturings),
                new TeachingCoveragePlan(2L, moduleSubject, year, lecturings),
                new TeachingCoveragePlan(3L, moduleSubject, year, lecturings)
        );
        Mockito.when(moduleSubjectRepository.findById(moduleSubject.getId())).thenReturn(Optional.empty());
        Mockito.when(teachingCoveragePlanRepository.findAllByModuleSubject(teachingCoveragePlan.getModuleSubject())).thenReturn(tcpsInDatabase);
        assertThrows(ResponseStatusException.class, ()->teachingCoveragePlanService.getAllByModuleSubject(moduleSubject.getId()));
    }


    @Test
    public void deleteTeachingCoveragePlan(){
        teachingCoveragePlan.setId(75L);
        Mockito.when(teachingCoveragePlanRepository.findById(teachingCoveragePlan.getId())).thenReturn(Optional.of(teachingCoveragePlan));
        Mockito.doNothing().when(teachingCoveragePlanRepository).delete(teachingCoveragePlan);
        TeachingCoveragePlanDTO tcpDTO = new TeachingCoveragePlanDTO();
        tcpDTO.setId(teachingCoveragePlan.getId());
        TeachingCoveragePlanDTO deleted = teachingCoveragePlanService.deleteTeachingCoveragePlan(teachingCoveragePlan.getId());
        assertEquals(tcpDTO.getId(), deleted.getId());
    }

    @Test
    public void deleteTeachingCoveragePlanDoesntExist(){
        teachingCoveragePlan.setId(95L);
        assertThrows(ResponseStatusException.class, ()->teachingCoveragePlanService.deleteTeachingCoveragePlan(2088L));
    }




}
