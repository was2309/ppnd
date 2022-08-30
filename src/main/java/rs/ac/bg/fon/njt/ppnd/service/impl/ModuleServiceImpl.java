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

	//TODO: javadoc
	@Autowired
	ModuleRepository moduleRepository;
	//TODO: javadoc
	@Autowired
	ModuleConverter moduleConverter;

	/**
	 * Returns module founded by module id (if recorded)
	 * @param id - id of the module
	 * @return ModuleDTO - dto of the founded module
	 * @throws ResponseStatusException - if there is no saved module with given id
	 */
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

	/**
	 * Returns all saved modules
	 * @return List of ModuleDTOs which are founded
	 * @throws ResponseStatusException - if there are no saved modules at all
	 */
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

	/**
	 * Deletes module with given id
	 * @param id - id of the module
	 * @return ModuleDTO - dto of deleted module
	 * @throws ResponseStatusException - if there is no module with given id
	 */
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

	/**
	 * Updates given module (This method is not implemented)
	 * @param module - ModuleDTO for module to be updated
	 * @return null
	 */
	@Override
	public ModuleDTO updateModule(ModuleDTO module) {
		// TODO Auto-generated method stub
		return null;
	}

}
