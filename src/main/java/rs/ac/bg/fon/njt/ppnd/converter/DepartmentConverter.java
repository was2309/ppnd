package rs.ac.bg.fon.njt.ppnd.converter;

import rs.ac.bg.fon.njt.ppnd.dto.DepartmentDTO;
import rs.ac.bg.fon.njt.ppnd.model.Department;

public class DepartmentConverter implements Converter<DepartmentDTO, Department>{

    @Override
    public Department toEntity(DepartmentDTO departmentDTO) {
        return null;
    }

    @Override
    public DepartmentDTO toDto(Department department) {
        return new DepartmentDTO(department.getId(), department.getName(), department.getNumberOfMembers());
    }
}