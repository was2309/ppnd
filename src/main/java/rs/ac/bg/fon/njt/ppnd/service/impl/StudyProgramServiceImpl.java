package rs.ac.bg.fon.njt.ppnd.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import rs.ac.bg.fon.njt.ppnd.converter.StudyProgramConverter;
import rs.ac.bg.fon.njt.ppnd.dto.StudyProgramDTO;
import rs.ac.bg.fon.njt.ppnd.model.StudyProgram;
import rs.ac.bg.fon.njt.ppnd.repository.StudyProgramRepository;
import rs.ac.bg.fon.njt.ppnd.service.StudyProgramService;
@Service
public class StudyProgramServiceImpl implements StudyProgramService{
	
	@Autowired
	StudyProgramRepository studyProgramRepository;
	
	@Autowired
	StudyProgramConverter studyProgramConverter;

	@Override
	public StudyProgramDTO getBuyId(Long id) {
		try {
			Optional<StudyProgram> studyProgram=this.studyProgramRepository.findById(id);
			if(studyProgram.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Study program with given id does not exist!");
			}
			StudyProgram program = studyProgram.get();
			return this.studyProgramConverter.toDto(program);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public StudyProgramDTO saveStudyProgram(StudyProgramDTO studyProgram) {
		try {
			StudyProgram s=this.studyProgramConverter.toEntity(studyProgram);
			StudyProgram savedStudyProgram=this.studyProgramRepository.save(s);
			return this.studyProgramConverter.toDto(savedStudyProgram);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	}

	@Override
	public StudyProgramDTO deleteStudyProgram(Long id) {
		try {
			Optional<StudyProgram> studyProgram=this.studyProgramRepository.findById(id);
			if(studyProgram.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Study program with given id does not exist!");
			}
			StudyProgram foundStudyProgram = studyProgram.get();
			this.studyProgramRepository.delete(foundStudyProgram);
			return this.studyProgramConverter.toDto(foundStudyProgram);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	@Override
	public List<StudyProgramDTO> getAllStudyPrograms() {
		try {
			List<StudyProgram>studyPrograms=this.studyProgramRepository.findAll();
			if(studyPrograms.size()==0) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No saved study programs!");
			}
			List<StudyProgramDTO> dto=new ArrayList<>();
			studyPrograms.forEach((studyProgram)->{
				StudyProgramDTO s=this.studyProgramConverter.toDto(studyProgram);
				dto.add(s);
			});
			return dto;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public StudyProgramDTO updateStudyProgram(StudyProgramDTO studyProgramDTO) {
		try {
			Optional<StudyProgram> studyProgram=this.studyProgramRepository.findById(studyProgramDTO.getId());
			if(studyProgram.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Study program with given id does not exist!");
			}
			StudyProgram foundStudyProgram = studyProgram.get();
			foundStudyProgram.setName(studyProgramDTO.getName());
			StudyProgram updatedStudyProgram=this.studyProgramRepository.save(foundStudyProgram);
			return this.studyProgramConverter.toDto(updatedStudyProgram);
		} catch (Exception e) {
			throw e;
		}
	}

}
