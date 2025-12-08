package edu.dani.back.wrc.service.interfaces;

import edu.dani.back.wrc.model.Inscripcion;

import java.util.List;
import java.util.Optional;

public interface IInscripcionService {

    Inscripcion guardar(Inscripcion inscripcion);

    List<Inscripcion> listarTodos();
    Optional<Inscripcion> buscarPorId(Long id);

    Inscripcion actualizar(Inscripcion inscripcion);

    void eliminar(Long id);
}