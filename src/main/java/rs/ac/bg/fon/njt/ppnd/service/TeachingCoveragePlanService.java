package rs.ac.bg.fon.njt.ppnd.service;

import rs.ac.bg.fon.njt.ppnd.dto.ModuleSubjectDTO;
import rs.ac.bg.fon.njt.ppnd.dto.TeachingCoveragePlanDTO;
import rs.ac.bg.fon.njt.ppnd.dto.YearDTO;

import java.util.List;

public interface TeachingCoveragePlanService {
    List<TeachingCoveragePlanDTO> getAllByYear(YearDTO yearDTO);
    List<TeachingCoveragePlanDTO> getAllByModuleSubject(ModuleSubjectDTO moduleSubjectDTO);
    TeachingCoveragePlanDTO saveTeachingCoveragePlan(TeachingCoveragePlanDTO teachingCoveragePlanDTO);
    boolean deleteTeachingCoveragePlan(Long id);
    TeachingCoveragePlanDTO updateTeachingCoveragePlan(TeachingCoveragePlanDTO teachingCoveragePlanDTO);
}
