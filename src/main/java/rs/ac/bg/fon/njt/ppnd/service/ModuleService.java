package rs.ac.bg.fon.njt.ppnd.service;

import java.util.List;

import rs.ac.bg.fon.njt.ppnd.dto.ModuleDTO;

public interface ModuleService {

	public ModuleDTO getById(Long id);
	public List<ModuleDTO> getAllModules();
	public ModuleDTO deleteModule(Long id);
	public ModuleDTO updateModule(ModuleDTO module);
}
