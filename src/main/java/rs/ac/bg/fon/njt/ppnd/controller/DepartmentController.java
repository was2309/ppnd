package rs.ac.bg.fon.njt.ppnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.njt.ppnd.dto.DepartmentDTO;
import rs.ac.bg.fon.njt.ppnd.service.impl.DepartmentServiceImpl;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    private final DepartmentServiceImpl departmentServiceImpl;

    @Autowired
    public DepartmentController(DepartmentServiceImpl departmentServiceImpl) {
        this.departmentServiceImpl = departmentServiceImpl;
    }

    @GetMapping("all")
    List<DepartmentDTO> getAllDepartments(){
        return this.departmentServiceImpl.getAllDepartments();
    }

    @GetMapping("/{departmentId}")
    DepartmentDTO getDepartmentById(@PathVariable("departmentId") Long departmentId){
        return this.departmentServiceImpl.getDepartmentById(departmentId);
    }

}
