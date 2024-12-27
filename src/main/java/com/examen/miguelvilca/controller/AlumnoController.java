package com.examen.miguelvilca.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.examen.miguelvilca.dto.AlumnoDTO;
import com.examen.miguelvilca.dto.GenericResponse;
import com.examen.miguelvilca.model.Alumno;
import com.examen.miguelvilca.service.IAlumnoService;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/alumnos")
@RequiredArgsConstructor
public class AlumnoController {
    private final IAlumnoService service;
    @Qualifier("alumnoMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<GenericResponse<AlumnoDTO>> getallAlumnos(){
        List<AlumnoDTO> list = service.findAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(new GenericResponse<>(200,"success",list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<AlumnoDTO>> getAlumnoById(@PathVariable("id") int id){
        Alumno obj = service.findById(id);
        return ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(convertToDto(obj))) );
    }

    @PostMapping
    public ResponseEntity<Void>  save(@Valid @RequestBody AlumnoDTO dto){
        Alumno obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdAlumno()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<AlumnoDTO>> update(@PathVariable("id") Integer id, @Valid @RequestBody AlumnoDTO dto){
        Alumno obj = service.update(id, convertToEntity(dto));
        return  ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(convertToDto(obj))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private AlumnoDTO convertToDto(Alumno obj) {
        return modelMapper.map(obj, AlumnoDTO.class);
    }

    private Alumno convertToEntity(AlumnoDTO dto) {
        return modelMapper.map(dto, Alumno.class);
    }
}
