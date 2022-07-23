package rs.ac.bg.fon.njt.ppnd.service;

import rs.ac.bg.fon.njt.ppnd.dto.LecturerDTO;
import rs.ac.bg.fon.njt.ppnd.dto.LecturingDTO;
import rs.ac.bg.fon.njt.ppnd.dto.TeachingCoveragePlanDTO;

import java.util.List;

public interface LecturingService {
    LecturingDTO saveLecturing(LecturingDTO lecturingDTO);
    List<LecturingDTO> saveListOfLecutrings(List<LecturingDTO> lecturingDTOs);
    boolean deleteLecturing(Long id);
    LecturingDTO updateLecturing(LecturingDTO lecturingDTO);
    List<LecturingDTO> getAllLecturingsByTCP(TeachingCoveragePlanDTO teachingCoveragePlanDTO);
}
