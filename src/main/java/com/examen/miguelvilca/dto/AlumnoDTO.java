package com.examen.miguelvilca.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlumnoDTO {

    private Integer idAlumno;
    @NotNull
    @Size(min = 1, max = 50)
    private String nombresAlumno;
    @NotNull
    @Size(min = 1, max = 50)
    private String apellidosAlumno;
    @NotNull
    @Size(min = 1, max = 8)
    private String dni;
    @NotNull
    private Integer edad;
}
