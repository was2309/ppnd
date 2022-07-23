package rs.ac.bg.fon.njt.ppnd.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import rs.ac.bg.fon.njt.ppnd.dto.LecturingDTO;
import rs.ac.bg.fon.njt.ppnd.dto.TeachingCoveragePlanDTO;
import rs.ac.bg.fon.njt.ppnd.model.Employee;
import rs.ac.bg.fon.njt.ppnd.model.Lecturer;
import rs.ac.bg.fon.njt.ppnd.model.Lecturing;
import rs.ac.bg.fon.njt.ppnd.model.TeachingCoveragePlan;

public class LecturingConverter implements Converter<LecturingDTO, Lecturing>{

	@Autowired
	TeachingCoveragePlanConverter coveragePlanConverter;
	
	@Override
	public Lecturing toEntity(LecturingDTO d) {
		TeachingCoveragePlan t=coveragePlanConverter.toEntity(d.getTeachingCoveragePlan());
		Lecturer l=(Lecturer) new Employee();
		l.setId(d.getLecturer());
		return new Lecturing(d.getId(), d.getNumberOfClasses(), l, t, d.getTeachingForm());
		
	}

	@Override
	public LecturingDTO toDto(Lecturing e) {
		TeachingCoveragePlanDTO teachingCoverage=coveragePlanConverter.toDto(e.getTeachingCoveragePlan());
		return new LecturingDTO(e.getId(), e.getNumberOfClasses(), e.getLecturer().getId(),teachingCoverage, e.getTeachingForm());
	}



}
