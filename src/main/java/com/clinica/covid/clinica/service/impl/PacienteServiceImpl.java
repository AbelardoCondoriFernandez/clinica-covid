package com.clinica.covid.clinica.service.impl;

import com.clinica.covid.clinica.entity.Paciente;
import com.clinica.covid.clinica.repository.IPacienteRepository;
import com.clinica.covid.clinica.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PacienteServiceImpl implements IPacienteService {
    private final IPacienteRepository repository;

    public PacienteServiceImpl(IPacienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Paciente registrarPaciente(Paciente paciente) {
       return repository.save(paciente);
    }

    @Override
    public void modificarPaciente(Paciente paciente) {
         repository.save(paciente);
    }

    @Override
    public void eliminarPaciente(int idPaciente) {
        repository.deleteById(idPaciente);
    }

    @Override
    public Paciente listarByIdPaciente(int idPaciente) {
        return repository.findById(idPaciente).orElse(null);
    }

    @Override
    public List<Paciente> listarPaciente() {
        return repository.findAll();
    }

    @Override
    public Page<Paciente> listAllByPagePaciente(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
