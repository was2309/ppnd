package rs.ac.bg.fon.njt.ppnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.njt.ppnd.dto.LecturerDTO;
import rs.ac.bg.fon.njt.ppnd.service.impl.LecturerServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lecturer")
public class LecturerController {

    private final LecturerServiceImpl lecturerServiceImpl;

    @Autowired
    public LecturerController(LecturerServiceImpl lecturerServiceImpl) {
        this.lecturerServiceImpl = lecturerServiceImpl;
    }

    @GetMapping("all")
    List<LecturerDTO> getAllLecturers(){
        return this.lecturerServiceImpl.getAllLecturers();
    }

    @GetMapping("get_by_department/{departmentId}")
    List<LecturerDTO> getLecturersFromDepartment(@PathVariable("departmentId") String departmentId){
        return this.lecturerServiceImpl.getLecturersFromDepartment(Long.valueOf(departmentId));
    }
}
