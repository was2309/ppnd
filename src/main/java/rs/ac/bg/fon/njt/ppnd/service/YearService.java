package rs.ac.bg.fon.njt.ppnd.service;

import rs.ac.bg.fon.njt.ppnd.dto.YearDTO;

import java.util.List;

public interface YearService {
    YearDTO getYearById(Long id);
    List<YearDTO> getAllYears();
}
