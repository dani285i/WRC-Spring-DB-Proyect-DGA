package edu.dani.back.wrc.service.interfaces;

import java.util.List;
import java.util.Optional;

import edu.dani.back.wrc.model.Rally;

public interface IRallyService {

    Rally guardar(Rally rally);

    List<Rally> listarTodos();
    Optional<Rally> buscarPorId(Long id);

    Rally actualizar(Rally rally);

    void eliminar(Long id);
}