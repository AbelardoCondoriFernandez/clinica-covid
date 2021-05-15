package com.clinica.covid.clinica.service;

import com.clinica.covid.clinica.entity.Examen;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IExamenService {
	int registrar(Examen examen);
	int modificar(Examen examen);
	void eliminar(int idExamen);
	Examen listarId(int idExamen);
	List<Examen>listar();
	Page<Examen> listAllByPage(Pageable pageable);

}
