package edu.dani.back.wrc.service.interfaces;

import java.util.List;
import java.util.Optional;

import edu.dani.back.wrc.model.Piloto;

public interface IPilotoService {

    Piloto guardar(Piloto piloto);

    List<Piloto> listarTodos();
    Optional<Piloto> buscarPorId(Long id);

    Piloto actualizar(Piloto piloto);

    void eliminar(Long id);
}