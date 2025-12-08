package edu.dani.back.wrc.service;

import edu.dani.back.wrc.service.interfaces.IRallyService;
import edu.dani.back.wrc.repository.IRallyRepository;
import edu.dani.back.wrc.model.Rally;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RallyServiceImpl implements IRallyService {

    @Autowired
    private IRallyRepository rallyRepository;

    @Override
    @Transactional
    public Rally guardar(Rally rally) {
        return rallyRepository.save(rally);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Rally> listarTodos() {
        return rallyRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Rally> buscarPorId(Long id) {
        return rallyRepository.findById(id);
    }

    @Override
    @Transactional
    public Rally actualizar(Rally rally) {
        if (rally.getId_rally() != null && rallyRepository.existsById(rally.getId_rally())) {
            return rallyRepository.save(rally);
        }
        return null;
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        rallyRepository.deleteById(id);
    }
}