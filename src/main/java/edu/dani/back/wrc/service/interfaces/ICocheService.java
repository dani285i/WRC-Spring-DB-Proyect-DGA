package edu.dani.back.wrc.service.interfaces;

import edu.dani.back.wrc.model.Coche;

import java.util.List;
import java.util.Optional;

public interface ICocheService {

    Coche guardar(Coche coche);

    List<Coche> listarTodos();
    Optional<Coche> buscarPorId(Long id);

    Coche actualizar(Coche coche);

    void eliminar(Long id);
}
