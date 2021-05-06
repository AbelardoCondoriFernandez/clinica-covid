package com.clinica.covid.clinica.controller;

import com.clinica.covid.clinica.entity.Medico;
import com.clinica.covid.clinica.service.IMedicoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {
    private final IMedicoService iMedicoService;

    public MedicoController(IMedicoService iMedicoService) {
        this.iMedicoService = iMedicoService;
    }
    @GetMapping(value="/listar",produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Medico>> listar(){
        List<Medico>medico=new ArrayList<>();
        try {
            medico=iMedicoService.listarMedico();
        } catch (Exception e) {
            return new ResponseEntity<List<Medico>>(medico, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Medico>>(medico, HttpStatus.OK);
    }
    @GetMapping(value = "/listarPageable", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Medico>> listarByPageable(Pageable pageable) {
        Page<Medico> medico= null;
        try {
            medico = iMedicoService.listAllByPageMedico(pageable);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<Page<Medico>>(medico, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Page<Medico>>(medico, HttpStatus.OK);
    }
    @GetMapping(value="/listar/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Medico>listarId(@PathVariable("id") Integer id){
        Medico medico=new Medico();
        try {
            medico=iMedicoService.listarByIdMedico(id);
        } catch (Exception e) {
            return new ResponseEntity<Medico>(medico,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Medico>(medico, HttpStatus.OK);
    }
    @PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Medico> registrar(@RequestBody Medico medico) {
        Medico medicos = new Medico();
        try {
            medicos = iMedicoService.registrarMedico(medico);
        } catch (Exception e) {

            // si hay error en la base de datos, el error cae en el catch
            return new ResponseEntity<Medico>(medicos, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Medico>(medicos, HttpStatus.OK);

    }
    //Se actualizara el paciente
    @PutMapping(value="/actualizar", consumes=MediaType.APPLICATION_JSON_VALUE ,produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> actualizar(@RequestBody Medico medico){

        int resultado=0;
        try {
            iMedicoService.modificarMedico(medico);
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
            iMedicoService.eliminarMedico(id);
            resultado=1;
        }
        catch (Exception e) {
            resultado=0;
        }

        return new ResponseEntity<Integer>(resultado,HttpStatus.OK);

    }
}
