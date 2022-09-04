package rs.ac.bg.fon.njt.ppnd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.bg.fon.njt.ppnd.converter.TeachingCoveragePlanConverter;
import rs.ac.bg.fon.njt.ppnd.dto.LecturerDTO;
import rs.ac.bg.fon.njt.ppnd.dto.LecturingDTO;
import rs.ac.bg.fon.njt.ppnd.dto.TeachingCoveragePlanDTO;
import rs.ac.bg.fon.njt.ppnd.model.*;
import rs.ac.bg.fon.njt.ppnd.repository.*;
import rs.ac.bg.fon.njt.ppnd.service.TeachingCoveragePlanService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service implementation which contains business logic for teaching coverage plan entity
 *
 * @author Vasilije
 */
@Service
public class TeachingCoveragePlanServiceImpl implements TeachingCoveragePlanService {

    /**
     * Repository for teaching coverage plan entity
     */
    private final TeachingCoveragePlanRepository teachingCoveragePlanRepository;
    /**
     * Converter for teaching coverage plan entity
     */
    private final TeachingCoveragePlanConverter teachingCoveragePlanConverter;
    /**
     * Repository for year entity
     */
    private final YearRepository yearRepository;
    /**
     * Repository for moduleSubject entity
     */
    private final ModuleSubjectRepository moduleSubjectRepository;
    /**
     * Service for saving teaching coverage plan in json file
     */
    private final SaveTCPInJsonFileServiceImpl saveTCPInJsonFileService;
    /**
     * Repository for lecturer entity
     */
    private final LecturerRepository lecturerRepository;
    /**
     * Repository for lecturing entity
     */
    private final LecturingRepository lecturingRepository;

    /**
     * Constructor with parameters
     * @param teachingCoveragePlanConverter - Converter for teaching coverage plan entity
     * @param yearRepository - Repository for year entity
     * @param moduleSubjectRepository - Repository for moduleSubject entity
     * @param saveTCPInJsonFileService - Service for saving teaching coverage plan in json file
     * @param teachingCoveragePlanRepository - Repository for teaching coverage plan entity
     * @param lecturerRepository - Repository for lecturer entity
     * @param lecturingRepository - Repository for lecturing entity
     */
    @Autowired
    public TeachingCoveragePlanServiceImpl(TeachingCoveragePlanConverter teachingCoveragePlanConverter, YearRepository yearRepository, ModuleSubjectRepository moduleSubjectRepository, SaveTCPInJsonFileServiceImpl saveTCPInJsonFileService, TeachingCoveragePlanRepository teachingCoveragePlanRepository, LecturerRepository lecturerRepository, LecturingRepository lecturingRepository) {
        this.teachingCoveragePlanConverter = teachingCoveragePlanConverter;
        this.yearRepository =yearRepository;
        this.moduleSubjectRepository = moduleSubjectRepository;
        this.saveTCPInJsonFileService = saveTCPInJsonFileService;
        this.teachingCoveragePlanRepository = teachingCoveragePlanRepository;
        this.lecturerRepository = lecturerRepository;
        this.lecturingRepository = lecturingRepository;
    }

    /**
     * Returns all teaching covering plans for specific yearId
     * @param yearId - id of the year
     * @return List of TeachingCoveragePlanDTO
     * @throws ResponseStatusException if there is no saved teaching covering plans for specific yearId, or if there is no year with given id
     */
    @Override
    @Transactional
    public List<TeachingCoveragePlanDTO> getAllByYear(Long yearId) {
        try{
            Optional<Year> y = this.yearRepository.findById(yearId);
            if(y.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no year with given id");
            }
            Year year = y.get();
            List<TeachingCoveragePlan> tcps = this.teachingCoveragePlanRepository.findAllByYear(year);
            if(tcps.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No saved teaching coverage plans for given year!");
            }
            List<TeachingCoveragePlanDTO> tcpsDTOs = new ArrayList<>();
            for(TeachingCoveragePlan tcp:tcps){
                TeachingCoveragePlanDTO tcpDTO = teachingCoveragePlanConverter.toDto(tcp);
                tcpsDTOs.add(tcpDTO);
            }
            return tcpsDTOs;
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * Returns all teaching covering plans for specific moduleSubjectId
     * @param moduleSubjectId - id of the module
     * @return List of TeachingCoveragePlanDTO
     * @throws ResponseStatusException if there is no saved teaching covering plans for specific moduleSubjectId, or there is no module subject with given id
     */
    @Override
    @Transactional
    public List<TeachingCoveragePlanDTO> getAllByModuleSubject(Long moduleSubjectId) {
        try{
            Optional<ModuleSubject> ms = this.moduleSubjectRepository.findById(moduleSubjectId);
            if(ms.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no module subject with given id");
            }
            ModuleSubject moduleSubject = ms.get();
            List<TeachingCoveragePlan> tcps = this.teachingCoveragePlanRepository.findAllByModuleSubject(moduleSubject);
            if(tcps.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No saved teaching coverage plans for given subject in selected module!");
            }
            List<TeachingCoveragePlanDTO> tcpsDTOs = new ArrayList<>();
            for(TeachingCoveragePlan tcp:tcps){
                TeachingCoveragePlanDTO tcpDTO = teachingCoveragePlanConverter.toDto(tcp);
                tcpsDTOs.add(tcpDTO);
            }
            return tcpsDTOs;
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * Returns teaching coverage plan founded by id
     * @param id - id of the teaching coverage plan
     * @return TeachingCoveragePlanDTO of the founded teaching coverage plan
     * @throws ResponseStatusException if there is no saved teaching coverage plan with given id
     */
    @Override
    public TeachingCoveragePlanDTO findById(Long id) {
        try{
            Optional<TeachingCoveragePlan> tcp = this.teachingCoveragePlanRepository.findById(id);
            if(tcp.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No saved teaching coverage plan with given id!");
            }
            TeachingCoveragePlan tcpFounded = tcp.get();
            TeachingCoveragePlanDTO founded = this.teachingCoveragePlanConverter.toDto(tcpFounded);

            List<LecturingDTO> lecturingDTOS = new ArrayList<>();

            tcpFounded.getLecturings().forEach(lecturing -> {
                LecturerDTO lecturerDTO = new LecturerDTO();
                lecturerDTO.setId(lecturing.getLecturer().getId());
                lecturerDTO.setAcademicTitle(lecturing.getLecturer().getAcademicTitle());
                lecturerDTO.setFirstName(lecturing.getLecturer().getFirstName());
                lecturerDTO.setLastName(lecturing.getLecturer().getLastName());

                LecturingDTO lecturingDTO = new LecturingDTO();
                lecturingDTO.setId(lecturing.getId());
                lecturingDTO.setTeachingForm(lecturing.getTeachingForm());
                lecturingDTO.setNumberOfClasses(lecturing.getNumberOfClasses());
                lecturingDTO.setLecturer(lecturerDTO);
                lecturingDTOS.add(lecturingDTO);
            });
            founded.setLecturings(lecturingDTOS);

            this.saveTCPInJsonFileService.saveTCPToFile(founded);
            return founded;
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * Saves teaching coverage plan from given teachingCoveragePlanDTO
     * @param teachingCoveragePlanDTO - TeachingCoveragePlanDTO with info about teaching coverage plan
     * @return TeachingCoveragePlanDTO - saved teaching coverage plan
     * @throws ResponseStatusException if there is no year or moduleSubject with given id
     */
    @Override
    @Transactional
    public TeachingCoveragePlanDTO saveTeachingCoveragePlan(TeachingCoveragePlanDTO teachingCoveragePlanDTO) {
        try{
            Optional<Year> y = this.yearRepository.findById(teachingCoveragePlanDTO.getYear().getId());
            if(y.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no year with given id");
            }
            Year year = y.get();

            Optional<ModuleSubject> ms = this.moduleSubjectRepository.findById(teachingCoveragePlanDTO.getModuleSubject().getId());
            if(ms.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no module subject with given id");
            }
            ModuleSubject moduleSubject = ms.get();

            TeachingCoveragePlan tcp = new TeachingCoveragePlan();
            tcp.setYear(year);
            tcp.setModuleSubject(moduleSubject);
            TeachingCoveragePlan savedTCP = this.teachingCoveragePlanRepository.save(tcp);
            if(teachingCoveragePlanDTO.getLecturings()!=null){
                if(!teachingCoveragePlanDTO.getLecturings().isEmpty()){
                    teachingCoveragePlanDTO.getLecturings().forEach(lecturingDTO -> {
                        Lecturer lecturer = lecturerRepository.findById(lecturingDTO.getLecturer().getId()).orElseThrow();
                        Lecturing lecturing = new Lecturing();
                        lecturing.setTeachingCoveragePlan(savedTCP);
                        lecturing.setLecturer(lecturer);
                        lecturing.setTeachingForm(lecturingDTO.getTeachingForm());
                        lecturing.setNumberOfClasses(lecturingDTO.getNumberOfClasses());
                        this.lecturingRepository.save(lecturing);
                    });
                }
            }

            teachingCoveragePlanDTO.setId(savedTCP.getId());
            return teachingCoveragePlanDTO;
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Problem with saving teaching coverage plan!");
        }
    }

    /**
     * Deletes teaching coverage plan with given id
     * @param id - id of teaching coverage plan
     * @return TeachingCoveragePlanDTO of deleted teaching coverage plan
     * @throws ResponseStatusException if there is no saved teaching coverage plan with given id
     */
    @Override
    public TeachingCoveragePlanDTO deleteTeachingCoveragePlan(Long id) {
        try{
            Optional<TeachingCoveragePlan> foundTeachingCoveragePlanOptional = this.teachingCoveragePlanRepository.findById(id);
            if(foundTeachingCoveragePlanOptional.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Teaching coverage plan with given id does not exist!");
            }
            TeachingCoveragePlan tcp = foundTeachingCoveragePlanOptional.get();
            this.lecturingRepository.deleteAll(tcp.getLecturings());
            this.teachingCoveragePlanRepository.delete(tcp);
            return teachingCoveragePlanConverter.toDto(tcp);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    /**
     * Updates teaching coverage plan with info from given teachingCoveragePlanDTO
     * @param teachingCoveragePlanDTO - TeachingCoveragePlanDTO with info to be updated
     * @return TeachingCoveragePlanDTO of updated teaching coverage plan
     * @throws ResponseStatusException if there is no teaching coverage plan, year or moduleSubject with given id
     */
    @Override
    @Transactional
    public TeachingCoveragePlanDTO updateTeachingCoveragePlanDto(TeachingCoveragePlanDTO teachingCoveragePlanDTO) {
        try{
            Optional<TeachingCoveragePlan> ftcp = this.teachingCoveragePlanRepository.findById(teachingCoveragePlanDTO.getId());
            if(ftcp.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no teaching coverage plan with given id!");
            }
            TeachingCoveragePlan tcp = ftcp.get();
            Optional<Year> y = this.yearRepository.findById(teachingCoveragePlanDTO.getYear().getId());
            if(y.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no year with given id");
            }
            Year year = y.get();

            Optional<ModuleSubject> ms = this.moduleSubjectRepository.findById(teachingCoveragePlanDTO.getModuleSubject().getId());
            if(ms.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no module subject with given id");
            }
            ModuleSubject moduleSubject = ms.get();

            tcp.setYear(year);
            tcp.setModuleSubject(moduleSubject);
            TeachingCoveragePlan savedTCP = this.teachingCoveragePlanRepository.save(tcp);

            this.lecturingRepository.deleteAll(tcp.getLecturings());

            teachingCoveragePlanDTO.getLecturings().forEach(lecturingDTO -> {
                Lecturer lecturer = lecturerRepository.findById(lecturingDTO.getLecturer().getId()).orElseThrow();
                Lecturing lecturing = new Lecturing();
                lecturing.setTeachingCoveragePlan(savedTCP);
                lecturing.setLecturer(lecturer);
                lecturing.setTeachingForm(lecturingDTO.getTeachingForm());
                lecturing.setNumberOfClasses(lecturingDTO.getNumberOfClasses());
                this.lecturingRepository.save(lecturing);
            });
            teachingCoveragePlanDTO.setId(savedTCP.getId());
            return teachingCoveragePlanDTO;
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Problem with saving teaching coverage plan!");
        }
    }

    @Override
    public List<TeachingCoveragePlanDTO> findAllTCPs() {
        try{
            List<TeachingCoveragePlan> tcps = this.teachingCoveragePlanRepository.findAll();
            if(tcps.size() == 0){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no saved teaching coverage plans! ");
            }
            List<TeachingCoveragePlanDTO> tcpDTOs = new ArrayList<>();
            tcps.forEach(teachingCoveragePlan -> {
                TeachingCoveragePlanDTO tcpDTO = this.teachingCoveragePlanConverter.toDto(teachingCoveragePlan);
                tcpDTOs.add(tcpDTO);
            });

            return tcpDTOs;
        }catch (Exception e){
            throw e;
        }


    }

}
