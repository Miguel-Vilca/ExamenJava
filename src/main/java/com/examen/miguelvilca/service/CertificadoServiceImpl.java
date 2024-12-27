package com.examen.miguelvilca.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.examen.miguelvilca.model.Certificado;
import com.examen.miguelvilca.repo.ICertificadoRepo;
import com.examen.miguelvilca.repo.IGenericRepo;

@Service
@RequiredArgsConstructor
public class CertificadoServiceImpl extends CRUDImpl<Certificado,Integer> implements ICertificadoService {

    private final ICertificadoRepo repo;

    @Override
    protected IGenericRepo<Certificado, Integer> getRepo() {
        return repo;
    }
}
