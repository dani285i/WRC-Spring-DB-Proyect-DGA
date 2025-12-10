package edu.dani.back.wrc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.dani.back.wrc.model.Piloto;
import edu.dani.back.wrc.model.dto.PilotoDTO;
import edu.dani.back.wrc.mapper.PilotoMapper;
import edu.dani.back.wrc.service.interfaces.IPilotoService;

@RestController
@RequestMapping("/api/piloto")
public class PilotoController {

    @Autowired
    private IPilotoService pilotoService;

    @Autowired
    private PilotoMapper pilotoMapper;

    @GetMapping
    public ResponseEntity<List<PilotoDTO>> listarPilotos() {
        List<PilotoDTO> pilotos = pilotoService.getPilotos().stream()
                .map(pilotoMapper::toDto)
                .toList();

        return ResponseEntity.ok(pilotos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PilotoDTO> conseguirPilotoPorId(@PathVariable("id") Long id) {
        Piloto piloto = pilotoService.getPilotoById(id);
        
        if (piloto == null) {
            return ResponseEntity.notFound().build(); 
        }

        return ResponseEntity.ok(pilotoMapper.toDto(piloto));
    }

    @PostMapping("/save")
    public ResponseEntity<PilotoDTO> guardarPiloto(@RequestBody PilotoDTO pilotoDto) {

        Piloto piloto = pilotoMapper.toEntity(pilotoDto);

        Piloto saved = pilotoService.guardarOActualizarPiloto(piloto);

        PilotoDTO savedDto = pilotoMapper.toDto(saved);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PilotoDTO> update(@PathVariable Long id, @RequestBody PilotoDTO pilotoDTO) {
        Piloto piloto = pilotoMapper.toEntity(pilotoDTO);
        piloto.setId_piloto(id);

        Piloto saved = pilotoService.guardarOActualizarPiloto(piloto);
        
        return ResponseEntity.ok(pilotoMapper.toDto(saved));
}

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PilotoDTO> eliminarPiloto(@PathVariable("id") Long id) {
        Piloto deleted = pilotoService.deletePiloto(id);
        
        if (deleted == null) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(pilotoMapper.toDto(deleted));
    }
}