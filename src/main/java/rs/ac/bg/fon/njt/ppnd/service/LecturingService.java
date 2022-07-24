package rs.ac.bg.fon.njt.ppnd.service;

import rs.ac.bg.fon.njt.ppnd.dto.LecturerDTO;
import rs.ac.bg.fon.njt.ppnd.dto.LecturingDTO;
import rs.ac.bg.fon.njt.ppnd.dto.TeachingCoveragePlanDTO;

import java.util.List;

public interface LecturingService {
    LecturingDTO saveLecturing(LecturingDTO lecturingDTO);
    List<LecturingDTO> saveListOfLecturings(List<LecturingDTO> lecturingDTOs);
    LecturingDTO deleteLecturing(Long id);
    LecturingDTO updateLecturing(LecturingDTO lecturingDTO);
    LecturingDTO getById(Long id);
    List<LecturingDTO> getAllLecturingsByTCP(Long teachingCoveragePlanId);
}
