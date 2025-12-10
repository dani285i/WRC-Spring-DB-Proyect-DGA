package edu.dani.back.wrc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.dani.back.wrc.model.Piloto;
import edu.dani.back.wrc.repository.IPilotoRepository;
import edu.dani.back.wrc.service.interfaces.IPilotoService;

@Service
public class PilotoServiceImpl implements IPilotoService {

    @Autowired
    private IPilotoRepository pilotoRepository;

    @Override
    public List<Piloto> getPilotos() {
        return pilotoRepository.findAll();
    }

    @Override
    public Piloto getPilotoById(Long id) {
        return pilotoRepository.findById(id).orElse(null);
    }

    @Override
    public Piloto guardarOActualizarPiloto(Piloto piloto) {
        return pilotoRepository.save(piloto);
    }

    @Override
    public Piloto deletePiloto(Long id) {

        Piloto pilotoABorrar = pilotoRepository.findById(id).orElse(null);

        if (pilotoABorrar != null) {
            pilotoRepository.deleteById(id);
        }
        return pilotoABorrar;
    }
}