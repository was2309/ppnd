package rs.ac.bg.fon.njt.ppnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.bg.fon.njt.ppnd.model.Lecturing;

import java.util.List;

public interface LecturingRepository extends JpaRepository<Lecturing, Long>{
    List<Lecturing> findAllByTeachingCoveragePlanId(Long teachingCoveragePlanId);
}
