package rs.ac.bg.fon.njt.ppnd.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import rs.ac.bg.fon.njt.ppnd.converter.ModuleConverter;
import rs.ac.bg.fon.njt.ppnd.converter.SubjectConverter;
import rs.ac.bg.fon.njt.ppnd.dto.DepartmentDTO;
import rs.ac.bg.fon.njt.ppnd.dto.ModuleDTO;
import rs.ac.bg.fon.njt.ppnd.dto.ModuleSubjectDTO;
import rs.ac.bg.fon.njt.ppnd.dto.SubjectDTO;
import rs.ac.bg.fon.njt.ppnd.model.Department;
import rs.ac.bg.fon.njt.ppnd.model.Module;
import rs.ac.bg.fon.njt.ppnd.model.ModuleSubject;
import rs.ac.bg.fon.njt.ppnd.model.Subject;
import rs.ac.bg.fon.njt.ppnd.repository.DepartmentRepository;
import rs.ac.bg.fon.njt.ppnd.repository.ModuleRepository;
import rs.ac.bg.fon.njt.ppnd.repository.ModuleSubjectRepository;
import rs.ac.bg.fon.njt.ppnd.repository.SubjectRepository;
import rs.ac.bg.fon.njt.ppnd.service.ModuleService;
import rs.ac.bg.fon.njt.ppnd.service.SubjectService;

import javax.transaction.Transactional;

@Service
public class SubjectServiceImpl implements SubjectService {


    private final SubjectRepository subjectRepository;

    private final SubjectConverter subjectConverter;

    private final ModuleRepository moduleRepository;

    private final ModuleSubjectRepository moduleSubjectRepository;

    private final ModuleService moduleService;

    private final ModuleConverter moduleConverter;

    private final DepartmentRepository departmentRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository, SubjectConverter subjectConverter, ModuleRepository moduleRepository, ModuleSubjectRepository moduleSubjectRepository, ModuleService moduleService, ModuleConverter moduleConverter, DepartmentRepository departmentRepository) {
        this.subjectRepository = subjectRepository;
        this.subjectConverter = subjectConverter;
        this.moduleRepository = moduleRepository;
        this.moduleSubjectRepository = moduleSubjectRepository;
        this.moduleService = moduleService;
        this.moduleConverter = moduleConverter;
        this.departmentRepository = departmentRepository;
    }

    @Override
    @Transactional
    public SubjectDTO saveSubject(SubjectDTO subjectDTO) {
        try {
            Subject s = new Subject();
            s.setName(subjectDTO.getName());
            s.setLecutresPerWeek(subjectDTO.getLecutresPerWeek());
            s.setExcerciesPerWeek(subjectDTO.getExercisesPerWeek());
            s.setLabExcercisesPerWeek(subjectDTO.getLabExercisesPerWeek());
            Optional<Department> d = this.departmentRepository.findById(subjectDTO.getDepartment().getId());
            if(d.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no department with given id");
            }
            Department department = d.get();
            s.setDepartment(department);
            Subject saved = this.subjectRepository.save(s);


            subjectDTO.getModuleSubjects().forEach(ms -> {
                Module m = moduleRepository.findById(ms.getModule().getId()).orElseThrow();
                ModuleSubject moduleSubject = new ModuleSubject();
                moduleSubject.setSubject(saved);
                moduleSubject.setModule(m);
                moduleSubject.setSubjectType(ms.getSubjectType());
                moduleSubject.setPosition(ms.getPosition());
                moduleSubject.setNumOfESPB(ms.getNumOfESPB());
                moduleSubject.setSemester(ms.getSemester());

                this.moduleSubjectRepository.save(moduleSubject);
            });

            return subjectDTO;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Problem with saving subject!");
        }
    }

    @Override
    public List<SubjectDTO> getAllSubjects() {
        try {
            List<Subject> subjects = this.subjectRepository.findAll();
            if (subjects.size() == 0) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No saved subjects!");
            }
            List<SubjectDTO> subjectDtos = new ArrayList<>();
            subjects.forEach((subject) -> {
                SubjectDTO dto = this.subjectConverter.toDto(subject);
                subjectDtos.add(dto);
            });
            return subjectDtos;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public SubjectDTO getById(Long id) {
        try {
            Optional<Subject> s = this.subjectRepository.findById(id);
            if (s.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No saved subject with given id!");
            }
            Subject subject = s.get();
            SubjectDTO subjectDTO = new SubjectDTO();
            subjectDTO.setId(subject.getId());
            subjectDTO.setName(subject.getName());
            subjectDTO.setLecutresPerWeek(subject.getLecutresPerWeek());
            subjectDTO.setExercisesPerWeek(subject.getExcerciesPerWeek());
            subjectDTO.setLabExercisesPerWeek(subject.getLabExcercisesPerWeek());

            DepartmentDTO departmentDTO = new DepartmentDTO();
            departmentDTO.setId(subject.getDepartment().getId());
            departmentDTO.setName(subject.getDepartment().getName());
            departmentDTO.setNumberOfMembers(subject.getDepartment().getNumberOfMembers());

            subjectDTO.setDepartment(departmentDTO);

            List<ModuleSubjectDTO> moduleSubjectDTOS = new ArrayList<>();
            subject.getModuleSubjects().forEach(moduleSubject -> {
                ModuleDTO moduleDTO = new ModuleDTO();
                moduleDTO.setId(moduleSubject.getModule().getId());
                moduleDTO.setName(moduleSubject.getModule().getName());

                ModuleSubjectDTO moduleSubjectDTO = new ModuleSubjectDTO();
                moduleSubjectDTO.setModule(moduleDTO);
                moduleSubjectDTO.setSubjectType(moduleSubject.getSubjectType());
                moduleSubjectDTO.setId(moduleSubject.getId());
                moduleSubjectDTO.setPosition(moduleSubject.getPosition());
                moduleSubjectDTO.setNumOfESPB(moduleSubject.getNumOfESPB());
                moduleSubjectDTO.setSemester(moduleSubject.getSemester());
                moduleSubjectDTOS.add(moduleSubjectDTO);
            });
             subjectDTO.setModuleSubjects(moduleSubjectDTOS);

            return subjectDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public SubjectDTO deleteSubject(Long id) {
        try {
            Optional<Subject> s = this.subjectRepository.findById(id);
            if (s.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No saved subject with given id!");
            }
            Subject subject = s.get();
            this.subjectRepository.delete(subject);
            SubjectDTO subjectDTO = new SubjectDTO();
            subjectDTO.setId(id);
            return subjectDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public SubjectDTO updateSubject(SubjectDTO subjectDTO) {
        try {
            Optional<Subject> subject = this.subjectRepository.findById(subjectDTO.getId());
            if (subject.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No saved subject with given id!");
            }
            Subject s = subject.get();
            s.setName(subjectDTO.getName());
            s.setLecutresPerWeek(subjectDTO.getLecutresPerWeek());
            s.setExcerciesPerWeek(subjectDTO.getExercisesPerWeek());
            s.setLabExcercisesPerWeek(subjectDTO.getLabExercisesPerWeek());
            Optional<Department> d = this.departmentRepository.findById(subjectDTO.getDepartment().getId());
            if(d.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no department with given id");
            }
            Department department = d.get();
            s.setDepartment(department);
            Subject saved = this.subjectRepository.save(s);


            subjectDTO.getModuleSubjects().forEach(ms -> {
                Module m = moduleRepository.findById(ms.getModule().getId()).orElseThrow();
                ModuleSubject moduleSubject = new ModuleSubject();
                moduleSubject.setSubject(saved);
                moduleSubject.setModule(m);
                moduleSubject.setSubjectType(ms.getSubjectType());
                moduleSubject.setPosition(ms.getPosition());
                moduleSubject.setNumOfESPB(ms.getNumOfESPB());
                moduleSubject.setSemester(ms.getSemester());

                this.moduleSubjectRepository.save(moduleSubject);
            });

            return subjectDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<SubjectDTO> getByModuleId(Long moduleId) {
        try {
            ModuleDTO module = this.moduleService.getById(moduleId);
            if (module == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Module with given id does not exist!");
            }

            Module m = this.moduleConverter.toEntity(module);
            ModuleSubject moduleSubject = new ModuleSubject();
            moduleSubject.setModule(m);

            List<Subject> subjects = this.subjectRepository.getAllByModuleSubjects(moduleSubject);
            List<SubjectDTO> subjectsDto = new ArrayList<>();
            subjects.forEach((subject) -> {
                SubjectDTO dto = this.subjectConverter.toDto(subject);
                subjectsDto.add(dto);
            });
            return subjectsDto;
        } catch (Exception e) {
            throw e;
        }
    }


}
