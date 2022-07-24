package rs.ac.bg.fon.njt.ppnd.service;

import rs.ac.bg.fon.njt.ppnd.dto.ModuleSubjectDTO;
import rs.ac.bg.fon.njt.ppnd.dto.TeachingCoveragePlanDTO;
import rs.ac.bg.fon.njt.ppnd.dto.YearDTO;

import java.util.List;

public interface TeachingCoveragePlanService {
    List<TeachingCoveragePlanDTO> getAllByYear(YearDTO yearDTO);
    List<TeachingCoveragePlanDTO> getAllByModuleSubject(ModuleSubjectDTO moduleSubjectDTO);
    TeachingCoveragePlanDTO findById(Long id);
    TeachingCoveragePlanDTO saveTeachingCoveragePlan(TeachingCoveragePlanDTO teachingCoveragePlanDTO);
    TeachingCoveragePlanDTO deleteTeachingCoveragePlan(Long id);
}
