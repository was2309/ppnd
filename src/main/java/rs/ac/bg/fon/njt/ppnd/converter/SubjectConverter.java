package rs.ac.bg.fon.njt.ppnd.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import rs.ac.bg.fon.njt.ppnd.dto.DepartmentDTO;
import rs.ac.bg.fon.njt.ppnd.dto.ModuleSubjectDTO;
import rs.ac.bg.fon.njt.ppnd.dto.SubjectDTO;
import rs.ac.bg.fon.njt.ppnd.model.Department;
import rs.ac.bg.fon.njt.ppnd.model.Subject;

@Component
public class SubjectConverter implements Converter<SubjectDTO, Subject>{


	@Autowired
	public SubjectConverter() {

	}

	@Override
	public Subject toEntity(SubjectDTO d) {
		Department department=new Department();
		department.setId(d.getDepartment().getId());
		department.setName(d.getDepartment().getName());
		department.setNumberOfMembers(d.getDepartment().getNumberOfMembers());
		return new Subject(d.getId(), d.getName(), d.getLecutresPerWeek(), d.getExercisesPerWeek(), d.getLabExercisesPerWeek(), department);
	}

	@Override
	public SubjectDTO toDto(Subject e) {
		DepartmentDTO department=new DepartmentDTO(e.getDepartment().getId(), e.getDepartment().getName(), e.getDepartment().getNumberOfMembers());
		List<ModuleSubjectDTO>moduleSubjects=new ArrayList<>();
		return new SubjectDTO(e.getId(), e.getName(), e.getExcerciesPerWeek(), e.getLabExcercisesPerWeek(),e.getLecutresPerWeek(), department, moduleSubjects);
	}

}
