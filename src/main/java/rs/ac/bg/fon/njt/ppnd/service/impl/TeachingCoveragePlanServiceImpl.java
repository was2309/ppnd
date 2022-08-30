package rs.ac.bg.fon.njt.ppnd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.bg.fon.njt.ppnd.converter.ModuleSubjectConverter;
import rs.ac.bg.fon.njt.ppnd.converter.TeachingCoveragePlanConverter;
import rs.ac.bg.fon.njt.ppnd.converter.YearConverter;
import rs.ac.bg.fon.njt.ppnd.dto.ModuleSubjectDTO;
import rs.ac.bg.fon.njt.ppnd.dto.TeachingCoveragePlanDTO;
import rs.ac.bg.fon.njt.ppnd.dto.YearDTO;
import rs.ac.bg.fon.njt.ppnd.model.ModuleSubject;
import rs.ac.bg.fon.njt.ppnd.model.TeachingCoveragePlan;
import rs.ac.bg.fon.njt.ppnd.model.Year;
import rs.ac.bg.fon.njt.ppnd.repository.TeachingCoveragePlanRepository;
import rs.ac.bg.fon.njt.ppnd.service.TeachingCoveragePlanService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeachingCoveragePlanServiceImpl implements TeachingCoveragePlanService {

    private final TeachingCoveragePlanRepository teachingCoveragePlanRepository;
    private final TeachingCoveragePlanConverter teachingCoveragePlanConverter;
    private final YearConverter yearConverter;
    private final ModuleSubjectConverter moduleSubjectConverter;
    private final SaveTCPInJsonFileServiceImpl saveTCPInJsonFileService;

    @Autowired
    public TeachingCoveragePlanServiceImpl(TeachingCoveragePlanConverter teachingCoveragePlanConverter, YearConverter yearConverter, ModuleSubjectConverter moduleSubjectConverter, SaveTCPInJsonFileServiceImpl saveTCPInJsonFileService, TeachingCoveragePlanRepository teachingCoveragePlanRepository) {
        this.teachingCoveragePlanConverter = teachingCoveragePlanConverter;
        this.yearConverter = yearConverter;
        this.moduleSubjectConverter = moduleSubjectConverter;
        this.saveTCPInJsonFileService = saveTCPInJsonFileService;
        this.teachingCoveragePlanRepository = teachingCoveragePlanRepository;
    }

    /**
     * Returns all teaching covering plans for specific yearId
     * @param yearId - id of the year
     * @return List of TeachingCoveragePlanDTO
     * @throws ResponseStatusException if there is no saved teaching covering plans for specific yearId
     */
    @Override
    public List<TeachingCoveragePlanDTO> getAllByYear(Long yearId) {
        try{
            Year year = new Year();
            year.setId(yearId);
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
     * @throws ResponseStatusException if there is no saved teaching covering plans for specific moduleSubjectId
     */
    @Override
    public List<TeachingCoveragePlanDTO> getAllByModuleSubject(Long moduleSubjectId) {
        try{
            ModuleSubject moduleSubject = new ModuleSubject();
            moduleSubject.setId(moduleSubjectId);
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
            TeachingCoveragePlanDTO founded = this.teachingCoveragePlanConverter.toDto(tcp.get());
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
    public TeachingCoveragePlanDTO saveTeachingCoveragePlan(TeachingCoveragePlanDTO teachingCoveragePlanDTO) {
        try{
            TeachingCoveragePlan tcp = this.teachingCoveragePlanConverter.toEntity(teachingCoveragePlanDTO);
            TeachingCoveragePlan savedTCP = this.teachingCoveragePlanRepository.save(tcp);
            return this.teachingCoveragePlanConverter.toDto(savedTCP);
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
            Optional<TeachingCoveragePlan> foundTeachingCoveragePlan = this.teachingCoveragePlanRepository.findById(id);
            if(foundTeachingCoveragePlan.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Teaching coverage plan with given id does not exist!");
            }
            this.teachingCoveragePlanRepository.delete(foundTeachingCoveragePlan.get());
            return teachingCoveragePlanConverter.toDto(foundTeachingCoveragePlan.get());
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
