package com.clinica.covid.clinica.service.impl;

import com.clinica.covid.clinica.repository.IUsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//apodo, sirve para la inyeccion de dependencias
@Service("userDetailsService")
public class UserServiceImpl implements UserDetailsService{

	@Autowired
	private IUsuarioDao userdao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return userdao.findOneByUsername(username);
	}
	
	
}
