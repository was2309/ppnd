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
import rs.ac.bg.fon.njt.ppnd.service.impl.DepartmentServiceImpl;

@Component
public class SubjectConverter implements Converter<SubjectDTO, Subject>{


	@Autowired
	DepartmentConverter departmentConverter;

	@Autowired
	DepartmentServiceImpl departmentService;

	@Override
	public Subject toEntity(SubjectDTO d) {
		Department department=this.departmentConverter.toEntity(this.departmentService.getDepartmentById(d.getDepartment().getId()));
		Subject s = new Subject(d.getId(), d.getName(), d.getLecutresPerWeek(), d.getExercisesPerWeek(), d.getLabExercisesPerWeek(), department);

		return s;

	}

	@Override
	public SubjectDTO toDto(Subject e) {
		DepartmentDTO department=new DepartmentDTO(e.getDepartment().getId(), e.getDepartment().getName(), e.getDepartment().getNumberOfMembers());
		List<ModuleSubjectDTO>moduleSubjects=new ArrayList<>();
		return new SubjectDTO(e.getId(), e.getName(), e.getExcerciesPerWeek(), e.getLabExcercisesPerWeek(),e.getLecutresPerWeek(), department, moduleSubjects);
	}

}
