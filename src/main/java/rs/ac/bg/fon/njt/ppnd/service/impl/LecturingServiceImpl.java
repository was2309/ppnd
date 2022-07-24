package rs.ac.bg.fon.njt.ppnd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.bg.fon.njt.ppnd.converter.LecturingConverter;
import rs.ac.bg.fon.njt.ppnd.converter.TeachingCoveragePlanConverter;
import rs.ac.bg.fon.njt.ppnd.dto.LecturingDTO;
import rs.ac.bg.fon.njt.ppnd.dto.TeachingCoveragePlanDTO;
import rs.ac.bg.fon.njt.ppnd.model.Lecturer;
import rs.ac.bg.fon.njt.ppnd.model.Lecturing;
import rs.ac.bg.fon.njt.ppnd.model.TeachingCoveragePlan;
import rs.ac.bg.fon.njt.ppnd.repository.LecturerRepository;
import rs.ac.bg.fon.njt.ppnd.repository.LecturingRepository;
import rs.ac.bg.fon.njt.ppnd.repository.TeachingCoveragePlanRepository;
import rs.ac.bg.fon.njt.ppnd.service.LecturingService;
import rs.ac.bg.fon.njt.ppnd.service.TeachingCoveragePlanService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LecturingServiceImpl implements LecturingService {

    @Autowired
    LecturingRepository lecturingRepository;
    @Autowired
    TeachingCoveragePlanRepository teachingCoveragePlanRepository;
    @Autowired
    LecturingConverter lecturingConverter;

    @Autowired
    TeachingCoveragePlanService teachingCoveragePlanService;
    @Autowired
    TeachingCoveragePlanConverter teachingCoveragePlanConverter;

    @Autowired
    LecturerRepository lecturerRepository;


    public LecturingServiceImpl(LecturingRepository lecturingRepository, TeachingCoveragePlanRepository teachingCoveragePlanRepository, LecturingConverter lecturingConverter, TeachingCoveragePlanServiceImpl teachingCoveragePlanService, TeachingCoveragePlanConverter teachingCoveragePlanConverter, LecturerRepository lecturerRepository) {
        this.lecturingRepository = lecturingRepository;
        this.teachingCoveragePlanRepository = teachingCoveragePlanRepository;
        this.lecturingConverter = lecturingConverter;
        this.teachingCoveragePlanService = teachingCoveragePlanService;
        this.teachingCoveragePlanConverter = teachingCoveragePlanConverter;
        this.lecturerRepository = lecturerRepository;
    }

    //    @Autowired
//    LecturerConverter lecturerConverter;

    @Override
    public LecturingDTO saveLecturing(LecturingDTO lecturingDTO) {
        try{
            Lecturing lecturing = lecturingConverter.toEntity(lecturingDTO);
            Optional<TeachingCoveragePlan> teachingCoveragePlan = teachingCoveragePlanRepository.findById(lecturing.getTeachingCoveragePlan().getId());
            if(teachingCoveragePlan.isEmpty()){
                TeachingCoveragePlanDTO tcdSaved = this.teachingCoveragePlanService.saveTeachingCoveragePlan(teachingCoveragePlanConverter.toDto(lecturing.getTeachingCoveragePlan()));
                lecturing.setTeachingCoveragePlan(teachingCoveragePlanConverter.toEntity(tcdSaved));
            }
            Optional<Lecturer> lecturer = lecturerRepository.findById(lecturing.getLecturer().getId());
            if(lecturer.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Lecturer with given id does not exist!");
            }
            lecturing.setLecturer(lecturer.get());
            Lecturing savedLecturing = this.lecturingRepository.save(lecturing);

            return lecturingConverter.toDto(savedLecturing);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Problem with saving lecturing!");
        }
    }

    @Override
    public List<LecturingDTO> saveListOfLecturings(List<LecturingDTO> lecturingDTOs) {
        return null;
    }

    @Override
    public LecturingDTO deleteLecturing(Long id) {
        try{
            Optional<Lecturing> l = lecturingRepository.findById(id);
            if(l.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No saved lecturing with given id!");
            }
            this.lecturingRepository.delete(l.get());
            return this.lecturingConverter.toDto(l.get());
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public LecturingDTO updateLecturing(LecturingDTO lecturingDTO) {
        return null;
    }

    @Override
    public LecturingDTO getById(Long id) {
        try{
            Optional<Lecturing> l = lecturingRepository.findById(id);
            if(l.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No saved lecturing with given id!");
            }
            return this.lecturingConverter.toDto(l.get());
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<LecturingDTO> getAllLecturingsByTCP(Long teachingCoveragePlanId) {
       try{
           TeachingCoveragePlanDTO tcpDto = teachingCoveragePlanService.findById(teachingCoveragePlanId);
           List<Lecturing> lecturings = lecturingRepository.findAllByTeachingCoveragePlanId(tcpDto.getId());
           //maybe add validation if list is empty
           List<LecturingDTO> lecturingDTOS = new ArrayList<>();
           for(Lecturing lecturing:lecturings){
                LecturingDTO ldto = lecturingConverter.toDto(lecturing);
                lecturingDTOS.add(ldto);
           }
           return lecturingDTOS;
       }catch (Exception e){
           throw e;
       }

    }
}
