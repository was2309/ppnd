package rs.ac.bg.fon.njt.ppnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.bg.fon.njt.ppnd.model.ModuleSubject;
import rs.ac.bg.fon.njt.ppnd.model.Module;
import rs.ac.bg.fon.njt.ppnd.model.Subject;

import java.util.List;

public interface ModuleSubjectRepository extends JpaRepository<ModuleSubject, Long>{
    List<ModuleSubject> findAllByModule(Module module);
    List<ModuleSubject> findAllBySubject(Subject subject);
}
