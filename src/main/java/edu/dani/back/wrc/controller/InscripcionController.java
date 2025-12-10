package edu.dani.back.wrc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.dani.back.wrc.model.Inscripcion;
import edu.dani.back.wrc.model.dto.InscripcionDTO;
import edu.dani.back.wrc.mapper.InscripcionMapper;
import edu.dani.back.wrc.service.interfaces.IInscripcionService;

@RestController
@RequestMapping("/api/inscripcion")
public class InscripcionController {

    @Autowired
    private IInscripcionService inscripcionService;

    @Autowired
    private InscripcionMapper inscripcionMapper;

    @GetMapping
    public ResponseEntity<List<InscripcionDTO>> listarInscripciones() {
        List<InscripcionDTO> inscripciones = inscripcionService.listarTodos().stream()
                .map(inscripcionMapper::toDto)
                .toList();
        
        return ResponseEntity.ok(inscripciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InscripcionDTO> obtenerInscripcionPorId(@PathVariable("id") Long id) {
        Optional<Inscripcion> inscripcionOpt = inscripcionService.buscarPorId(id);

        if (inscripcionOpt.isPresent()) {
            return ResponseEntity.ok(inscripcionMapper.toDto(inscripcionOpt.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<InscripcionDTO> guardarInscripcion(@RequestBody InscripcionDTO inscripcionDto) {
        Inscripcion inscripcion = inscripcionMapper.toEntity(inscripcionDto);
        
        Inscripcion nuevaInscripcion = inscripcionService.guardar(inscripcion);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(inscripcionMapper.toDto(nuevaInscripcion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InscripcionDTO> actualizarInscripcion(@PathVariable("id") Long id, @RequestBody InscripcionDTO dto) {
        Optional<Inscripcion> opt = inscripcionService.buscarPorId(id);
        if (opt.isEmpty()) return ResponseEntity.notFound().build();

        Inscripcion existente = opt.get();
        inscripcionMapper.updateInscripcionFromDto(dto, existente);
        
        Inscripcion guardado = inscripcionService.guardar(existente);
        return ResponseEntity.ok(inscripcionMapper.toDto(guardado));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminarInscripcion(@PathVariable("id") Long id) {
        Optional<Inscripcion> inscripcionExistente = inscripcionService.buscarPorId(id);
        
        if (inscripcionExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        inscripcionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}