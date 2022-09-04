package rs.ac.bg.fon.njt.ppnd.controller;


import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.njt.ppnd.dto.YearDTO;
import rs.ac.bg.fon.njt.ppnd.service.impl.YearServiceImpl;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/api/v1/year")
public class YearController {
    private final YearServiceImpl yearService;

    public YearController(YearServiceImpl yearService) {
        this.yearService = yearService;
    }

    @GetMapping("all")
    public List<YearDTO> getAllYears(){
        return this.yearService.getAllYears();
    }

    @GetMapping("get/{yearId}")
    public YearDTO getYearById(@PathVariable("yearId") Long yearId){
        return this.yearService.getYearById(yearId);
    }

}
