package com.tcc.siteculinariaapi.api.controller;

import com.tcc.siteculinariaapi.api.model.Medidas;
import com.tcc.siteculinariaapi.api.repository.MedidaRepository;
import com.tcc.siteculinariaapi.api.service.MedidaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/medidas")
public class MedidaController {

    @Autowired
    private MedidaRepository medidaRepository;

    @Autowired
    private MedidaService medidaService;

    @GetMapping
    public List<Medidas> listar() {
        return medidaRepository.findAll();
    }

    @GetMapping("/{medidaId}")
    public ResponseEntity<Medidas> buscarPorId(@PathVariable Long medidaId){
        return medidaRepository.findById(medidaId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Medidas adicionar(@Valid @RequestBody Medidas medidas){

        return medidaService.salvar(medidas);
    }

    @DeleteMapping("/{medidaId}")
    public ResponseEntity<Void> deletar(@PathVariable Long medidaId){
        if(!medidaRepository.existsById(medidaId)){
            return ResponseEntity.notFound().build();
        }

        medidaService.excluir(medidaId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{medidaId}")
    public ResponseEntity<Medidas> atualizar(@Valid @PathVariable Long medidaId,
                                                  @RequestBody Medidas medidas){
        if(!medidaRepository.existsById(medidaId)){
            return ResponseEntity.notFound().build();
        }

        medidas.setId(medidaId);
        medidas = medidaService.salvar(medidas);
        return ResponseEntity.ok(medidas);
    }

}
