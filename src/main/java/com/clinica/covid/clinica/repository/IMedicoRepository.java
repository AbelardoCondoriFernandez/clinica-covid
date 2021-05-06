package com.clinica.covid.clinica.repository;

import com.clinica.covid.clinica.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicoRepository extends JpaRepository<Medico,Integer> {
}
