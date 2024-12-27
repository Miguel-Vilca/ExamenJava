package com.examen.miguelvilca.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.examen.miguelvilca.model.Alumno;
import com.examen.miguelvilca.repo.IAlumnoRepo;
import com.examen.miguelvilca.repo.IGenericRepo;

@Service
@RequiredArgsConstructor
public class AlumnoServiceImpl extends CRUDImpl<Alumno,Integer> implements IAlumnoService {
    private final IAlumnoRepo repo;

    @Override
    protected IGenericRepo<Alumno, Integer> getRepo() {
        return repo;
    }
}
