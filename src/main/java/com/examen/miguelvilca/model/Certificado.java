package com.examen.miguelvilca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Certificado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCertificado;
    @Column(nullable = false, length = 200)
    private String descripcion;
    @Column(nullable = false, length = 200)
    private String institucion;

    @Column(nullable = false)
    private Integer anio;

    @Column(nullable = false)
    private boolean estado;
}
