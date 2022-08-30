package rs.ac.bg.fon.njt.ppnd.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import rs.ac.bg.fon.njt.ppnd.converter.YearConverter;
import rs.ac.bg.fon.njt.ppnd.dto.StudyProgramDTO;
import rs.ac.bg.fon.njt.ppnd.dto.YearDTO;
import rs.ac.bg.fon.njt.ppnd.model.Year;
import rs.ac.bg.fon.njt.ppnd.repository.YearRepository;
import rs.ac.bg.fon.njt.ppnd.service.StudyProgramService;
import rs.ac.bg.fon.njt.ppnd.service.YearService;

public class YearServiceImpl implements YearService{
	
	private final YearRepository yearRepository;
	
	private final StudyProgramService studyProgramService;
	
	private final YearConverter yearConverter;


	public YearServiceImpl(YearRepository yearRepository, StudyProgramService studyProgramService, YearConverter yearConverter) {
		this.yearRepository = yearRepository;
		this.studyProgramService = studyProgramService;
		this.yearConverter = yearConverter;
	}

	@Override
	public YearDTO getById(Long id) {
		try {
			Optional<Year> y=this.yearRepository.findById(id);
			if(y.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Year with given id does note exist!");
			}
			return this.yearConverter.toDto(y.get());
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<YearDTO> getAllYears() {
		try {
			List<Year>years=this.yearRepository.findAll();
			if(years.size()==0) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No saved years!");
			}
		 List<YearDTO> yearDtos=new ArrayList<>();
		 years.forEach((year)->{
			 YearDTO dto=this.yearConverter.toDto(year);
			 yearDtos.add(dto);
		 });
		 return yearDtos;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public YearDTO saveYear(YearDTO yearDTO) {
		try {
			StudyProgramDTO s=this.studyProgramService.getBuyId(yearDTO.getStudyProgram().getId());
			if(s==null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No saved related study program!");
			}
			Year year=this.yearConverter.toEntity(yearDTO);
			Year savedYear=this.yearRepository.save(year);
			return this.yearConverter.toDto(savedYear);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public YearDTO deleteYear(Long id) {
		try {
			Optional<Year> y=this.yearRepository.findById(id);
			if(y.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Year with given id does note exist!");
			}
			Year year = y.get();
			this.yearRepository.delete(year);
			return this.yearConverter.toDto(year);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public YearDTO updateYear(YearDTO yearDto) {
		try {
			Year year=this.yearConverter.toEntity(yearDto);
			Optional<Year> foundYearOptional=this.yearRepository.findById(year.getId());
			if(foundYearOptional.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Year with given id does note exist!");
			}
			Year savedYear=this.yearRepository.save(year);
			return this.yearConverter.toDto(savedYear);
		} catch (Exception e) {
			throw e;
		}
	}

}
