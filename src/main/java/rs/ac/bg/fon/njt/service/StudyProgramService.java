package rs.ac.bg.fon.njt.service;

import java.util.List;

import rs.ac.bg.fon.njt.ppnd.dto.StudyProgramDTO;

public interface StudyProgramService {

	public StudyProgramDTO getBuyId(Long id);
	public StudyProgramDTO saveStudyProgram(StudyProgramDTO studyProgram);
	public StudyProgramDTO deleteStudyProgram(Long id);
	public List<StudyProgramDTO> getAllStudyPrograms();
	public StudyProgramDTO updateStudyProgram(StudyProgramDTO studyProgram);
	
}
