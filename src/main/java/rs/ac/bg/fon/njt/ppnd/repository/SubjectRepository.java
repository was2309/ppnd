package rs.ac.bg.fon.njt.ppnd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.bg.fon.njt.ppnd.model.ModuleSubject;
import rs.ac.bg.fon.njt.ppnd.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>{

	public List<Subject> getAllByModuleSubjects(ModuleSubject moduleSubject);
}
