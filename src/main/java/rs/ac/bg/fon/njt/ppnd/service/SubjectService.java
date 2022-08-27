package rs.ac.bg.fon.njt.ppnd.service;

import java.util.List;

import rs.ac.bg.fon.njt.ppnd.dto.ModuleSubjectDTO;
import rs.ac.bg.fon.njt.ppnd.dto.SubjectDTO;
import rs.ac.bg.fon.njt.ppnd.model.ModuleSubject;

public interface SubjectService {

	public SubjectDTO saveSubject(SubjectDTO subjectDTO);
	public List<SubjectDTO> getAllSubjects();
	public SubjectDTO getById(Long id);
	public SubjectDTO deleteSubject(Long id);
	public SubjectDTO updateSubject(SubjectDTO dto);
	public List<SubjectDTO>getByModuleId(Long moduleId);
}
