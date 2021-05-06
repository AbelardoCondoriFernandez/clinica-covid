package com.clinica.covid.clinica.service;

import com.clinica.covid.clinica.entity.Medico;
import com.clinica.covid.clinica.entity.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMedicoService {
    Medico registrarMedico(Medico medico);
    void modificarMedico(Medico medico);
    void eliminarMedico(int idMedico);
    Medico listarByIdMedico(int idMedico);
    List<Medico> listarMedico();
    Page<Medico> listAllByPageMedico(Pageable pageable);
}
