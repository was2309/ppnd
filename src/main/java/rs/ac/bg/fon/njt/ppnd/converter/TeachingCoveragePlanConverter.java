package rs.ac.bg.fon.njt.ppnd.converter;

import org.springframework.beans.factory.annotation.Autowired;

import rs.ac.bg.fon.njt.ppnd.dto.LecturingDTO;
import rs.ac.bg.fon.njt.ppnd.dto.ModuleSubjectDTO;
import rs.ac.bg.fon.njt.ppnd.dto.TeachingCoveragePlanDTO;
import rs.ac.bg.fon.njt.ppnd.dto.YearDTO;
import rs.ac.bg.fon.njt.ppnd.model.Lecturing;
import rs.ac.bg.fon.njt.ppnd.model.ModuleSubject;
import rs.ac.bg.fon.njt.ppnd.model.TeachingCoveragePlan;
import rs.ac.bg.fon.njt.ppnd.model.Year;

import java.util.ArrayList;
import java.util.List;


public class TeachingCoveragePlanConverter implements Converter<TeachingCoveragePlanDTO, TeachingCoveragePlan>{

	@Autowired
	YearConverter yearConverter;
	
	@Autowired
	ModuleSubjectConverter moduleSubjectConverter;

	@Autowired
	LecturingConverter lecturingConverter;
	
	@Override
	public TeachingCoveragePlan toEntity(TeachingCoveragePlanDTO d) {
		Year year=yearConverter.toEntity(d.getYear());
		ModuleSubject moduleSubject=moduleSubjectConverter.toEntity(d.getModuleSubject());
		List<Lecturing> lecturings = new ArrayList<>();
		for(LecturingDTO lecturingDTO:d.getLecturings()){
			Lecturing lecturing = lecturingConverter.toEntity(lecturingDTO);
			lecturings.add(lecturing);
		}
		return new TeachingCoveragePlan(d.getId(),moduleSubject,year,lecturings);
	}

	@Override
	public TeachingCoveragePlanDTO toDto(TeachingCoveragePlan e) {
		YearDTO year=yearConverter.toDto(e.getYear());
		ModuleSubjectDTO moduleSubject=moduleSubjectConverter.toDto(e.getModuleSubject());
		List<LecturingDTO> lecturings = new ArrayList<>();
		for(Lecturing l:e.getLecturings()){
			LecturingDTO lecturingDTO = lecturingConverter.toDto(l);
			lecturings.add(lecturingDTO);
		}
		return new TeachingCoveragePlanDTO(e.getId(),year,moduleSubject, lecturings);
	}

}
