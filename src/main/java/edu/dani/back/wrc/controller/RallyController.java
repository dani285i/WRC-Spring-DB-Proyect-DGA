package edu.dani.back.wrc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.dani.back.wrc.model.Rally;
import edu.dani.back.wrc.model.dto.RallyDTO;
import edu.dani.back.wrc.mapper.RallyMapper;
import edu.dani.back.wrc.service.interfaces.IRallyService;

@RestController
@RequestMapping("/api/rally")
public class RallyController {

    @Autowired
    private IRallyService rallyService;

    @Autowired
    private RallyMapper rallyMapper;

    @GetMapping
    public ResponseEntity<List<RallyDTO>> listarRallies() {
        List<RallyDTO> rallies = rallyService.listarTodos().stream()
                .map(rallyMapper::toDto)
                .toList();
        
        return ResponseEntity.ok(rallies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RallyDTO> obtenerRallyPorId(@PathVariable("id") Long id) {
        Optional<Rally> rallyOpt = rallyService.buscarPorId(id);

        if (rallyOpt.isPresent()) {
            return ResponseEntity.ok(rallyMapper.toDto(rallyOpt.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<RallyDTO> guardarRally(@RequestBody RallyDTO rallyDto) {
        Rally rally = rallyMapper.toEntity(rallyDto);
        
        Rally nuevoRally = rallyService.guardar(rally);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(rallyMapper.toDto(nuevoRally));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RallyDTO> actualizarRally(@PathVariable("id") Long id, @RequestBody RallyDTO rallyDto) {
        Rally rally = rallyMapper.toEntity(rallyDto);
        rally.setId_rally(id);

        Rally actualizado = rallyService.actualizar(rally);

        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(rallyMapper.toDto(actualizado));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminarRally(@PathVariable("id") Long id) {
        Optional<Rally> rallyExistente = rallyService.buscarPorId(id);
        
        if (rallyExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        rallyService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}