package com.clinica.covid.clinica.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "paciente")
@Getter@Setter
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPaciente;
    @Column(name = "nombres",nullable = false,length = 100)
    private String nombres;
    @Column(name = "apellidos",nullable = false,length = 100)
    private String apellidos;
    @Column(name = "dni",nullable = false,length = 8)
    private String dni;
    @Column(name = "direccion",nullable = false,length = 100)
    private String direccion;
    @Column(name = "email",nullable = false,length = 100)
    private String email;
    @Column(name = "telefono",nullable = false,length = 9)
    private String telefono;
    @JsonSerialize(using= ToStringSerializer.class)
    private Date fechadenacimiento;
}
