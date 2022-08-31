package rs.ac.bg.fon.njt.ppnd.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.bg.fon.njt.ppnd.converter.ModuleConverter;
import rs.ac.bg.fon.njt.ppnd.dto.ModuleDTO;
import rs.ac.bg.fon.njt.ppnd.model.StudyProgram;
import rs.ac.bg.fon.njt.ppnd.model.Module;
import rs.ac.bg.fon.njt.ppnd.repository.ModuleRepository;
import rs.ac.bg.fon.njt.ppnd.service.impl.ModuleServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class ModuleServiceTest {

    @Mock
    protected ModuleRepository moduleRepository;

    @Mock
    protected ModuleConverter moduleConverter;
    @InjectMocks
    protected ModuleServiceImpl moduleService;

    protected Module module;
    protected StudyProgram studyProgram;

    @Test
    public void getModuleById(){
        module.setId(5L);
        Mockito.when(moduleRepository.findById(module.getId())).thenReturn(Optional.of(module));

        ModuleDTO found = moduleService.getById(5L);

        assertEquals(found, moduleConverter.toDto(module));
    }

    @Test
    public void getModuleByIdNotExist() {
        module.setId(50L);
        Mockito.when(moduleRepository.findById(module.getId())).thenReturn(Optional.empty());
        assertThrows(ResponseStatusException.class, ()->moduleService.getById(module.getId()));
    }

    @Test
    public void geAllModules(){
        List<Module> modulesInDatabase = List.of(
                new Module(1L, "Informacioni sistemi", studyProgram),
                new Module(2L, "Informacione tehnologije", studyProgram),
                new Module(3L, "Cyber security", studyProgram)
        );

        Mockito.when(moduleRepository.findAll()).thenReturn(modulesInDatabase);
        List<ModuleDTO> retrieved = moduleService.getAllModules();
        List<ModuleDTO> converted = new ArrayList<>();
        modulesInDatabase.forEach(module1 ->{
            ModuleDTO moduleDTO = moduleConverter.toDto(module1);
            converted.add(moduleDTO);
        });

        assertEquals(converted, retrieved);
    }

    @Test
    public void getAllModulesNoModulesSaved(){
        List<Module> modulesInDatabase = new ArrayList<>();
        Mockito.when(moduleRepository.findAll()).thenReturn(modulesInDatabase);
        assertThrows(ResponseStatusException.class, ()->moduleService.getAllModules());
    }

    @Test
    public void deleteModule(){
        module.setId(78L);
        Mockito.when(moduleRepository.findById(module.getId())).thenReturn(Optional.of(module));
        Mockito.doNothing().when(moduleRepository).delete(module);

        assertEquals(moduleConverter.toDto(module), moduleService.deleteModule(module.getId()));
    }

    @Test
    public void deleteModuleDoesntExist(){
        module.setId(45L);
        assertThrows(ResponseStatusException.class, ()->moduleService.deleteModule(195L));
    }
}
