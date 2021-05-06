package com.clinica.covid.clinica.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "medico")
@Getter@Setter
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMedico;
    @Column(name = "nombres",nullable = false,length = 100)
    private String nombres;
    @Column(name = "apellidos",nullable = false,length = 100)
    private String apellidos;
    @Column(name = "dni",nullable = false,length = 8,unique = true)
    private String dni;
    @Column(name = "direccion",nullable = false,length = 100)
    private String direccion;
    @Column(name = "cmp",nullable = false,length = 8,unique = true)
    private String cmp;
    @Column(name = "email",nullable = false,length = 100)
    private String email;
    @Column(name = "telefono",nullable = false,length = 9,unique = true)
    private String telefono;
    @Column(name = "fechadenacimiento",nullable = false,length = 100)
    private Date fechadenacimiento;
    @JsonSerialize(using= ToStringSerializer.class)
    private LocalDateTime fechadeingreso;
    @Column(name = "estado",nullable = false,length = 100)
    private String estado;
}
