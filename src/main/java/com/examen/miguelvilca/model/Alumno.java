package com.examen.miguelvilca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAlumno;

    @Column(nullable = false, length = 50)
    private String nombresAlumno;

    @Column(nullable = false, length = 50)
    private String apellidosAlumno;

    @Column(nullable = false, length = 8)
    private String dni;

    @Column(nullable = false)
    private Integer edad;
}
