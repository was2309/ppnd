package rs.ac.bg.fon.njt.ppnd.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import rs.ac.bg.fon.njt.ppnd.converter.ModuleConverter;
import rs.ac.bg.fon.njt.ppnd.dto.ModuleDTO;
import rs.ac.bg.fon.njt.ppnd.model.Module;
import rs.ac.bg.fon.njt.ppnd.repository.ModuleRepository;
import rs.ac.bg.fon.njt.ppnd.service.ModuleService;
@Service
public class ModuleServiceImpl implements ModuleService {

	
	@Autowired
	ModuleRepository moduleRepository;
	
	@Autowired
	ModuleConverter moduleConverter;
	
	@Override
	public ModuleDTO getById(Long id) {
	try {
		Optional<Module> module=this.moduleRepository.findById(id);
		if(module.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Module with given id does not exist!");
		}
		Module foundedModule = module.get();
		return this.moduleConverter.toDto(foundedModule);
	} catch (Exception e) {
		throw e;
	}
	}

	@Override
	public List<ModuleDTO> getAllModules() {
		try {
			List<Module>modules=this.moduleRepository.findAll();
			if(modules.size()==0) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No saved modules!");
			}
			List<ModuleDTO>moduleDtos=new ArrayList<>();
			modules.forEach((module)->{
				ModuleDTO dto=this.moduleConverter.toDto(module);
				moduleDtos.add(dto);
			});
			return moduleDtos;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public ModuleDTO deleteModule(Long id) {
		try {
			Optional<Module> module=this.moduleRepository.findById(id);
			if(module.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Module with given id does not exist!");
			}
			Module foundedModule = module.get();
			this.moduleRepository.delete(foundedModule);
			return this.moduleConverter.toDto(foundedModule);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public ModuleDTO updateModule(ModuleDTO module) {
		// TODO Auto-generated method stub
		return null;
	}

}
