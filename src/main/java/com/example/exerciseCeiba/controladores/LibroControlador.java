package com.example.exerciseCeiba.controladores;

import com.example.exerciseCeiba.dto.LibroDto;
import com.example.exerciseCeiba.entidades.Libro;
import com.example.exerciseCeiba.servicios.LibroServicio;
import com.example.exerciseCeiba.servicios.LibroServicioImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LibroControlador {

    private final LibroServicio libroServicio;

    public LibroControlador(LibroServicio libroServicio) {
        this.libroServicio = libroServicio;
    }

    @CrossOrigin
    @PostMapping("/libro")
    @ResponseStatus(HttpStatus.CREATED)
    public LibroDto crearLibro(@RequestBody LibroDto libroDto){
        return libroServicio.agregarLibro(libroDto);
    }

    @CrossOrigin
    @DeleteMapping("/libro")
    @ResponseStatus(HttpStatus.OK)
    public void borrarLibro(String isbn){
        libroServicio.borrarLibro(isbn);
    }
}