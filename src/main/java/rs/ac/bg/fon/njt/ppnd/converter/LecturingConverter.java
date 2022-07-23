package rs.ac.bg.fon.njt.ppnd.converter;

import rs.ac.bg.fon.njt.ppnd.dto.LecturingDTO;
import rs.ac.bg.fon.njt.ppnd.model.Employee;
import rs.ac.bg.fon.njt.ppnd.model.Lecturer;
import rs.ac.bg.fon.njt.ppnd.model.Lecturing;
import rs.ac.bg.fon.njt.ppnd.model.TeachingCoveragePlan;

public class LecturingConverter implements Converter<LecturingDTO, Lecturing>{

	@Override
	public Lecturing toEntity(LecturingDTO d) {
		TeachingCoveragePlan t=new TeachingCoveragePlan();
		t.setId(d.getTeachingCoveragePlan());
		Lecturer l=(Lecturer) new Employee();
		l.setId(d.getLecturer());
		return new Lecturing(d.getId(), d.getNumberOfClasses(), l, t, d.getTeachingForm());
		
	}

	@Override
	public LecturingDTO toDto(Lecturing e) {
		return new LecturingDTO(e.getId(), e.getNumberOfClasses(), e.getLecturer().getId(), e.getTeachingCoveragePlan().getId(), e.getTeachingForm());
	}



}
