package com.clinica.covid.clinica.repository;

import com.clinica.covid.clinica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository <Paciente,Integer> {
}
