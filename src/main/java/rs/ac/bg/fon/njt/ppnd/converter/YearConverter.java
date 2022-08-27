package rs.ac.bg.fon.njt.ppnd.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import rs.ac.bg.fon.njt.ppnd.dto.StudyProgramDTO;
import rs.ac.bg.fon.njt.ppnd.dto.TeachingCoveragePlanDTO;
import rs.ac.bg.fon.njt.ppnd.dto.YearDTO;
import rs.ac.bg.fon.njt.ppnd.model.StudyProgram;
import rs.ac.bg.fon.njt.ppnd.model.Year;

@Component
public class YearConverter implements Converter<YearDTO, Year>{

	private final StudyProgramConverter studyProgramConverter;
	

	@Autowired
	public YearConverter(StudyProgramConverter studyProgramConverter) {
		this.studyProgramConverter = studyProgramConverter;
	}

	@Override
	public Year toEntity(YearDTO d) {
		StudyProgram s=studyProgramConverter.toEntity(d.getStudyProgram());
		return new Year(d.getId(), d.getStudyYear(),s);
	}

	@Override
	public YearDTO toDto(Year e) {
		StudyProgramDTO s=studyProgramConverter.toDto(e.getStudyProgram());

		return new YearDTO(e.getId(), e.getStudyYear(),s,new ArrayList<>());
	}

}
