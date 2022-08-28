package rs.ac.bg.fon.njt.ppnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.njt.ppnd.dto.StudyProgramDTO;
import rs.ac.bg.fon.njt.ppnd.service.StudyProgramService;
import rs.ac.bg.fon.njt.ppnd.service.impl.StudyProgramServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/all/study-program")
public class StudyProgramController {

    @Autowired
    private StudyProgramServiceImpl studyProgramService;

    @GetMapping("/all")
    public List<StudyProgramDTO> getAllStudyPrograms(){
        return this.studyProgramService.getAllStudyPrograms();
    }

    @GetMapping("/{studyProgramId}")
    public StudyProgramDTO getStudyProgramById(@PathVariable("studyProgramId") String studyProgramId ){
        return this.studyProgramService.getBuyId(Long.valueOf(studyProgramId));
    }

    @PostMapping("/save")
    public StudyProgramDTO saveStudyProgram(@RequestBody() StudyProgramDTO studyProgramDTO){
        return this.studyProgramService.saveStudyProgram(studyProgramDTO);
    }

    @DeleteMapping("/delete/{studyProgramId}")
    public StudyProgramDTO deleteStudyProgram(@PathVariable("studyProgramId") String studyProgramId){
        return this.studyProgramService.deleteStudyProgram(Long.valueOf(studyProgramId));
    }

    @PutMapping("/update")
    public StudyProgramDTO updateStudyProgram(@RequestBody() StudyProgramDTO studyProgramDTO){
        return this.studyProgramService.updateStudyProgram(studyProgramDTO);
    }
}

