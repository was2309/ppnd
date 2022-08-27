package rs.ac.bg.fon.njt.ppnd.service;

import rs.ac.bg.fon.njt.ppnd.dto.TeachingCoveragePlanDTO;

import java.util.List;

public interface TeachingCoveragePlanService {
    List<TeachingCoveragePlanDTO> getAllByYear(Long yearId);
    List<TeachingCoveragePlanDTO> getAllByModuleSubject(Long moduleSubjectId);
    TeachingCoveragePlanDTO findById(Long id);
    TeachingCoveragePlanDTO saveTeachingCoveragePlan(TeachingCoveragePlanDTO teachingCoveragePlanDTO);
    TeachingCoveragePlanDTO deleteTeachingCoveragePlan(Long id);
}
