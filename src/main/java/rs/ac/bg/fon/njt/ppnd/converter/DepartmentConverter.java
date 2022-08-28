package rs.ac.bg.fon.njt.ppnd.converter;

import org.springframework.stereotype.Component;
import rs.ac.bg.fon.njt.ppnd.dto.DepartmentDTO;
import rs.ac.bg.fon.njt.ppnd.model.Department;
import rs.ac.bg.fon.njt.ppnd.util.DepartmentType;

@Component
public class DepartmentConverter implements Converter<DepartmentDTO, Department>{

    @Override
    public Department toEntity(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setId(departmentDTO.getId());
        department.setName(departmentDTO.getName());
        department.setNumberOfMembers(departmentDTO.getNumberOfMembers());
        department.setType(DepartmentType.KATEDRA);
        return  department;
    }

    @Override
    public DepartmentDTO toDto(Department department) {
        return new DepartmentDTO(department.getId(), department.getName(), department.getNumberOfMembers());
    }
}
