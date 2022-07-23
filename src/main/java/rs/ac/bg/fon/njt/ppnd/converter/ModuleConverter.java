package rs.ac.bg.fon.njt.ppnd.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import rs.ac.bg.fon.njt.ppnd.dto.ModuleDTO;
import rs.ac.bg.fon.njt.ppnd.dto.ModuleSubjectDTO;
import rs.ac.bg.fon.njt.ppnd.dto.StudyProgramDTO;
import rs.ac.bg.fon.njt.ppnd.model.Module;
import rs.ac.bg.fon.njt.ppnd.model.StudyProgram;

public class ModuleConverter implements Converter<ModuleDTO, Module>{

	@Autowired
	StudyProgramConverter studyProgramConverter;
	
	@Autowired
	ModuleSubjectConverter moduleSubjectConverter;
	
	@Override
	public Module toEntity(ModuleDTO d) {
		StudyProgram s=studyProgramConverter.toEntity(d.getStudyProgram());
		return new Module(d.getId(), d.getName(),s);
	}

	@Override
	public ModuleDTO toDto(Module e) {
		StudyProgramDTO programDTO=studyProgramConverter.toDto(e.getStudyProgram());
		List<ModuleSubjectDTO> moduleSubjects=new ArrayList<>();
		e.getModuleSubjects().forEach((moduleSubject)->{
			ModuleSubjectDTO d=moduleSubjectConverter.toDto(moduleSubject);
			moduleSubjects.add(d);
		});
		return new ModuleDTO(e.getId(), e.getName(), moduleSubjects, programDTO);
	}

}
