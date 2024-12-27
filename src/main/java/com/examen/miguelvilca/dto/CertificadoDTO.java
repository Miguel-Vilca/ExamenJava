package com.examen.miguelvilca.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CertificadoDTO {

    private Integer idCertificado;

    @NotNull
    @Size(min = 1, max = 200)
    private String descripcion;

    @NotNull
    @Size(min = 1, max = 200)
    private String institucion;

    @NotNull
    private Integer anio ;

    @NotNull
    private boolean estado;
}
