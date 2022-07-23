package rs.ac.bg.fon.njt.ppnd.converter;

import org.springframework.beans.factory.annotation.Autowired;

import rs.ac.bg.fon.njt.ppnd.dto.ModuleDTO;
import rs.ac.bg.fon.njt.ppnd.dto.ModuleSubjectDTO;
import rs.ac.bg.fon.njt.ppnd.dto.SubjectDTO;
import rs.ac.bg.fon.njt.ppnd.model.ModuleSubject;
import rs.ac.bg.fon.njt.ppnd.model.Subject;

public class ModuleSubjectConverter implements Converter<ModuleSubjectDTO, ModuleSubject>{

	@Autowired
	SubjectConverter subjectConverter;
	
	@Autowired
	ModuleConverter moduleConverter;
	
	@Override
	public ModuleSubject toEntity(ModuleSubjectDTO d) {
		Subject s=subjectConverter.toEntity(d.getSubject());
		rs.ac.bg.fon.njt.ppnd.model.Module m=moduleConverter.toEntity(d.getModule());
		return new ModuleSubject(d.getId(),d.getPosition(),d.getSemester(),d.getSubjectType(),d.getNumOfESPB(),s,m);
	}

	@Override
	public ModuleSubjectDTO toDto(ModuleSubject e) {
		SubjectDTO s=subjectConverter.toDto(e.getSubject());
		ModuleDTO m=moduleConverter.toDto(e.getModule());
		return new ModuleSubjectDTO(e.getId(), e.getPosition(), e.getSemester(), e.getSubjectType(), e.getNumOfESPB(), s, m);
	}

}