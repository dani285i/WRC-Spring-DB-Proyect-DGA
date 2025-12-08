package edu.dani.back.wrc.service;

import edu.dani.back.wrc.service.interfaces.IInscripcionService;
import edu.dani.back.wrc.repository.IInscripcionRepository;
import edu.dani.back.wrc.model.Inscripcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class InscripcionServiceImpl implements IInscripcionService {

    @Autowired
    private IInscripcionRepository inscripcionRepository;

    @Override
    @Transactional
    public Inscripcion guardar(Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Inscripcion> listarTodos() {
        return inscripcionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Inscripcion> buscarPorId(Long id) {
        return inscripcionRepository.findById(id);
    }

    @Override
    @Transactional
    public Inscripcion actualizar(Inscripcion inscripcion) {
        if (inscripcion.getId_inscripcion() != null && inscripcionRepository.existsById(inscripcion.getId_inscripcion())) {
            return inscripcionRepository.save(inscripcion);
        }
        return null;
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        inscripcionRepository.deleteById(id);
    }
}