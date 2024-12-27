package com.examen.miguelvilca.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.examen.miguelvilca.dto.AlumnoDTO;
import com.examen.miguelvilca.model.Alumno;

@Configuration
public class MapperConfig {

    @Bean(name = "defaultMapper")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean(name = "alumnoMapper")
    public ModelMapper alumnoMapper() {
        ModelMapper mapper = new ModelMapper();

        //Escritura POST PUT
        mapper.createTypeMap(AlumnoDTO.class, Alumno.class)
                .addMapping(AlumnoDTO::getNombresAlumno, (dest, v) -> dest.setNombresAlumno((String) v))
                .addMapping(AlumnoDTO::getApellidosAlumno, (dest, v) -> dest.setApellidosAlumno((String) v));

        //Lectura GET
        mapper.createTypeMap(Alumno.class, AlumnoDTO.class)
                .addMapping(Alumno::getNombresAlumno, (dest, v) -> dest.setNombresAlumno((String) v))
                .addMapping(Alumno::getApellidosAlumno, (dest, v) -> dest.setApellidosAlumno((String) v));

        return mapper;
    }

}
