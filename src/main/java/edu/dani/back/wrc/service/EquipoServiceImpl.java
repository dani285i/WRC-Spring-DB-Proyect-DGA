package edu.dani.back.wrc.service;

import edu.dani.back.wrc.service.interfaces.IEquipoService;
import edu.dani.back.wrc.repository.IEquipoRepository;
import edu.dani.back.wrc.model.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EquipoServiceImpl implements IEquipoService {

    @Autowired
    private IEquipoRepository equipoRepository;

    @Override
    @Transactional
    public Equipo guardar(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Equipo> listarTodos() {
        return equipoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Equipo> buscarPorId(Long id) {
        return equipoRepository.findById(id);
    }

    @Override
    @Transactional
    public Equipo actualizar(Equipo equipo) {
        if (equipo.getId_equipo() != null && equipoRepository.existsById(equipo.getId_equipo())) {
            return equipoRepository.save(equipo);
        }
        return null;
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        equipoRepository.deleteById(id);
    }
}