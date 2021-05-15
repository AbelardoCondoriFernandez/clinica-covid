package com.clinica.covid.clinica.service;

import com.clinica.covid.clinica.entity.Especialidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IEspecialidadService {
	int registrar(Especialidad especialidad);
	int modificar(Especialidad especialidad);
	void eliminar(int idEspecialidad);
	Especialidad listarId(int idEspecialidad);
	List<Especialidad>listar();
	Page<Especialidad> listAllByPage(Pageable pageable);

}
