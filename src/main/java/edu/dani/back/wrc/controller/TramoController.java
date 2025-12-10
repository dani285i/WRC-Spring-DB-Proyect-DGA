package edu.dani.back.wrc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.dani.back.wrc.model.Tramo;
import edu.dani.back.wrc.model.dto.TramoDTO;
import edu.dani.back.wrc.mapper.TramoMapper;
import edu.dani.back.wrc.service.interfaces.ITramoService;

@RestController
@RequestMapping("/api/tramo")
public class TramoController {

    @Autowired
    private ITramoService tramoService;

    @Autowired
    private TramoMapper tramoMapper;

    @GetMapping
    public ResponseEntity<List<TramoDTO>> listarTramos() {
        List<TramoDTO> tramos = tramoService.listarTodos().stream()
                .map(tramoMapper::toDto)
                .toList();
        
        return ResponseEntity.ok(tramos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TramoDTO> obtenerTramoPorId(@PathVariable("id") Long id) {
        Optional<Tramo> tramoOpt = tramoService.buscarPorId(id);

        if (tramoOpt.isPresent()) {
            return ResponseEntity.ok(tramoMapper.toDto(tramoOpt.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<TramoDTO> guardarTramo(@RequestBody TramoDTO tramoDto) {

        Tramo tramo = tramoMapper.toEntity(tramoDto);
        
        Tramo nuevoTramo = tramoService.guardar(tramo);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(tramoMapper.toDto(nuevoTramo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TramoDTO> actualizarTramo(@PathVariable("id") Long id, @RequestBody TramoDTO dto) {
        Optional<Tramo> opt = tramoService.buscarPorId(id);
        if (opt.isEmpty()) return ResponseEntity.notFound().build();

        Tramo existente = opt.get();
        tramoMapper.updateTramoFromDto(dto, existente);
        
        Tramo guardado = tramoService.guardar(existente);
        return ResponseEntity.ok(tramoMapper.toDto(guardado));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminarTramo(@PathVariable("id") Long id) {
        Optional<Tramo> tramoExistente = tramoService.buscarPorId(id);
        
        if (tramoExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        tramoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}