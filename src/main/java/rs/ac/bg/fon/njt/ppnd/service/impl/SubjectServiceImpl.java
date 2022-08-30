package rs.ac.bg.fon.njt.ppnd.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import rs.ac.bg.fon.njt.ppnd.converter.DepartmentConverter;
import rs.ac.bg.fon.njt.ppnd.converter.ModuleConverter;
import rs.ac.bg.fon.njt.ppnd.converter.ModuleSubjectConverter;
import rs.ac.bg.fon.njt.ppnd.converter.SubjectConverter;
import rs.ac.bg.fon.njt.ppnd.dto.ModuleDTO;
import rs.ac.bg.fon.njt.ppnd.dto.SubjectDTO;
import rs.ac.bg.fon.njt.ppnd.model.Module;
import rs.ac.bg.fon.njt.ppnd.model.ModuleSubject;
import rs.ac.bg.fon.njt.ppnd.model.Subject;
import rs.ac.bg.fon.njt.ppnd.repository.SubjectRepository;
import rs.ac.bg.fon.njt.ppnd.service.ModuleService;
import rs.ac.bg.fon.njt.ppnd.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	SubjectConverter subjectConverter;
	
	@Autowired
	ModuleSubjectConverter moduleSubjectConverter;

	@Autowired
	ModuleService moduleService;

	@Autowired
	ModuleConverter moduleConverter;

	@Autowired
	DepartmentConverter departmentConverter;

	@Autowired
	DepartmentServiceImpl departmentService;

	/**
	 * Saves subject from given SubjectDTO
	 * @param subjectDTO - contains info about subject to be saved
	 * @return SubjectDTO of saved subject
	 * @throws ResponseStatusException if there is no department with given id
	 */
	@Override
	public SubjectDTO saveSubject(SubjectDTO subjectDTO) {
		try {
			Subject s=this.subjectConverter.toEntity(subjectDTO);
			List<ModuleSubject>moduleSubjects=new ArrayList<>();
			if(subjectDTO.getModuleSubjects() != null){
				subjectDTO.getModuleSubjects().forEach((moduleSubject)->{
					ModuleSubject dto=this.moduleSubjectConverter.toEntity(moduleSubject);
					moduleSubjects.add(dto);
				});
				s.setModuleSubjects(moduleSubjects);
			}
			Subject saved=this.subjectRepository.save(s);
			return this.subjectConverter.toDto(saved);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Problem with saving subject!");
		}
	}

	/**
	 * Returns all subjects
	 * @return List of SubjectDTOs
	 * @throws ResponseStatusException if there is no saved subjects
	 */
	@Override
	public List<SubjectDTO> getAllSubjects() {
		try {
			List<Subject>subjects=this.subjectRepository.findAll();
			if(subjects.size()==0) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No saved subjects!");
			}
			List<SubjectDTO>subjectDtos=new ArrayList<>();
			subjects.forEach((subject)->{
				SubjectDTO dto=this.subjectConverter.toDto(subject);
				subjectDtos.add(dto);
			});
			return subjectDtos;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Returns subject founded by given id
	 * @param id - id of the subject
	 * @return SubjectDTO of founded subject
	 * @throws ResponseStatusException if there is no saved subject with given id
	 */
	@Override
	public SubjectDTO getById(Long id) {
		try {
			Optional<Subject> s=this.subjectRepository.findById(id);
			if(s.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No saved subject with given id!");
			}
			Subject subject = s.get();
			return this.subjectConverter.toDto(subject);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Deletes subject with given id
	 * @param id - id of the subject
	 * @return SubjectDTO of deleted subject
	 * @throws ResponseStatusException if there is no subject with given id
	 */
	@Override
	public SubjectDTO deleteSubject(Long id) {
		try {
			Optional<Subject> s=this.subjectRepository.findById(id);
			if(s.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No saved subject with given id!");
			}
			Subject subject = s.get();
			this.subjectRepository.delete(subject);
			return this.subjectConverter.toDto(subject);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Updates subject from given SubjectDTO
	 * @param dto - SubjectDTO of subject ot be updated
	 * @return SubjectDTO of updated subject
	 * @throws ResponseStatusException if there is no saved subject with given id
	 */
	@Override
	public SubjectDTO updateSubject(SubjectDTO dto) {
		try {
			Optional<Subject> s=this.subjectRepository.findById(dto.getId());
			if(s.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No saved subject with given id!");
			}
			Subject mergedSubject=this.subjectConverter.toEntity(dto);
			Subject savedSubject=this.subjectRepository.save(mergedSubject);
			return this.subjectConverter.toDto(savedSubject);
			
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Returns subjects from specific module
	 * @param moduleId - id of the module
	 * @return List of SubjectDTOs
	 * @throws ResponseStatusException if there is no module with given id
	 */
	@Override
	public List<SubjectDTO> getByModuleId(Long moduleId) {
		try {
			ModuleDTO module=this.moduleService.getById(moduleId);
			if(module==null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Module with given id does not exist!");
			}

			Module m=this.moduleConverter.toEntity(module);
			ModuleSubject moduleSubject=new ModuleSubject();
			moduleSubject.setModule(m);

			List<Subject>subjects=this.subjectRepository.getAllByModuleSubjects(moduleSubject);
			List<SubjectDTO>subjectsDto=new ArrayList<>();
			subjects.forEach((subject)->{
				SubjectDTO dto=this.subjectConverter.toDto(subject);
				subjectsDto.add(dto);
			});
			return subjectsDto;
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	
}
