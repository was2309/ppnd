package rs.ac.bg.fon.njt.ppnd.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import rs.ac.bg.fon.njt.ppnd.dto.StudyProgramDTO;
import rs.ac.bg.fon.njt.ppnd.dto.TeachingCoveragePlanDTO;
import rs.ac.bg.fon.njt.ppnd.dto.YearDTO;
import rs.ac.bg.fon.njt.ppnd.model.StudyProgram;
import rs.ac.bg.fon.njt.ppnd.model.Year;

public class YearConverter implements Converter<YearDTO, Year>{

	@Autowired
	StudyProgramConverter studyProgramConverter;
	
	@Autowired
	TeachingCoveragePlanConverter planConverter;
	
	@Override
	public Year toEntity(YearDTO d) {
		StudyProgram s=studyProgramConverter.toEntity(d.getStudyProgram());
		return new Year(d.getId(), d.getStudyYear(),s);
	}

	@Override
	public YearDTO toDto(Year e) {
		StudyProgramDTO s=studyProgramConverter.toDto(e.getStudyProgram());
		List<TeachingCoveragePlanDTO>coveragePlans=new ArrayList<>();
		e.getPlans().forEach((coveragePlan)->{
			TeachingCoveragePlanDTO d=planConverter.toDto(coveragePlan);
			coveragePlans.add(d);
		});
		return new YearDTO(e.getId(), e.getStudyYear(),s,coveragePlans);
	}

}
