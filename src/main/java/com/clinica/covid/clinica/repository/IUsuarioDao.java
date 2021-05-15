package com.clinica.covid.clinica.repository;

import com.clinica.covid.clinica.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioDao extends JpaRepository<Usuario, Long> {
	//obtiene informacion del usuario en base a su nombre
	Usuario findOneByUsername(String username);

}
