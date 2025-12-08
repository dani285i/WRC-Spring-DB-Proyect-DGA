package edu.dani.back.wrc.service;

import edu.dani.back.wrc.service.interfaces.IPatrocinadorService;
import edu.dani.back.wrc.repository.IPatrocinadorRepository;
import edu.dani.back.wrc.model.PatrocinadorOficial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PatrocinadorServiceImpl implements IPatrocinadorService {

    @Autowired
    private IPatrocinadorRepository patrocinadorRepository;

    @Override
    @Transactional
    public PatrocinadorOficial guardar(PatrocinadorOficial patrocinador) {
        return patrocinadorRepository.save(patrocinador);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PatrocinadorOficial> listarTodos() {
        return patrocinadorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PatrocinadorOficial> buscarPorId(Long id) {
        return patrocinadorRepository.findById(id);
    }

    @Override
    @Transactional
    public PatrocinadorOficial actualizar(PatrocinadorOficial patrocinador) {
        if (patrocinador.getId_patrocinador() != null && patrocinadorRepository.existsById(patrocinador.getId_patrocinador())) {
            return patrocinadorRepository.save(patrocinador);
        }
        return null;
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        patrocinadorRepository.deleteById(id);
    }
}