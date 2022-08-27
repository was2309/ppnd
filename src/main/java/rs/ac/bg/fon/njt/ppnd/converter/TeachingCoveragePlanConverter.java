package rs.ac.bg.fon.njt.ppnd.converter;

import org.springframework.beans.factory.annotation.Autowired;

import rs.ac.bg.fon.njt.ppnd.dto.ModuleSubjectDTO;
import rs.ac.bg.fon.njt.ppnd.dto.TeachingCoveragePlanDTO;
import rs.ac.bg.fon.njt.ppnd.dto.YearDTO;
import rs.ac.bg.fon.njt.ppnd.model.ModuleSubject;
import rs.ac.bg.fon.njt.ppnd.model.TeachingCoveragePlan;
import rs.ac.bg.fon.njt.ppnd.model.Year;

public class TeachingCoveragePlanConverter implements Converter<TeachingCoveragePlanDTO, TeachingCoveragePlan>{

	@Autowired
	YearConverter yearConverter;
	
	@Autowired
	ModuleSubjectConverter moduleSubjectConverter;
	
	@Override
	public TeachingCoveragePlan toEntity(TeachingCoveragePlanDTO d) {
		Year year=yearConverter.toEntity(d.getYear());
		ModuleSubject moduleSubject=moduleSubjectConverter.toEntity(d.getModuleSubject());
		return new TeachingCoveragePlan(d.getId(),moduleSubject,year);
	}

	@Override
	public TeachingCoveragePlanDTO toDto(TeachingCoveragePlan e) {
		YearDTO year=yearConverter.toDto(e.getYear());
		ModuleSubjectDTO moduleSubject=moduleSubjectConverter.toDto(e.getModuleSubject());
		return new TeachingCoveragePlanDTO(e.getId(),year,moduleSubject);
	}

}
