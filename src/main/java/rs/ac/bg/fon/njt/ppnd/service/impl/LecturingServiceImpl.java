package rs.ac.bg.fon.njt.ppnd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
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

@Service
public class LecturingServiceImpl implements LecturingService {

    private final LecturingRepository lecturingRepository;
    private final TeachingCoveragePlanRepository teachingCoveragePlanRepository;
    private final LecturingConverter lecturingConverter;
    private final TeachingCoveragePlanService teachingCoveragePlanService;
    private final TeachingCoveragePlanConverter teachingCoveragePlanConverter;
    private final LecturerRepository lecturerRepository;
    private final int NUM_OF_CLASSES = 13;
    @Autowired
    public LecturingServiceImpl(LecturingRepository lecturingRepository, TeachingCoveragePlanRepository teachingCoveragePlanRepository, LecturingConverter lecturingConverter, TeachingCoveragePlanServiceImpl teachingCoveragePlanService, TeachingCoveragePlanConverter teachingCoveragePlanConverter, LecturerRepository lecturerRepository) {
        this.lecturingRepository = lecturingRepository;
        this.teachingCoveragePlanRepository = teachingCoveragePlanRepository;
        this.lecturingConverter = lecturingConverter;
        this.teachingCoveragePlanService = teachingCoveragePlanService;
        this.teachingCoveragePlanConverter = teachingCoveragePlanConverter;
        this.lecturerRepository = lecturerRepository;
    }



    @Override
    public LecturingDTO saveLecturing(LecturingDTO lecturingDTO) {
        try{
            Lecturing lecturing = lecturingConverter.toEntity(lecturingDTO);
            if(lecturing.getNumberOfClasses() > NUM_OF_CLASSES){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lecturer cannot have more than "+ NUM_OF_CLASSES + " classes per module subject!");
            }
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
        List<LecturingDTO> savedLecturings = new ArrayList<>();
        try {
            for (LecturingDTO lecturingDTO : lecturingDTOs) {
                Lecturing lecturing = lecturingConverter.toEntity(lecturingDTO);
                if(lecturing.getNumberOfClasses() > NUM_OF_CLASSES){
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lecturer cannot have more than "+ NUM_OF_CLASSES + " classes per module subject!");
                }
                Optional<TeachingCoveragePlan> teachingCoveragePlan = teachingCoveragePlanRepository.findById(lecturing.getTeachingCoveragePlan().getId());
                if (teachingCoveragePlan.isEmpty()) {
                    TeachingCoveragePlanDTO tcdSaved = this.teachingCoveragePlanService.saveTeachingCoveragePlan(teachingCoveragePlanConverter.toDto(lecturing.getTeachingCoveragePlan()));
                    lecturing.setTeachingCoveragePlan(teachingCoveragePlanConverter.toEntity(tcdSaved));
                }
                Optional<Lecturer> lecturer = lecturerRepository.findById(lecturing.getLecturer().getId());
                if (lecturer.isEmpty()) {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lecturer with given id does not exist!");
                }
                lecturing.setLecturer(lecturer.get());
                Lecturing savedLecturing = this.lecturingRepository.save(lecturing);
                LecturingDTO savedLecturingDTO = lecturingConverter.toDto(savedLecturing);
                savedLecturings.add(savedLecturingDTO);
            }
            if (savedLecturings.size() != lecturingDTOs.size()) {
                return new ArrayList<>();
            }
            return savedLecturings;
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Problem with saving lecturings!");
        }

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
           if(lecturings.isEmpty()){
               return new ArrayList<>();
           }
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