package com.clinica.covid.clinica.service.impl;

import com.clinica.covid.clinica.entity.Medico;
import com.clinica.covid.clinica.entity.Paciente;
import com.clinica.covid.clinica.repository.IMedicoRepository;
import com.clinica.covid.clinica.service.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoServiceImpl implements IMedicoService {
    private final IMedicoRepository iMedicoRepository;

    public MedicoServiceImpl(IMedicoRepository iMedicoRepository) {
        this.iMedicoRepository = iMedicoRepository;
    }

    @Override
    public Medico registrarMedico(Medico medico) {
        return iMedicoRepository.save(medico);
    }

    @Override
    public void modificarMedico(Medico medico) {
        iMedicoRepository.save(medico);
    }

    @Override
    public void eliminarMedico(int idMedico) {
        iMedicoRepository.deleteById(idMedico);
    }

    @Override
    public Medico listarByIdMedico(int idMedico) {
        return iMedicoRepository.findById(idMedico).orElse(null);
    }

    @Override
    public List<Medico> listarMedico() {
        return iMedicoRepository.findAll();
    }

    @Override
    public Page<Medico> listAllByPageMedico(Pageable pageable) {
        return iMedicoRepository.findAll(pageable);
    }
}
