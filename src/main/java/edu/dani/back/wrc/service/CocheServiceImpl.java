package edu.dani.back.wrc.service;

import edu.dani.back.wrc.repository.ICocheRepository;
import edu.dani.back.wrc.service.interfaces.ICocheService;
import edu.dani.back.wrc.model.Coche;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;



@Service
public class CocheServiceImpl implements ICocheService {

    @Autowired
    private ICocheRepository cocheRepository;

    @Override
    @Transactional
    public Coche guardar(Coche coche) {
        return cocheRepository.save(coche);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Coche> listarTodos() {
        return cocheRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Coche> buscarPorId(Long id) {
        return cocheRepository.findById(id);
    }

    @Override
    @Transactional
    public Coche actualizar(Coche coche) {
        if (coche.getId_coche() != null && cocheRepository.existsById(coche.getId_coche())) {
            return cocheRepository.save(coche);
        }
        return null;
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        cocheRepository.deleteById(id);
    }

}
