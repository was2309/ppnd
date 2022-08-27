package rs.ac.bg.fon.njt.ppnd.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import rs.ac.bg.fon.njt.ppnd.dto.ModuleDTO;
import rs.ac.bg.fon.njt.ppnd.dto.ModuleSubjectDTO;
import rs.ac.bg.fon.njt.ppnd.dto.StudyProgramDTO;
import rs.ac.bg.fon.njt.ppnd.model.Module;
import rs.ac.bg.fon.njt.ppnd.model.StudyProgram;

@Component
public class ModuleConverter implements Converter<ModuleDTO, Module>{

	private final StudyProgramConverter studyProgramConverter;


	@Autowired
	public ModuleConverter(StudyProgramConverter studyProgramConverter) {
		this.studyProgramConverter = studyProgramConverter;
	}

	@Override
	public Module toEntity(ModuleDTO d) {
		StudyProgram s=studyProgramConverter.toEntity(d.getStudyProgram());
		return new Module(d.getId(), d.getName(),s);
	}

	@Override
	public ModuleDTO toDto(Module e) {
		StudyProgramDTO programDTO=studyProgramConverter.toDto(e.getStudyProgram());
		List<ModuleSubjectDTO> moduleSubjects=new ArrayList<>();
		return new ModuleDTO(e.getId(), e.getName(), moduleSubjects, programDTO);
	}

}
