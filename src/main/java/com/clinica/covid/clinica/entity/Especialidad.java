package com.clinica.covid.clinica.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="especialidad")
@Getter@Setter
public class Especialidad {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idEspecialidad;
	@Column(name="nombre",nullable=false,length=50)
	private String nombre;
	@Column(name="descripcion",nullable=false,length=50)
	private String descripcion;
}
