package edu.dani.back.wrc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.dani.back.wrc.model.Coche;
import edu.dani.back.wrc.model.dto.CocheDTO;
import edu.dani.back.wrc.mapper.CocheMapper;
import edu.dani.back.wrc.service.interfaces.ICocheService;

@RestController
@RequestMapping("/api/coche")
public class CocheController {

    @Autowired
    private ICocheService cocheService;

    @Autowired
    private CocheMapper cocheMapper;

    @GetMapping
    public ResponseEntity<List<CocheDTO>> listarCoches() {
        List<CocheDTO> coches = cocheService.listarTodos().stream()
                .map(cocheMapper::toDto)
                .toList();
        return ResponseEntity.ok(coches);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CocheDTO> obtenerCochePorId(@PathVariable("id") Long id) {
        Optional<Coche> cocheOpt = cocheService.buscarPorId(id);

        if (cocheOpt.isPresent()) {
            return ResponseEntity.ok(cocheMapper.toDto(cocheOpt.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<CocheDTO> guardarCoche(@RequestBody CocheDTO cocheDto) {
        Coche coche = cocheMapper.toEntity(cocheDto);

        Coche nuevoCoche = cocheService.guardar(coche);

        return ResponseEntity.status(HttpStatus.CREATED).body(cocheMapper.toDto(nuevoCoche));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CocheDTO> actualizarCoche(@PathVariable("id") Long id, @RequestBody CocheDTO cocheDto) {

        Optional<Coche> cocheExistenteOpt = cocheService.buscarPorId(id);

        if (cocheExistenteOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Coche cocheExistente = cocheExistenteOpt.get();
        cocheMapper.updateCocheFromDto(cocheDto, cocheExistente);

        Coche cocheActualizado = cocheService.guardar(cocheExistente);
        return ResponseEntity.ok(cocheMapper.toDto(cocheActualizado));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminarCoche(@PathVariable("id") Long id) {
        Optional<Coche> cocheExistente = cocheService.buscarPorId(id);
        
        if (cocheExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        cocheService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}