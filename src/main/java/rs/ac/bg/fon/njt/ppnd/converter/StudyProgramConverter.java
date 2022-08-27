package rs.ac.bg.fon.njt.ppnd.converter;

import org.springframework.stereotype.Component;
import rs.ac.bg.fon.njt.ppnd.dto.StudyProgramDTO;
import rs.ac.bg.fon.njt.ppnd.model.StudyProgram;

@Component
public class StudyProgramConverter implements Converter<StudyProgramDTO, StudyProgram> {

	@Override
	public StudyProgram toEntity(StudyProgramDTO d) {
		return new StudyProgram(d.getId(), d.getName());
	}

	@Override
	public StudyProgramDTO toDto(StudyProgram e) {
		return new StudyProgramDTO(e.getId(), e.getName());
	}

}
