package edu.dani.back.wrc.service.interfaces;

import java.util.List;
import edu.dani.back.wrc.model.Piloto;

public interface IPilotoService {
    
    List<Piloto> getPilotos();
    
    Piloto getPilotoById(Long id);
    
    Piloto guardarOActualizarPiloto(Piloto piloto);
    
    Piloto deletePiloto(Long id);
}