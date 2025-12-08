package edu.dani.back.wrc.service;

import edu.dani.back.wrc.service.interfaces.ITramoService;
import edu.dani.back.wrc.repository.ITramoRepository;
import edu.dani.back.wrc.model.Tramo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TramoServiceImpl implements ITramoService {

    @Autowired
    private ITramoRepository tramoRepository;

    @Override
    @Transactional
    public Tramo guardar(Tramo tramo) {
        return tramoRepository.save(tramo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tramo> listarTodos() {
        return tramoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Tramo> buscarPorId(Long id) {
        return tramoRepository.findById(id);
    }

    @Override
    @Transactional
    public Tramo actualizar(Tramo tramo) {
        if (tramo.getId_tramo() != null && tramoRepository.existsById(tramo.getId_tramo())) {
            return tramoRepository.save(tramo);
        }
        return null;
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        tramoRepository.deleteById(id);
    }
}