package com.clinica.covid.clinica.repository;

import com.clinica.covid.clinica.entity.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEspecialidadRepository extends JpaRepository<Especialidad, Integer> {
}
