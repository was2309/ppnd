package rs.ac.bg.fon.njt.ppnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.njt.ppnd.dto.TeachingCoveragePlanDTO;
import rs.ac.bg.fon.njt.ppnd.service.impl.TeachingCoveragePlanServiceImpl;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/api/v1/tcp")
public class TeachingCoveragePlanController {

    private final TeachingCoveragePlanServiceImpl teachingCoveragePlanService;

    @Autowired
    public TeachingCoveragePlanController(TeachingCoveragePlanServiceImpl teachingCoveragePlanService) {
        this.teachingCoveragePlanService = teachingCoveragePlanService;
    }

    @GetMapping("get/all")
    public List<TeachingCoveragePlanDTO> findAllTCPs(){
        return this.teachingCoveragePlanService.findAllTCPs();
    }


    @GetMapping("get/{tcpId}")
    public TeachingCoveragePlanDTO findById(@PathVariable("tcpId") String tcpId){
        return this.teachingCoveragePlanService.findById(Long.valueOf(tcpId));
    }

    @PostMapping("save")
    public TeachingCoveragePlanDTO saveTeachingCoveragePlan(@RequestBody TeachingCoveragePlanDTO tcpDTO){
        return this.teachingCoveragePlanService.saveTeachingCoveragePlan(tcpDTO);
    }

    @DeleteMapping("delete/{tcpId}")
    public TeachingCoveragePlanDTO deleteTeachingCoveragePlan(@PathVariable("tcpId") String tcpId){
        return this.teachingCoveragePlanService.deleteTeachingCoveragePlan(Long.valueOf(tcpId));
    }

    @GetMapping("get_by_year/{yearId}")
    public List<TeachingCoveragePlanDTO> getAllByYear(@PathVariable("yearId") String yearId){
        return this.teachingCoveragePlanService.getAllByYear(Long.valueOf(yearId));
    }

    @GetMapping("get_by_subject/{moduleSubjectId}")
    public List<TeachingCoveragePlanDTO> getAllByModuleSubject(@PathVariable("moduleSubjectId") String moduleSubjectId){
        return this.teachingCoveragePlanService.getAllByModuleSubject(Long.valueOf(moduleSubjectId));
    }

    @PutMapping("update")
    public TeachingCoveragePlanDTO updateTCP(@RequestBody TeachingCoveragePlanDTO teachingCoveragePlanDTO){
        return this.teachingCoveragePlanService.updateTeachingCoveragePlanDto(teachingCoveragePlanDTO);
    }


}
