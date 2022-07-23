package rs.ac.bg.fon.njt.ppnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.bg.fon.njt.ppnd.model.Department;


public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
