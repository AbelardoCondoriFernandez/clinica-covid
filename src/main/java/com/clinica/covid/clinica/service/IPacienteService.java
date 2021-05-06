package com.clinica.covid.clinica.service;

import com.clinica.covid.clinica.entity.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPacienteService {
    Paciente registrarPaciente(Paciente paciente);
    void modificarPaciente(Paciente paciente);
    void eliminarPaciente(int idPaciente);
    Paciente listarByIdPaciente(int idPaciente);
    List<Paciente> listarPaciente();
    Page<Paciente> listAllByPagePaciente(Pageable pageable);
}
