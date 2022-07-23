package rs.ac.bg.fon.njt.service;

import java.util.List;

import rs.ac.bg.fon.njt.ppnd.dto.YearDTO;

public interface YearService {

	YearDTO getById(Long id);
	List<YearDTO>getAllYears();
	YearDTO saveYear(YearDTO yearDTO);
	YearDTO deleteYear(Long id);
	YearDTO updateYear(YearDTO year);
}
