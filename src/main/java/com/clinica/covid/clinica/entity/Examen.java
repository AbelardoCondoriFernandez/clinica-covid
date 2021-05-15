package com.clinica.covid.clinica.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="examen")
@Getter@Setter
public class Examen {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idExamen;
	@Column(name="nombre",nullable=false,length=50)
	private String nombre;
	@Column(name="descripcion",nullable=false,length=150)
	private String descripcion;

}
