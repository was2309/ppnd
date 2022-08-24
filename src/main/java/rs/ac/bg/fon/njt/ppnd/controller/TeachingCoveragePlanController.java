package rs.ac.bg.fon.njt.ppnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.njt.ppnd.dto.TeachingCoveragePlanDTO;
import rs.ac.bg.fon.njt.ppnd.service.impl.TeachingCoveragePlanServiceImpl;

@RestController
@RequestMapping("/api/v1/tcp")
public class TeachingCoveragePlanController {

    private final TeachingCoveragePlanServiceImpl teachingCoveragePlanService;

    @Autowired
    public TeachingCoveragePlanController(TeachingCoveragePlanServiceImpl teachingCoveragePlanService) {
        this.teachingCoveragePlanService = teachingCoveragePlanService;
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

    //TODO: getAllByModuleSubject
    //TODO: getAllByYear

}
