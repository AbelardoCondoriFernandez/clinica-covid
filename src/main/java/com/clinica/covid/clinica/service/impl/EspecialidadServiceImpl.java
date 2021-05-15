package com.clinica.covid.clinica.service.impl;

import com.clinica.covid.clinica.entity.Especialidad;
import com.clinica.covid.clinica.repository.IEspecialidadRepository;
import com.clinica.covid.clinica.service.IEspecialidadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EspecialidadServiceImpl implements IEspecialidadService {

	private final IEspecialidadRepository iEspecialidadRepository;

	public EspecialidadServiceImpl(IEspecialidadRepository iEspecialidadRepository) {
		this.iEspecialidadRepository = iEspecialidadRepository;
	}

	@Override
	public int registrar(Especialidad especialidad) {
		int rpta = 0;
		rpta = iEspecialidadRepository.save(especialidad) != null ? especialidad.getIdEspecialidad() : 0;
		return rpta > 0 ? 1 : 0;
	}

	@Override
	public int modificar(Especialidad especialidad) {
		int rpta = 0;
		rpta = iEspecialidadRepository.save(especialidad) != null ? especialidad.getIdEspecialidad() : 0;
		return rpta > 0 ? 1 : 0;
	}

	@Override
	public void eliminar(int idEspecialidad) {

		iEspecialidadRepository.deleteById(idEspecialidad);
	}

	@Override
	public Especialidad listarId(int idEspecialidad) {
		return iEspecialidadRepository.findById(idEspecialidad).orElse(null);
	}

	@Override
	public List<Especialidad> listar() {
		return iEspecialidadRepository.findAll();
	}
	@Override
	public Page<Especialidad> listAllByPage(Pageable pageable) {

		return iEspecialidadRepository.findAll(pageable);
	}
}
