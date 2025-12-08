package edu.dani.back.wrc.service.interfaces;

import edu.dani.back.wrc.model.PatrocinadorOficial;

import java.util.List;
import java.util.Optional;

public interface IPatrocinadorService {

    PatrocinadorOficial guardar(PatrocinadorOficial patrocinador);

    List<PatrocinadorOficial> listarTodos();
    Optional<PatrocinadorOficial> buscarPorId(Long id);

    PatrocinadorOficial actualizar(PatrocinadorOficial patrocinador);

    void eliminar(Long id);
}