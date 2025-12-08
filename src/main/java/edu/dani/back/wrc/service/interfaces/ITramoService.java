package edu.dani.back.wrc.service.interfaces;

import edu.dani.back.wrc.model.Tramo;

import java.util.List;
import java.util.Optional;

public interface ITramoService {

    Tramo guardar(Tramo tramo);

    List<Tramo> listarTodos();
    Optional<Tramo> buscarPorId(Long id);

    Tramo actualizar(Tramo tramo);

    void eliminar(Long id);
}