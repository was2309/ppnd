package rs.ac.bg.fon.njt.service;

import java.util.List;

import rs.ac.bg.fon.njt.ppnd.dto.SubjectDTO;

public interface SubjectService {

	public SubjectDTO saveSubject(SubjectDTO subjectDTO);
	public List<SubjectDTO> getAllSubjects();
	public SubjectDTO getById(Long id);
	public SubjectDTO deleteSubject(Long id);
	public SubjectDTO updateSubject(SubjectDTO dto);
}
