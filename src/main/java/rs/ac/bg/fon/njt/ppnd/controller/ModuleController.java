package rs.ac.bg.fon.njt.ppnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.njt.ppnd.dto.ModuleDTO;
import rs.ac.bg.fon.njt.ppnd.service.impl.ModuleServiceImpl;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/api/v1/module")
public class ModuleController {
    @Autowired
    private ModuleServiceImpl moduleService;

    @GetMapping("/all")
    public List<ModuleDTO> getAllModules(){
        return this.moduleService.getAllModules();
    }

    @GetMapping("/{moduleId}")
    public ModuleDTO getModuleById(@PathVariable("moduleId")Long moduleId){
        return this.moduleService.getById(moduleId);
    }

    @DeleteMapping("/{moduleId}")
    public ModuleDTO deleteModule(){
        return null;
    }
}
