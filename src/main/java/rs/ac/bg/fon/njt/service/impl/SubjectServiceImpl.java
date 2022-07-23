package rs.ac.bg.fon.njt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import rs.ac.bg.fon.njt.ppnd.converter.ModuleSubjectConverter;
import rs.ac.bg.fon.njt.ppnd.converter.SubjectConverter;
import rs.ac.bg.fon.njt.ppnd.dto.ModuleSubjectDTO;
import rs.ac.bg.fon.njt.ppnd.dto.SubjectDTO;
import rs.ac.bg.fon.njt.ppnd.model.ModuleSubject;
import rs.ac.bg.fon.njt.ppnd.model.Subject;
import rs.ac.bg.fon.njt.ppnd.repository.SubjectRepository;
import rs.ac.bg.fon.njt.service.SubjectService;

public class SubjectServiceImpl implements SubjectService {

	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	SubjectConverter subjectConverter;
	
	@Autowired
	ModuleSubjectConverter moduleSubjectConverter;

	@Override
	public SubjectDTO saveSubject(SubjectDTO subjectDTO) {
		try {
			Subject s=this.subjectConverter.toEntity(subjectDTO);
			List<ModuleSubject>moduleSubjects=new ArrayList<>();
			subjectDTO.getModuleSubjects().forEach((moduleSubject)->{
				ModuleSubject dto=this.moduleSubjectConverter.toEntity(moduleSubject);
				moduleSubjects.add(dto);
			});
			s.setModuleSubjects(moduleSubjects);
			Subject saved=this.subjectRepository.save(s);
			return this.subjectConverter.toDto(saved);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Problem with saving subject!");
		}
	}

	@Override
	public List<SubjectDTO> getAllSubjects() {
		try {
			List<Subject>subjects=this.subjectRepository.findAll();
			if(subjects==null || subjects.size()==0) {
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

	@Override
	public SubjectDTO getById(Long id) {
		try {
			Subject s=this.subjectRepository.findById(id).get();
			if(s==null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No saved subject with given id!");
			}
			return this.subjectConverter.toDto(s);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public SubjectDTO deleteSubject(Long id) {
		try {
			Subject s=this.subjectRepository.findById(id).get();
			if(s==null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No saved subject with given id!");
			}
			this.subjectRepository.delete(s);
			return this.subjectConverter.toDto(s);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public SubjectDTO updateSubject(SubjectDTO dto) {
		try {
			Subject foundSubject=this.subjectRepository.findById(dto.getId()).get();
			if(foundSubject==null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No saved subject with given id!");
			}
			Subject mergedSubject=this.subjectConverter.toEntity(dto);
			Subject savedSubject=this.subjectRepository.save(mergedSubject);
			return this.subjectConverter.toDto(savedSubject);
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	
}
