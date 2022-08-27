package rs.ac.bg.fon.njt.ppnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.njt.ppnd.dto.SubjectDTO;
import rs.ac.bg.fon.njt.ppnd.service.impl.SubjectServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subject")
public class SubjectController {

    @Autowired
    private SubjectServiceImpl subjectService;

    @GetMapping("/all")
    public List<SubjectDTO> getAllSubjects(){
        return this.subjectService.getAllSubjects();
    }

    @GetMapping("/:subjectId")
    public SubjectDTO getById(@RequestParam("subjectId")String subjectId){
        return this.subjectService.getById(Long.valueOf(subjectId));
    }

    @GetMapping("/module/:moduleId")
    public List<SubjectDTO> getByModuleId(@RequestParam("moduleId")String moduleId){
        return this.subjectService.getByModuleId(Long.valueOf(moduleId));
    }

    @PostMapping("/save")
    public SubjectDTO saveSubject(@RequestBody()SubjectDTO subjectDto){
        return this.subjectService.saveSubject(subjectDto);
    }

    @PutMapping("/update")
    public SubjectDTO updateSubject(@RequestBody() SubjectDTO subjectDTO){
        return this.subjectService.updateSubject(subjectDTO);
    }

    @DeleteMapping("/delete/:subjectId")
    public SubjectDTO deleteSubject(@RequestParam("subjectId")String subjectId){
        return this.subjectService.deleteSubject(Long.valueOf(subjectId));
    }
}
