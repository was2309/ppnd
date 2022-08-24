package rs.ac.bg.fon.njt.ppnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.bg.fon.njt.ppnd.model.Lecturer;

import java.util.List;

public interface LecturerRepository extends JpaRepository<Lecturer, Long> {
    List<Lecturer> findByDepartmentId(Long departmentID);
}
