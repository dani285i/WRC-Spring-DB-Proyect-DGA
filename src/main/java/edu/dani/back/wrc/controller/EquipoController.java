package edu.dani.back.wrc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.dani.back.wrc.model.Equipo;
import edu.dani.back.wrc.model.dto.EquipoDTO;
import edu.dani.back.wrc.mapper.EquipoMapper;
import edu.dani.back.wrc.service.interfaces.IEquipoService;

@RestController
@RequestMapping("/api/equipo")
public class EquipoController {

    @Autowired
    private IEquipoService equipoService;

    @Autowired
    private EquipoMapper equipoMapper;

    @GetMapping
    public ResponseEntity<List<EquipoDTO>> listarEquipos() {
        List<EquipoDTO> equipos = equipoService.listarTodos().stream()
                .map(equipoMapper::toDto)
                .toList();
        return ResponseEntity.ok(equipos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipoDTO> obtenerEquipoPorId(@PathVariable("id") Long id) {
        Optional<Equipo> equipoOpt = equipoService.buscarPorId(id);

        if (equipoOpt.isPresent()) {
            return ResponseEntity.ok(equipoMapper.toDto(equipoOpt.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<EquipoDTO> guardarEquipo(@RequestBody EquipoDTO equipoDto) {
        Equipo equipo = equipoMapper.toEntity(equipoDto);
        
        Equipo nuevoEquipo = equipoService.guardar(equipo);

        return ResponseEntity.status(HttpStatus.CREATED).body(equipoMapper.toDto(nuevoEquipo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipoDTO> actualizarCoche(@PathVariable("id") Long id, @RequestBody EquipoDTO equipoDto) {

        Optional<Equipo> equipoExistenteOpt = equipoService.buscarPorId(id);

        if (equipoExistenteOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Equipo equipoExistente = equipoExistenteOpt.get();
        equipoMapper.updateEquipoFromDto(equipoDto, equipoExistente);
        
        Equipo equipoActualizado = equipoService.guardar(equipoExistente);
        return ResponseEntity.ok(equipoMapper.toDto(equipoActualizado));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminarEquipo(@PathVariable("id") Long id) {
        Optional<Equipo> equipoExistente = equipoService.buscarPorId(id);
        
        if (equipoExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        equipoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}