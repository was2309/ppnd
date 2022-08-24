package rs.ac.bg.fon.njt.ppnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.njt.ppnd.dto.LecturingDTO;
import rs.ac.bg.fon.njt.ppnd.service.impl.LecturingServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lecturing")
public class LecturingController {

    private final LecturingServiceImpl lecturingService;

    @Autowired
    public LecturingController(LecturingServiceImpl lecturingService) {
        this.lecturingService = lecturingService;
    }

    @PostMapping("save")
    public LecturingDTO saveLecturing(@RequestBody LecturingDTO lecturingDTO){
        return this.lecturingService.saveLecturing(lecturingDTO);
    }

    @PostMapping("save_list")
    public List<LecturingDTO> saveListOfLecturings(@RequestBody List<LecturingDTO> lecturingDTOs){
        return this.lecturingService.saveListOfLecturings(lecturingDTOs);
    }

    @DeleteMapping("delete/{lecturingId}")
    public LecturingDTO deleteLecturing(@PathVariable("lecturingId") String lecturingId){
        return this.lecturingService.deleteLecturing(Long.valueOf(lecturingId));
    }

    @GetMapping("get/{lecturingId}")
    public LecturingDTO getLecturingById(@PathVariable("lecturingId") String lecturingId){
        return this.lecturingService.getById(Long.valueOf(lecturingId));
    }

    @GetMapping("get_by_tcp/{tcpId}")
    public List<LecturingDTO> getAllLecturingsByTCP(@PathVariable("tcpId") String tcpId){
        return this.lecturingService.getAllLecturingsByTCP(Long.valueOf(tcpId));
    }


}
