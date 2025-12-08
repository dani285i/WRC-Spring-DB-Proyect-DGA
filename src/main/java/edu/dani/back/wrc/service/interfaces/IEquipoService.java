package edu.dani.back.wrc.service.interfaces;

import edu.dani.back.wrc.model.Equipo;

import java.util.List;
import java.util.Optional;

public interface IEquipoService {

    Equipo guardar(Equipo equipo);

    List<Equipo> listarTodos();
    Optional<Equipo> buscarPorId(Long id);

    Equipo actualizar(Equipo equipo);

    void eliminar(Long id);
}