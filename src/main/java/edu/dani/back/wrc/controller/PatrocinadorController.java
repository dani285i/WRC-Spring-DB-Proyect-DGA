package edu.dani.back.wrc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.dani.back.wrc.model.PatrocinadorOficial;
import edu.dani.back.wrc.model.dto.PatrocinadorOficialDTO;
import edu.dani.back.wrc.mapper.PatrocinadorOficialMapper;
import edu.dani.back.wrc.service.interfaces.IPatrocinadorService;

@RestController
@RequestMapping("/api/patrocinador")
public class PatrocinadorController {

    @Autowired
    private IPatrocinadorService patrocinadorService;

    @Autowired
    private PatrocinadorOficialMapper patrocinadorMapper;

    @GetMapping
    public ResponseEntity<List<PatrocinadorOficialDTO>> listarPatrocinadores() {
        List<PatrocinadorOficialDTO> patrocinadores = patrocinadorService.listarTodos().stream()
                .map(patrocinadorMapper::toDto)
                .toList();
        
        return ResponseEntity.ok(patrocinadores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatrocinadorOficialDTO> obtenerPatrocinadorPorId(@PathVariable("id") Long id) {
        Optional<PatrocinadorOficial> patrocinadorOpt = patrocinadorService.buscarPorId(id);

        if (patrocinadorOpt.isPresent()) {
            return ResponseEntity.ok(patrocinadorMapper.toDto(patrocinadorOpt.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<PatrocinadorOficialDTO> guardarPatrocinador(@RequestBody PatrocinadorOficialDTO patrocinadorDto) {
        PatrocinadorOficial patrocinador = patrocinadorMapper.toEntity(patrocinadorDto);
        
        PatrocinadorOficial nuevoPatrocinador = patrocinadorService.guardar(patrocinador);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(patrocinadorMapper.toDto(nuevoPatrocinador));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatrocinadorOficialDTO> actualizarPatrocinador(@PathVariable("id") Long id, @RequestBody PatrocinadorOficialDTO patrocinadorDto) {
        PatrocinadorOficial patrocinador = patrocinadorMapper.toEntity(patrocinadorDto);
        patrocinador.setId_patrocinador(id);

        PatrocinadorOficial actualizado = patrocinadorService.actualizar(patrocinador);

        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(patrocinadorMapper.toDto(actualizado));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminarPatrocinador(@PathVariable("id") Long id) {
        Optional<PatrocinadorOficial> patrocinadorExistente = patrocinadorService.buscarPorId(id);
        
        if (patrocinadorExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        patrocinadorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}