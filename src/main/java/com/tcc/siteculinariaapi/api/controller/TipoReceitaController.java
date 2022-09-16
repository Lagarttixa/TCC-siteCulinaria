package com.tcc.siteculinariaapi.api.controller;

import com.tcc.siteculinariaapi.api.model.TipoReceita;
import com.tcc.siteculinariaapi.api.repository.TipoReceitaRepository;
import com.tcc.siteculinariaapi.api.service.TipoReceitaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/tipoReceita")
public class TipoReceitaController {

    @Autowired
    private TipoReceitaRepository tipoReceitaRepository;

    @Autowired
    private TipoReceitaService tipoReceitaService;

    @GetMapping
    public List<TipoReceita> listar() {
        return tipoReceitaRepository.findAll();
    }

    @GetMapping("/{tipoReceitaId}")
    public ResponseEntity<TipoReceita> buscarPorId(@PathVariable Long tipoReceitaId){
        return tipoReceitaRepository.findById(tipoReceitaId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TipoReceita adicionar(@Valid @RequestBody TipoReceita tipoReceita){

        return tipoReceitaService.salvar(tipoReceita);
    }

    @DeleteMapping("/{tipoReceitaId}")
    public ResponseEntity<Void> deletar(@PathVariable Long tipoReceitaId){
        if(!tipoReceitaRepository.existsById(tipoReceitaId)){
            return ResponseEntity.notFound().build();
        }

        tipoReceitaService.excluir(tipoReceitaId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{tipoReceitaId}")
    public ResponseEntity<TipoReceita> atualizar(@Valid @PathVariable Long tipoReceitaId,
                                             @RequestBody TipoReceita tipoReceita){
        if(!tipoReceitaRepository.existsById(tipoReceitaId)){
            return ResponseEntity.notFound().build();
        }

        tipoReceita.setId(tipoReceitaId);
        tipoReceita = tipoReceitaService.salvar(tipoReceita);
        return ResponseEntity.ok(tipoReceita);
    }

}
