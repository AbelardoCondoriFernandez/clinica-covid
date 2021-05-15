package com.clinica.covid.clinica.service.impl;

import com.clinica.covid.clinica.entity.Examen;
import com.clinica.covid.clinica.repository.IExamenRepository;
import com.clinica.covid.clinica.service.IExamenService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamenServiceImpl implements IExamenService {

	private final IExamenRepository iExamenRepository;

	public ExamenServiceImpl(IExamenRepository iExamenRepository) {
		this.iExamenRepository = iExamenRepository;
	}


	@Override
	public int registrar(Examen examen) {
		int rpta = 0;
		rpta = iExamenRepository.save(examen) != null ? examen.getIdExamen() : 0;
		return rpta > 0 ? 1 : 0;
	}

	@Override
	public int modificar(Examen examen) {
		int rpta = 0;
		rpta = iExamenRepository.save(examen) != null ? examen.getIdExamen() : 0;
		return rpta > 0 ? 1 : 0;
	}

	@Override
	public void eliminar(int idExamen) {

		iExamenRepository.deleteById(idExamen);
	}

	@Override
	public Examen listarId(int idExamen) {
		return iExamenRepository.findById(idExamen).orElse(null);
	}

	@Override
	public List<Examen> listar() {
		return iExamenRepository.findAll();
	}
	@Override
	public Page<Examen> listAllByPage(Pageable pageable) {

		return iExamenRepository.findAll(pageable);
	}
}
