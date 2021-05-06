package com.clinica.covid.clinica.controller;

import com.clinica.covid.clinica.entity.Paciente;
import com.clinica.covid.clinica.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    private final IPacienteService iPacienteService;

    public PacienteController(IPacienteService iPacienteService) {
        this.iPacienteService = iPacienteService;
    }

    @GetMapping(value="/listar",produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Paciente>> listar(){
        List<Paciente>pacientes=new ArrayList<>();
        try {
            pacientes=iPacienteService.listarPaciente();
        } catch (Exception e) {
            return new ResponseEntity<List<Paciente>>(pacientes, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Paciente>>(pacientes, HttpStatus.OK);
    }
    @GetMapping(value = "/listarPageable", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Paciente>> listarByPageable(Pageable pageable) {
        Page<Paciente> pacientes= null;
        try {
            pacientes = iPacienteService.listAllByPagePaciente(pageable);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<Page<Paciente>>(pacientes, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Page<Paciente>>(pacientes, HttpStatus.OK);
    }
    @GetMapping(value="/listar/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Paciente>listarId(@PathVariable("id") Integer id){
        Paciente paciente=new Paciente();
        try {
            paciente=iPacienteService.listarByIdPaciente(id);
        } catch (Exception e) {
            return new ResponseEntity<Paciente>(paciente,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Paciente>(paciente, HttpStatus.OK);
    }
    @PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Paciente> registrar(@RequestBody Paciente paciente) {
        Paciente pacientes = new Paciente();
        try {
            pacientes = iPacienteService.registrarPaciente(paciente);
        } catch (Exception e) {

            // si hay error en la base de datos, el error cae en el catch
            return new ResponseEntity<Paciente>(pacientes, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Paciente>(pacientes, HttpStatus.OK);

    }
    //Se actualizara el paciente
    @PutMapping(value="/actualizar", consumes=MediaType.APPLICATION_JSON_VALUE ,produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> actualizar(@RequestBody Paciente paciente){

        int resultado=0;
        try {
            iPacienteService.modificarPaciente(paciente);
            resultado=1;
        }
        catch (Exception e) {
            resultado=0;
        }

        return new ResponseEntity<Integer>(resultado,HttpStatus.OK);

    }
    //entidad que eliminara por la su ID
    @DeleteMapping(value="/eliminar/{id}" ,produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> eliminar(@PathVariable Integer id){

        int resultado=0;
        try {
            iPacienteService.eliminarPaciente(id);
            resultado=1;
        }
        catch (Exception e) {
            resultado=0;
        }

        return new ResponseEntity<Integer>(resultado,HttpStatus.OK);

    }
}
