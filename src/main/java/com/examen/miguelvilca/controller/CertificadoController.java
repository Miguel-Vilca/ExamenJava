package com.examen.miguelvilca.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.examen.miguelvilca.dto.CertificadoDTO;
import com.examen.miguelvilca.dto.GenericResponse;
import com.examen.miguelvilca.model.Certificado;
import com.examen.miguelvilca.service.ICertificadoService;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/certificados")
@RequiredArgsConstructor
public class CertificadoController {
    private final ICertificadoService service;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<GenericResponse<CertificadoDTO>> getallCursos(){
        List<CertificadoDTO> list = service.findAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(new GenericResponse<>(200,"success",list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<CertificadoDTO>> getCursoById(@PathVariable("id") int id){
        Certificado obj = service.findById(id);
        return ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(convertToDto(obj))) );
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody CertificadoDTO dto){
        Certificado obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCertificado()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<CertificadoDTO>> update(@PathVariable("id") Integer id, @Valid @RequestBody CertificadoDTO dto){
        Certificado obj = service.update(id, convertToEntity(dto));
        return  ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(convertToDto(obj))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private CertificadoDTO convertToDto(Certificado obj) {
        return modelMapper.map(obj, CertificadoDTO.class);
    }

    private Certificado convertToEntity(CertificadoDTO dto) {
        return modelMapper.map(dto, Certificado.class);
    }
}
