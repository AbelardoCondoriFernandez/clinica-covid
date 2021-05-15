package com.clinica.covid.clinica.repository;

import com.clinica.covid.clinica.entity.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExamenRepository extends JpaRepository<Examen,Integer> {
}
