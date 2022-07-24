package rs.ac.bg.fon.njt.ppnd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.bg.fon.njt.ppnd.converter.ModuleSubjectConverter;
import rs.ac.bg.fon.njt.ppnd.converter.TeachingCoveragePlanConverter;
import rs.ac.bg.fon.njt.ppnd.converter.YearConverter;
import rs.ac.bg.fon.njt.ppnd.dto.ModuleSubjectDTO;
import rs.ac.bg.fon.njt.ppnd.dto.TeachingCoveragePlanDTO;
import rs.ac.bg.fon.njt.ppnd.dto.YearDTO;
import rs.ac.bg.fon.njt.ppnd.model.TeachingCoveragePlan;
import rs.ac.bg.fon.njt.ppnd.repository.TeachingCoveragePlanRepository;
import rs.ac.bg.fon.njt.ppnd.service.TeachingCoveragePlanService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class TeachingCoveragePlanServiceImpl implements TeachingCoveragePlanService {

    @Autowired
     TeachingCoveragePlanRepository teachingCoveragePlanRepository;
    @Autowired
     TeachingCoveragePlanConverter teachingCoveragePlanConverter;
    @Autowired
    YearConverter yearConverter;
    @Autowired
    ModuleSubjectConverter moduleSubjectConverter;

    public TeachingCoveragePlanServiceImpl(TeachingCoveragePlanRepository teachingCoveragePlanRepository, TeachingCoveragePlanConverter teachingCoveragePlanConverter, YearConverter yearConverter, ModuleSubjectConverter moduleSubjectConverter) {
        this.teachingCoveragePlanRepository = teachingCoveragePlanRepository;
        this.teachingCoveragePlanConverter = teachingCoveragePlanConverter;
        this.yearConverter = yearConverter;
        this.moduleSubjectConverter = moduleSubjectConverter;
    }

    @Override
    public List<TeachingCoveragePlanDTO> getAllByYear(YearDTO yearDTO) {
        try{
            List<TeachingCoveragePlan> tcps = this.teachingCoveragePlanRepository.findAllByYear(yearConverter.toEntity(yearDTO));
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

    @Override
    public List<TeachingCoveragePlanDTO> getAllByModuleSubject(ModuleSubjectDTO moduleSubjectDTO) {
        try{
            List<TeachingCoveragePlan> tcps = this.teachingCoveragePlanRepository.findAllByModuleSubject(moduleSubjectConverter.toEntity(moduleSubjectDTO));
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

    @Override
    public TeachingCoveragePlanDTO findById(Long id) {
        try{
            Optional<TeachingCoveragePlan> tcp = this.teachingCoveragePlanRepository.findById(id);
            if(tcp.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No saved teaching coverage plan with given id!");
            }
            return this.teachingCoveragePlanConverter.toDto(tcp.get());
        }catch (Exception e){
            throw e;
        }
    }

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
