package edu.dani.back.wrc.service;

import edu.dani.back.wrc.service.interfaces.IPilotoService;
import edu.dani.back.wrc.repository.IPilotoRepository;
import edu.dani.back.wrc.model.Piloto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PilotoServiceImpl implements IPilotoService {

    @Autowired
    private IPilotoRepository pilotoRepository;

    @Override
    @Transactional
    public Piloto guardar(Piloto piloto) {
        return pilotoRepository.save(piloto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Piloto> listarTodos() {
        return pilotoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Piloto> buscarPorId(Long id) {
        return pilotoRepository.findById(id);
    }

    @Override
    @Transactional
    public Piloto actualizar(Piloto piloto) {
        if (piloto.getId_piloto() != null && pilotoRepository.existsById(piloto.getId_piloto())) {
            return pilotoRepository.save(piloto);
        }
        return null;
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        pilotoRepository.deleteById(id);
    }
}