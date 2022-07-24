package rs.ac.bg.fon.njt.ppnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.bg.fon.njt.ppnd.model.ModuleSubject;
import rs.ac.bg.fon.njt.ppnd.model.TeachingCoveragePlan;
import rs.ac.bg.fon.njt.ppnd.model.Year;

import java.util.List;

public interface TeachingCoveragePlanRepository extends JpaRepository<TeachingCoveragePlan, Long>{
    List<TeachingCoveragePlan> findAllByYear(Year year);
    List<TeachingCoveragePlan> findAllByModuleSubject(ModuleSubject moduleSubject);
}
