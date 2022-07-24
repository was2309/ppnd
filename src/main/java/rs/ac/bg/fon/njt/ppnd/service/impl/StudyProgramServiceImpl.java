package rs.ac.bg.fon.njt.ppnd.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import rs.ac.bg.fon.njt.ppnd.converter.StudyProgramConverter;
import rs.ac.bg.fon.njt.ppnd.dto.StudyProgramDTO;
import rs.ac.bg.fon.njt.ppnd.model.StudyProgram;
import rs.ac.bg.fon.njt.ppnd.repository.StudyProgramRepository;
import rs.ac.bg.fon.njt.ppnd.service.StudyProgramService;

public class StudyProgramServiceImpl implements StudyProgramService{
	
	@Autowired
	StudyProgramRepository studyProgramRepository;
	
	@Autowired
	StudyProgramConverter studyProgramConverter;

	@Override
	public StudyProgramDTO getBuyId(Long id) {
		try {
			StudyProgram program=this.studyProgramRepository.findById(id).get();
			if(program==null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Study program with given id does not exist!");
			}
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
			StudyProgram foundStudyProgram=this.studyProgramRepository.findById(id).get();
			if(foundStudyProgram==null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Study program with given id does not exist!");
			}
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
				studyPrograms.add(studyProgram);
			});
			return dto;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public StudyProgramDTO updateStudyProgram(StudyProgramDTO studyProgram) {
		try {
			StudyProgram foundStudyProgram=this.studyProgramRepository.findById(studyProgram.getId()).get();
			if(foundStudyProgram==null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Study program with given id does not exist!");
			}
			foundStudyProgram.setName(studyProgram.getName());
			StudyProgram updatedStudyProgram=this.studyProgramRepository.save(foundStudyProgram);
			return this.studyProgramConverter.toDto(updatedStudyProgram);
		} catch (Exception e) {
			throw e;
		}
	}

}
