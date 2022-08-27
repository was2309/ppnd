package rs.ac.bg.fon.njt.ppnd.converter;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
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

@Component
public class TeachingCoveragePlanConverter implements Converter<TeachingCoveragePlanDTO, TeachingCoveragePlan>{

	private final YearConverter yearConverter;
	
	private final ModuleSubjectConverter moduleSubjectConverter;


	public TeachingCoveragePlanConverter(YearConverter yearConverter, ModuleSubjectConverter moduleSubjectConverter) {
		this.yearConverter = yearConverter;
		this.moduleSubjectConverter = moduleSubjectConverter;
	}

	@Override
	public TeachingCoveragePlan toEntity(TeachingCoveragePlanDTO d) {
		Year year=yearConverter.toEntity(d.getYear());
		ModuleSubject moduleSubject=moduleSubjectConverter.toEntity(d.getModuleSubject());
		List<Lecturing> lecturings = new ArrayList<>();
		return new TeachingCoveragePlan(d.getId(),moduleSubject,year,lecturings);
	}

	@Override
	public TeachingCoveragePlanDTO toDto(TeachingCoveragePlan e) {
		YearDTO year=yearConverter.toDto(e.getYear());
		ModuleSubjectDTO moduleSubject=moduleSubjectConverter.toDto(e.getModuleSubject());
		List<LecturingDTO> lecturings = new ArrayList<>();
		return new TeachingCoveragePlanDTO(e.getId(),year,moduleSubject, lecturings);
	}

}
